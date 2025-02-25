import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { Button, Container, Typography, Card } from "@mui/material";
import Swal from 'sweetalert2';

export default function Home() {
    const navigate = useNavigate();
    const [name, setName] = useState('');
    const [username, setUsername] = useState('')

    const handleLogout = async () => {
        await fetch(`${import.meta.env.VITE_API_HOST}/logout`, {
            method: "POST",
            credentials: "include",
        });

        navigate("/");
    };

    useEffect(() => {
        const fetchData = async () => {
            const response = await fetch(`${import.meta.env.VITE_API_HOST}/validateToken`, {
                method: "GET",
                credentials: "include",
            });

            const data = await response.json();

            if (data.status === 'error') {
                console.log('TOKEN EXPIRADO');

                setTimeout(async () => {
                    await fetch(`${import.meta.env.VITE_API_HOST}/refreshToken`, {
                        method: "POST",
                        credentials: "include",
                        headers: { "Content-Type": "application/json" },
                        body: JSON.stringify({ name, username }),
                    });
                    console.log('TOKEN RENOVADO');
                }, import.meta.env.VITE_TIME_REFRESH * 1000);

            } else {
                setName(data.name);
                setUsername(data.username);
            }
        };

        // Función para manejar el intervalo
        const startInterval = () => {
            const interval = setInterval(() => {
                fetchData();
            }, 1000);

            return interval; // Retorna el intervalo para poder detenerlo más tarde
        };

        const interval = startInterval();

        // Limpiar el intervalo cuando el componente se desmonte
        return () => clearInterval(interval);
    }, [navigate, name, setName, username, setUsername]);

    return (
        <Container
                    component="main"
                    maxWidth="100%"
                    sx={{
                        display: 'flex',
                        flexDirection: 'column',
                        alignItems: 'center',
                        justifyContent: 'center',
                        minHeight: '98vh',
                        bgcolor: '#1e293a',
                        boxShadow: 3,
                        p: 3,
                    }}
                >
            <Card sx={{ padding: 4, textAlign: "center", boxShadow: 3 }}>
                <Typography variant="h4" gutterBottom>
                    Bienvenido {name} - {username}
                </Typography>
                <Button variant="contained" color="error" onClick={handleLogout}>
                    Cerrar Sesión
                </Button>
            </Card>
        </Container>
    );
}