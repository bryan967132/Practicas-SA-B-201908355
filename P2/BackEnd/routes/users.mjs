import express from "express";
import { register, login, validateToken } from "../controllers/users.mjs";

const router = express.Router();

router.post("/register", register);
router.get("/login", login);
router.get("/validateToken", validateToken);

export default router;