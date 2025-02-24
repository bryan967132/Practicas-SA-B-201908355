import React from "react";
import { useNavigate } from "react-router-dom";
import { Button, Container, Typography, Card } from "@mui/material";

export default function Home() {
    const navigate = useNavigate();

    const handleLogout = () => {
        // Eliminar token o datos de sesión
        localStorage.removeItem("token");

        // Redirigir al login
        navigate("/");
    };

    return (
        <Container
                    component="main"
                    maxWidth="100%"
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        justifyContent: 'center',
                        minHeight: '100vh',
                        bgcolor: '#1e293a',
                        boxShadow: 3,
                        p: 3,
                    }}
                >
            <Card sx={{ padding: 4, textAlign: "center", boxShadow: 3 }}>
                <Typography variant="h4" gutterBottom>
                    Bienvenido
                </Typography>
                <Button variant="contained" color="error" onClick={handleLogout}>
                    Cerrar Sesión
                </Button>
            </Card>
        </Container>
    );
}