import React, { useState } from 'react'
import { Box, Button, TextField, Typography, Container } from '@mui/material'
import { useNavigate } from 'react-router-dom'
import Swal from 'sweetalert2';

export default function Register() {
    const navigate = useNavigate()
    const [name, setName] = useState('')
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')

    const handleNameChange = (event) => {
        setName(event.target.value);
    }

    const handleUserameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        const response = await fetch(`${import.meta.env.VITE_API_HOST}/register`, {
            method: "POST",
            credentials: "include",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ name, username, password }),
        })

        const data = await response.json();
        if(data.status === 'success') {
            navigate("/");
        } else {
            setUsername('');
        }

        Swal.fire({
            icon: data.status,
            title: data.status === 'success' ? 'Registro Exitoso' : (data.status === 'warning' ? 'Alerta' : 'Error'),
            text: data.message,
            timer: 2000,
            timerProgressBar: true,
        });
    }

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
            <Typography component="h1" variant="h5" sx={{ color: '#fff', mb: 2 }}>
                Registro
            </Typography>
            <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="name"
                    label="Nombre"
                    name="name"
                    autoComplete="name"
                    value={name}
                    onChange={handleNameChange}
                    autoFocus
                    InputLabelProps={{ style: { color: '#ccc' } }}
                    InputProps={{ style: { color: '#fff' } }}
                    variant="outlined"
                    sx={{ bgcolor: '#233044', borderRadius: 1, input: { color: 'white' } }}
                />

                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="username"
                    label="Usuario"
                    name="username"
                    autoComplete="username"
                    value={username}
                    onChange={handleUserameChange}
                    InputLabelProps={{ style: { color: '#ccc' } }}
                    InputProps={{ style: { color: '#fff' } }}
                    variant="outlined"
                    sx={{ bgcolor: '#233044', borderRadius: 1, input: { color: 'white' } }}
                />

                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="password"
                    label="Contraseña"
                    name="password"
                    type="password"
                    autoComplete="new-password"
                    value={password}
                    onChange={handlePasswordChange}
                    InputLabelProps={{
                        style: { color: '#ccc' }
                    }}
                    InputProps={{
                        style: { color: '#fff' }
                    }}
                    variant="outlined"
                    sx={{ bgcolor: '#233044', borderRadius: 1, input: { color: 'white' } }}
                />

                <Button
                    type="submit"
                    fullWidth
                    variant="contained"
                    sx={{ mt: 3, mb: 2, bgcolor: '#1e253a', ':hover': { bgcolor: '#3f4a61' } }}
                >
                    Registrar
                </Button>
                <Button
                    fullWidth
                    variant="outlined"
                    sx={{ color: '#fff', borderColor: '#3f4a61', ':hover': { borderColor: '#fff' } }}
                    onClick={() => navigate("/")}
                >
                    ¿Ya tienes cuenta? Inicia Sesión
                </Button>
            </Box>
        </Container>
    );
}