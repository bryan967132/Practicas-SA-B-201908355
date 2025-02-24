import express from "express";
import { register, login } from "../controllers/users.mjs";

const router = express.Router();

router.post("/register", register);
router.get("/login", login);

export default router;