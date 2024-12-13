import './App.css';
import UserGiftExchange from './component/UserGiftExchange';
import HeaderHomePage from './component/UserHeaderHP';
import UserInfo from './component/UserInfo';
import UserProduct from './component/UserProduct';
import UserRegist from './component/UserRegist';
import { useState, useEffect } from 'react';
import { BrowserRouter as Router, Route, Routes, Navigate } from 'react-router-dom';

function UserLogin({ onLogin }) {
  return (
    <Routes>
      <Route path="*" element={<UserRegist onLog={onLogin}/>} />
    </Routes>
  );
};

function UserHomePage() {
  return (
    <>
      <HeaderHomePage/>
    </>
  );
}

function UserProductPage() {
  return (
    <>
      <HeaderHomePage/>
      <UserProduct/>
    </>
  );
}

function UserExchangePage() {
  return (
    <>
      <HeaderHomePage/>
      <UserGiftExchange/>
    </>
  );
}

function UserInfoPage() {
  return (
    <>
      <HeaderHomePage/>
      <UserInfo/>
    </>
  );
}

function HomePage({ onLogout }) {
  return (
      <Routes>
        <Route path='/' element={<UserHomePage/>}/>
        <Route path='/product' element={<UserProductPage/>}/>
        <Route path='/exchange' element={<UserExchangePage/>}/>
        <Route path='/info' element={<UserInfoPage/>}/>
      </Routes>
  );
}


function App() {
  const [token, setToken] = useState(localStorage.getItem("token"));
  const [roles, setRoles] = useState(localStorage.getItem("roles"));

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("roles");
    setToken(null);
    setRoles(null);
  };

  useEffect(() => {
    const storedToken = localStorage.getItem("token");
    const storedRoles = localStorage.getItem("roles");
    setToken(storedToken);
    setRoles(storedRoles);
  }, []);

  return (
    <Router>
      <Routes>
        <Route path="/login/*" element={<UserLogin onLogin={() => {
          setToken(localStorage.getItem("token"));
          setRoles(localStorage.getItem("roles"));
        }} />} />
      </Routes>
      {token && roles === "ROLE_CUSTOMER" && (
        <Route path="/*" element={<HomePage onLogout={handleLogout}/>} />
      )}

      {!token && <Route path="*" element={<Navigate to="/login" replace />} />}
    </Router>
  );
}

export default App;
