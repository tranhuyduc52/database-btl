import React, { useState } from 'react';
import Admin_Header from './Admin_Header'; 
import "../assets/css/Admin_ManageProduct_Edit.css"; 

const Admin_ManageProduct_Edit = () => {
    const [successMessage, setSuccessMessage] = useState(""); // Thông báo thành công cho mỗi khối

    // Hàm hiển thị thông báo sau khi nhấn nút xác nhận
    const handleConfirm = (message) => {
        setSuccessMessage(message);
        setTimeout(() => setSuccessMessage(""), 3000); // Ẩn thông báo sau 3 giây
    };

    return (
        <div>
            {/* Header */}
            <Admin_Header />

            {/* Nội dung chính */}
            <div className="manage-product-edit-content">
                {/* Vùng I */}
                <div className="section section-1">
                    {/* Khối 1 - Thêm Sản Phẩm */}
                    <div className="block">
                        <h3 className="block-title">THÊM SẢN PHẨM</h3>
                        <input type="text" className="input-field" placeholder="Tên sản phẩm" />
                        <input type="text" className="input-field" placeholder="Đơn giá" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>

                    {/* Khối 2 - Chỉnh Sửa Sản Phẩm */}
                    <div className="block">
                        <h3 className="block-title">CHỈNH SỬA SẢN PHẨM</h3>
                        <input type="text" className="input-field" placeholder="Mã ID" />
                        <input type="text" className="input-field" placeholder="Tên sản phẩm" />
                        <input type="text" className="input-field" placeholder="Đơn giá" />
                        <input type="text" className="input-field" placeholder="Giảm giá" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>

                    {/* Khối 3 - Xóa Sản Phẩm */}
                    <div className="block">
                        <h3 className="block-title">XÓA SẢN PHẨM</h3>
                        <input type="text" className="input-field" placeholder="Mã ID" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>
                </div>

                {/* Vùng II */}
                <div className="section section-2">
                    {/* Khối 1 - Thêm Quà */}
                    <div className="block">
                        <h3 className="block-title">THÊM QUÀ</h3>
                        <input type="text" className="input-field" placeholder="Tên quà" />
                        <input type="text" className="input-field" placeholder="Điểm" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>

                    {/* Khối 2 - Chỉnh Sửa Quà */}
                    <div className="block">
                        <h3 className="block-title">CHỈNH SỬA QUÀ</h3>
                        <input type="text" className="input-field" placeholder="Mã ID" />
                        <input type="text" className="input-field" placeholder="Tên quà" />
                        <input type="text" className="input-field" placeholder="Điểm" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>

                    {/* Khối 3 - Xóa Quà */}
                    <div className="block">
                        <h3 className="block-title">XÓA QUÀ</h3>
                        <input type="text" className="input-field" placeholder="Mã ID" />
                        <button className="confirm-button" onClick={() => handleConfirm("Đã xác nhận thành công")}>Xác nhận</button>
                    </div>
                </div>
            </div>

            {/* Thông báo */}
            {successMessage && (
                <div className="success-message">{successMessage}</div>
            )}
        </div>
    );
};

export default Admin_ManageProduct_Edit;
