import React, { useState } from 'react';
import { Box, Button, TextField, Typography, Container } from '@mui/material';
import { useNavigate } from 'react-router-dom';
import Swal from 'sweetalert2';

export default function Login() {
    const navigate = useNavigate();
    const [userEmail, setUserEmail] = useState('')
    const [password, setPassword] = useState('')

    const handleUsernameChange = (event) => {
        setUserEmail(event.target.value)
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value)
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        // enviar
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
                minHeight: '98vh',
                bgcolor: '#1e293a',
                boxShadow: 3,
                p: 3,
            }}
        >
            <Typography component="h1" variant="h5" sx={{ color: '#fff', mb: 2 }}>
                Inicio de Sesión
            </Typography>
            <Box component="form" onSubmit={handleSubmit} sx={{ mt: 1 }}>
                <TextField
                    margin="normal"
                    required
                    fullWidth
                    id="usuario"
                    label="Usuario"
                    name="usuario"
                    autoComplete="usuario"
                    value={userEmail}
                    onChange={handleUsernameChange}
                    autoFocus
                    InputLabelProps={{
                        style: { color: '#ccc' }
                    }}
                    InputProps={{
                        style: { color: '#fff' }
                    }}
                    variant="outlined"
                    sx={{ bgcolor: '#233044', borderRadius: 1, input: { color: 'white' } }}
                />

                <TextField
                    margin="normal"
                    required
                    fullWidth
                    name="password"
                    label="Contraseña"
                    type="password"
                    id="password"
                    autoComplete="current-password"
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
                    Iniciar Sesión
                </Button>
                <Button
                    fullWidth
                    variant="outlined"
                    sx={{ mt: 3, mb: 2, color: '#fff', borderColor: '#3f4a61', ':hover': { borderColor: '#fff' } }}
                    onClick={() => navigate("/register")}
                >
                    Create Account
                </Button>
            </Box>
        </Container>
    );
};