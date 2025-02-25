import { Route, Routes } from 'react-router-dom';
import Login from './pages/users/Login';
import Register from './pages/users/Register';
import Home from './pages/home/Home';
import './App.css';

export default function App() {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/home" element={<Home />} />
        </Routes>
    );
}