import { Route, Routes } from 'react-router-dom';
import Login from './pages/users/Login';
import Signup from './pages/users/Signup';
import Home from './pages/home/Home';
import './App.css';

export default function App() {
    return (
        <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/signup" element={<Signup />} />
            <Route path="/home" element={<Home />} />
        </Routes>
    );
}