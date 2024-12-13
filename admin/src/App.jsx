import React from 'react';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import DangNhap from './components/DangNhap'; 
import Admin_HomePage from './components/Admin_HomePage'; 
import Admin_ManageWorkSchedule from './components/Admin_ManageWorkSchedule'; 
import Admin_ManageEmployee from './components/Admin_ManageEmployee'; 
import Admin_ManageProduct from './components/Admin_ManageProduct'; 
import Admin_ManageOrder from './components/Admin_ManageOrder'; 

import Emp_Header from './components/Emp_Header'; 
import Emp_OrderForm from './components/Emp_OrderForm'; 
import Emp_HistoryGift from './components/Emp_HistoryGift'; 
import Emp_PersonalInfo from './components/Emp_PersonalInfo';
import Admin_ManageWorkSchedule_Edit from './components/Admin_ManageWorkSchedule_Edit'; 
import Admin_ManageEmployee_Edit from './components/Admin_ManageEmployee_Edit';
import Admin_ManageProduct_Edit from './components/Admin_ManageProduct_Edit';
import Admin_Revenue from './components/Admin_Revenue';

function Login() {
  return (
    <DangNhap/>
  );
}

function HomePageEmp() {
  return (
    <Router>
      <Routes>
        {/* Route Emp */}
        <Route path="/emp/order-form" element={<Emp_OrderForm />} />
        <Route path="/emp/history-gift" element={<Emp_HistoryGift />} />
        <Route path="/emp/personal-info" element={<Emp_PersonalInfo />} />
      </Routes>
    </Router>
  );
}

function HomePageAdmin() {
  return (
    <Router>
      <Routes>
        <Route path="/admin/home" element={<Admin_HomePage />} />
        <Route path="/admin/manage-work-schedule" element={<Admin_ManageWorkSchedule />} />
        <Route path="/admin/manage-employee" element={<Admin_ManageEmployee />} />
        <Route path="/admin/manage-product" element={<Admin_ManageProduct />} />
        <Route path="/admin/manage-order" element={<Admin_ManageOrder />} />
        <Route path="/admin/manage-work-schedule/edit" element={<Admin_ManageWorkSchedule_Edit />} /> 
        <Route path="/admin/manage-employee/edit" element={<Admin_ManageEmployee_Edit />} /> 
        <Route path="/admin/manage-product/edit" element={<Admin_ManageProduct_Edit />} /> 
        <Route path="/admin/revenue" element={<Admin_Revenue />} /> 
      </Routes>
    </Router>
  );
}

const App = () => {
  return (
    <Router>
      <Routes>
        {/* Route Đăng nhập */}
        <Route path="/" element={<DangNhap />} />

        {/* Route Admin */}
        <Route path="/admin/home" element={<Admin_HomePage />} />
        <Route path="/admin/manage-work-schedule" element={<Admin_ManageWorkSchedule />} />
        <Route path="/admin/manage-employee" element={<Admin_ManageEmployee />} />
        <Route path="/admin/manage-product" element={<Admin_ManageProduct />} />
        <Route path="/admin/manage-order" element={<Admin_ManageOrder />} />
        <Route path="/admin/manage-work-schedule/edit" element={<Admin_ManageWorkSchedule_Edit />} /> 
        <Route path="/admin/manage-employee/edit" element={<Admin_ManageEmployee_Edit />} /> 
        <Route path="/admin/manage-product/edit" element={<Admin_ManageProduct_Edit />} /> 
        <Route path="/admin/revenue" element={<Admin_Revenue />} /> 


        {/* Route Emp */}
        <Route path="/emp/order-form" element={<Emp_OrderForm />} />
        <Route path="/emp/history-gift" element={<Emp_HistoryGift />} />
        <Route path="/emp/personal-info" element={<Emp_PersonalInfo />} />
      </Routes>
    </Router>
  );
};

export default App;
