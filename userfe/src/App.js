import './App.css';
import UserGiftExchange from './component/UserGiftExchange';
import HeaderHomePage from './component/UserHeaderHP';
import UserInfo from './component/UserInfo';
import UserProduct from './component/UserProduct';
import UserRegist from './component/UserRegist';

function UserLogin() {
  return (
    <>
      <UserRegist/>;
    </>
  );
};

function UserPage() {
  return (
    <>
      <HeaderHomePage/>;
      <UserProduct/>;
      <UserGiftExchange/>;
      <UserInfo/>;
    </>
  );
}


function App() {
  return (
    <>
      <UserLogin/>;
      {/* <UserPage/>; */}
    </>
  );
}

export default App;
