import './App.css';
import HeaderHomePage from './component/UserHeaderHP';
import UserProduct from './component/UserProduct';
import UserGiftExchange from './component/UserGiftExchange';
import UserInfo from './component/UserInfo';
import UserRegist from './component/UserRegist';
import React, {useState} from 'react';

function UserLogin() {
    return (
        <UserRegist/>
    );
}

function UserHomePage() {
    return (
        <>
            <HeaderHomePage/>
            <UserProduct/>
            <UserGiftExchange/>
            <UserInfo/>
        </>
    );
}

function App() {
    return (
        <>
            <UserHomePage/>
            {/* <UserLogin/> */}
        </>
    );
}

export default App;
