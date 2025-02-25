import express from "express";
import { register, login, validateToken, logout } from "../controllers/users.mjs";

const router = express.Router();

router.post("/register", register);
router.post("/login", login);
router.get("/validateToken", validateToken);
router.post("/logout", logout);

export default router;