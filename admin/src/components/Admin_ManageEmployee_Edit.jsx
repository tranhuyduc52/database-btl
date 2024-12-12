import React, { useState } from 'react';
import Admin_Header from './Admin_Header'; 
import "../assets/css/Admin_ManageEmployee_Edit.css"; 

const Admin_ManageEmployee_Edit = () => {
    const [updateMessage, setUpdateMessage] = useState(""); 

    // Thêm nhân viên mới
    const handleAddEmployeeClick = () => {
        setUpdateMessage("Thêm nhân viên thành công");
        document.querySelector('.add-employee-message-custom').style.display = 'block';
        setTimeout(() => {
            document.querySelector('.add-employee-message-custom').style.display = 'none';
        }, 3000);
    };

    // Thay đổi vị trí nhân viên
    const handleChangePositionClick = () => {
        setUpdateMessage("Thay đổi vị trí thành công");
        document.querySelector('.change-position-message-custom').style.display = 'block';
        setTimeout(() => {
            document.querySelector('.change-position-message-custom').style.display = 'none';
        }, 3000);
    };

    // Xóa nhân viên
    const handleDeleteEmployeeClick = () => {
        setUpdateMessage("Đã xóa nhân viên");
        document.querySelector('.delete-employee-message-custom').style.display = 'block';
        setTimeout(() => {
            document.querySelector('.delete-employee-message-custom').style.display = 'none';
        }, 3000);
    };

    return (
        <div>
            {/* Header */}
            <Admin_Header />

            {/* Nội dung chính */}
            <div className="work-schedule-edit-content">
                {/* Vùng I - Thêm nhân viên mới */}
                <div className="add-employee-section">
                    <h2 className="add-employee-title">THÊM NHÂN VIÊN MỚI</h2>
                    <input type="text" placeholder="Mã nhân viên" className="input-field" />
                    <input type="text" placeholder="Họ và tên" className="input-field" />
                    <input type="text" placeholder="Số điện thoại" className="input-field" />
                    <input type="password" placeholder="Password" className="input-field" />
                    <input type="text" placeholder="Vị trí" className="input-field" />
                    <input type="text" placeholder="Hệ số lương" className="input-field" />
                    <button className="submit-button-custom" onClick={handleAddEmployeeClick}>Thêm mới</button>

                    {/* Thông báo thêm nhân viên */}
                    <div className="add-employee-message-custom">
                        {updateMessage}
                    </div>
                </div>

                {/* Vùng II - Thay đổi vị trí nhân viên */}
                <div className="change-position-section">
                    <h2 className="change-position-title">THAY ĐỔI VỊ TRÍ NHÂN VIÊN</h2>
                    <input type="text" placeholder="Mã nhân viên" className="input-field" />
                    <input type="text" placeholder="Vị trí mới" className="input-field" />
                    <input type="text" placeholder="Hệ số lương mới" className="input-field" />
                    <button className="submit-button-custom" onClick={handleChangePositionClick}>Cập nhật</button>

                    {/* Thông báo thay đổi vị trí */}
                    <div className="change-position-message-custom">
                        {updateMessage}
                    </div>
                </div>

                {/* Vùng III - Xóa nhân viên */}
                <div className="delete-employee-section">
                    <h2 className="delete-employee-title">XÓA NHÂN VIÊN</h2>
                    <input type="text" placeholder="Mã nhân viên" className="input-field" />
                    <button className="submit-button-custom" onClick={handleDeleteEmployeeClick}>Xóa</button>

                    {/* Thông báo xóa nhân viên */}
                    <div className="delete-employee-message-custom">
                        {updateMessage}
                    </div>
                </div>
            </div>
        </div>
    );
};

export default Admin_ManageEmployee_Edit;
