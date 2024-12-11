import React, { useState, useRef, useEffect } from "react";
import "../assets/css/Emp_Header.css"; 
import AvatarImg from "../assets/img/avatar.svg"; 

const Emp_Header = () => {
    const [dropdownVisible, setDropdownVisible] = useState(false); // Trạng thái dropdown
    const dropdownRef = useRef(null); // Ref cho menu dropdown

    // Toggle dropdown khi nhấn vào avatar
    const toggleDropdown = () => {
        setDropdownVisible((prev) => !prev);
    };

    // Đóng dropdown khi nhấn bên ngoài
    useEffect(() => {
        const handleClickOutside = (event) => {
            if (
                dropdownRef.current &&
                !dropdownRef.current.contains(event.target) &&
                !event.target.closest(".avatar-container")
            ) {
                setDropdownVisible(false);
            }
        };

        document.addEventListener("click", handleClickOutside);
        return () => {
            document.removeEventListener("click", handleClickOutside);
        };
    }, []);

    return (
        <header className="site-header">
            <div className="header-container">
                {/* Bên trái */}
                <div className="left-section">
                    <h1 className="logo-text">COFFEE SHOP</h1>
                </div>

                {/* Bên giữa */}
                <div className="center-section">
                    <a href="/emp/order-form" className="nav-link">TẠO ĐƠN HÀNG</a>
                    <a href="/emp/history-gift" className="nav-link">LỊCH SỬ ĐỔI QUÀ</a>
                </div>

                {/* Bên phải */}
                <div className="right-section">
                    <span className="user-greeting">Xin chào, Lâm</span>
                    <div className="avatar-container" onClick={toggleDropdown}>
                        <img src={AvatarImg} alt="User Avatar" className="avatar" />
                        <div
                            className={`dropdown-menu ${dropdownVisible ? "visible" : ""}`}
                            ref={dropdownRef}
                        >
                            <a href="/emp/personal-info" className="dropdown-item">Thông tin cá nhân</a>
                            <a href="/" className="dropdown-item">Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </div>
        </header>
    );
};

export default Emp_Header;
