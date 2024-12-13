import React, { useState, useRef, useEffect } from 'react';
import { useNavigate } from "react-router-dom";
import "../assets/css/Admin_Header.css"; 
import AvatarImg from "../assets/img/admin-avatar.png"; 

const Admin_Header = () => {
    const [dropdownVisible, setDropdownVisible] = useState(false); // Trạng thái của dropdown
    const dropdownRef = useRef(null); // Ref để tham chiếu đến dropdown

    // Toggle dropdown khi nhấn vào avatar
    const toggleDropdown = (e) => {
        e.stopPropagation(); // Ngăn chặn sự kiện click lan truyền
        setDropdownVisible((prev) => !prev);
    };

    // Đóng dropdown khi nhấn bên ngoài
    useEffect(() => {
        const handleClickOutside = (event) => {
            // Kiểm tra nếu nhấn bên ngoài dropdown hoặc avatar
            if (
                dropdownRef.current &&
                !dropdownRef.current.contains(event.target) &&
                !event.target.closest(".avatar")
            ) {
                setDropdownVisible(false);
            }
        };

        document.addEventListener("click", handleClickOutside);

        return () => {
            document.removeEventListener("click", handleClickOutside);
        };
    }, []);


    const navigate = useNavigate();
    const handleLogout = () => {
        localStorage.removeItem("token");
        localStorage.removeItem("roles");
        navigate("/login");
        const token = localStorage.getItem("token");
        console.log(token);
    };

    return (
        <header className="admin-header">
            {/* Phần trên của header */}
            <div className="admin-header-top">
                <a href="/admin/home" className="shop-name">COFFEE SHOP</a>
                <div className="user-info">
                    <span className="welcome-text">Xin chào, Lâm</span>
                    <div className="avatar" onClick={toggleDropdown}>
                        <img src={AvatarImg} alt="Avatar" className="avatar-img" />
                        <div
                            className={dropdownVisible ? "dropdown-menu visible" : "dropdown-menu"}
                            ref={dropdownRef}
                        >
                            <span onClick={handleLogout} className="dropdown-item">
                                Đăng xuất
                            </span>
                        </div>
                    </div>
                </div>
            </div>

            {/* Phần dưới của header */}
            <div className="admin-header-bottom">
                <nav className="admin-nav">
                    <a href="/admin/manage-work-schedule" className="nav-link">QUẢN LÝ LỊCH LÀM VIỆC</a>
                    <a href="/admin/manage-employee" className="nav-link">QUẢN LÝ NHÂN VIÊN</a>
                    <a href="/admin/manage-product" className="nav-link">QUẢN LÝ SẢN PHẨM</a>
                    <a href="/admin/manage-order" className="nav-link">QUẢN LÝ ĐƠN HÀNG</a>
                    <a href="/admin/revenue" className="nav-link">BÁO CÁO DOANH THU</a>
                </nav>
            </div>
        </header>
    );
};

export default Admin_Header;
