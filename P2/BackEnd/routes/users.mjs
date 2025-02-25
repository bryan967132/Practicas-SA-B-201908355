import express from "express";
import { register, login, validateToken, logout, refreshToken } from "../controllers/users.mjs";

const router = express.Router();

router.post("/register", register);
router.post("/login", login);
router.get("/validateToken", validateToken);
router.post("/logout", logout);
router.post("/refreshToken", refreshToken);

export default router;