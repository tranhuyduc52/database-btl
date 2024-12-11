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

        {/* Route Emp */}
        <Route path="/emp/order-form" element={<Emp_OrderForm />} />
        <Route path="/emp/history-gift" element={<Emp_HistoryGift />} />
        <Route path="/emp/personal-info" element={<Emp_PersonalInfo />} />
      </Routes>
    </Router>
  );
};

export default App;
