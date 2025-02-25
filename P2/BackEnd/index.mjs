import express from "express";
import cors from "cors";
import dotenv from "dotenv";
import cookieParser from 'cookie-parser';
import authRoutes from "./routes/users.mjs";

dotenv.config();

const app = express();

app.use(cookieParser());

console.log(process.env.HOST_FRONTEND)

app.use(cors({
    origin: process.env.HOST_FRONTEND,
    credentials: true,
}));

app.use(express.json());

app.use("/", authRoutes);

const PORT = process.env.PORT || 5000;
app.listen(PORT, () => console.log(`Servidor corriendo en el puerto ${PORT}`));