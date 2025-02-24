import bcrypt from "bcryptjs";
import jwt from "jsonwebtoken";
import dotenv from "dotenv";
import pool from "../config/db.mjs";

dotenv.config();

export const register = async (req, res) => {
    const { name, username, password } = req.body;

    if (!name || !username || !password) {
        return res.status(400).json({ message: "Todos los campos son obligatorios" });
    }

    const hashedPassword = await bcrypt.hash(password, 10);

    try {
        const [result] = await pool.query(
            "INSERT INTO users (name, username, password) VALUES (?, ?)",
            [name, username, hashedPassword]
        );

        res.status(201).json({ message: "Usuario creado", userId: result.insertId });
    } catch (error) {
        res.status(500).json({ message: "Error al registrar usuario" });
    }
};

export const login = async (req, res) => {
    const { username, password } = req.body;

    try {
        const [rows] = await pool.query("SELECT * FROM users WHERE username = ?", [username]);

        if (rows.length === 0) {
            return res.status(400).json({ message: "Usuario no encontrado" });
        }

        const user = rows[0];
        const validPassword = await bcrypt.compare(password, user.password);

        if (!validPassword) {
            return res.status(400).json({ message: "Contraseña incorrecta" });
        }

        const token = jwt.sign({ id: user.id, username: user.username }, process.env.JWT_SECRET, {
            expiresIn: "1h",
        });

        res.json({ token });
    } catch (error) {
        res.status(500).json({ message: "Error en el servidor" });
    }
};