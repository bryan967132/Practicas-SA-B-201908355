import CryptoJS from "crypto-js";
import jwt from "jsonwebtoken";
import dotenv from "dotenv";
import pool from "../config/db.mjs";

dotenv.config();

const hash = CryptoJS.SHA256(process.env.KEY_CRYPT.slice(0, 16));
const keyhash = hash.toString(CryptoJS.enc.Base64);

function aesEncrypt(content) {
    const parsedkey = CryptoJS.enc.Utf8.parse(keyhash);
    const encrypted = CryptoJS.AES.encrypt(content, parsedkey, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7,
    });
    return encrypted.toString();
}

function aesDecrypt(word) {
    var keys = CryptoJS.enc.Utf8.parse(keyhash);
    let base64 = CryptoJS.enc.Base64.parse(word);
    let src = CryptoJS.enc.Base64.stringify(base64);
    let decrypt = CryptoJS.AES.decrypt(src, keys, {
        mode: CryptoJS.mode.ECB,
        padding: CryptoJS.pad.Pkcs7,
    });
    return decrypt.toString(CryptoJS.enc.Utf8);
}

export const register = async (req, res) => {
    const { name, username, password } = req.body;

    try {
        const encryptedUsername = aesEncrypt(username);
        const [ result ] = await pool.query(
            "SELECT 1 FROM users WHERE username = ?",
            [encryptedUsername]
        )

        if(result.length === 0) {
            const encryptedName = aesEncrypt(name);
            const encryptedPassword = aesEncrypt(password);

            await pool.query(
                "INSERT INTO users (name, username, password) VALUES (?, ?, ?)",
                [encryptedName, encryptedUsername, encryptedPassword]
            );
            res.status(201).json({ message: "Usuario creado!" });
        } else {
            res.status(201).json({ message: "El nombre de usuario ya está en uso!" });
        }

    } catch (error) {
        console.log(error)
        res.status(500).json({ message: "Error al registrar usuario!" });
    }
};

export const login = async (req, res) => {
    const { username, password } = req.query;

    try {
        const encryptedUsername = aesEncrypt(username);
        const [rows] = await pool.query("SELECT id, password FROM users WHERE username = ?", [encryptedUsername]);

        if (rows.length > 0) {
            const user = rows[0];
            const encryptedPassword = aesEncrypt(password);

            if(user.password === encryptedPassword) {
                const token = jwt.sign({ id: user.id, username: user.username }, process.env.JWT_SECRET, {
                    expiresIn: "1h",
                });
                res.json({ token });
            } else {
                res.status(400).json({ message: "Contraseña incorrecta" });
            }

        } else {
            res.status(400).json({ message: "Usuario no encontrado" });
        }
    } catch (error) {
        console.log(error)
        res.status(500).json({ message: "Error en el servidor" });
    }
};