import './App.css';
import UserGiftExchange from './component/UserGiftExchange';
import HeaderHomePage from './component/UserHeaderHP';
import UserInfo from './component/UserInfo';
import UserProduct from './component/UserProduct';
import UserRegist from './component/UserRegist';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';

function UserLogin() {
  return (
    <>
      <UserRegist/>
    </>
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


function App() {
  return (
    <>
      <UserLogin/>

      <Router>
        <Routes>
          <Route path='/' element={<UserHomePage/>}/>
          <Route path='/product' element={<UserProductPage/>}/>
          <Route path='/exchange' element={<UserExchangePage/>}/>
          <Route path='/info' element={<UserInfoPage/>}/>
        </Routes>
      </Router>
    </>
  );
}

export default App;
