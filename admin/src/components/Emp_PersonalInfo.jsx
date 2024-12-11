import React, { useEffect, useState } from "react";
import Emp_Header from "./Emp_Header"; 
import "../assets/css/Emp_PersonalInfo.css"; 

const Emp_PersonalInfo = () => {
  const [personalInfo, setPersonalInfo] = useState(null);
  const [isEditing, setIsEditing] = useState(false); // Trạng thái chỉnh sửa

  // Giả lập dữ liệu API
  useEffect(() => {
    const mockData = {
      empId: "EMP001",
      name: "Trần Minh Hiếu",
      dob: "28/09/1999",
      gender: "Nam",
      phone: "0123456789",
      email: "hieuthuhai@coffeeshop.com",
      address: "Hóc Môn, Tp.HCM",
    };
    setTimeout(() => setPersonalInfo(mockData), 500); // Giả lập delay API
  }, []);

  // Hàm xử lý thay đổi thông tin cá nhân
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setPersonalInfo({
      ...personalInfo,
      [name]: value, // Cập nhật giá trị mới cho các trường
    });
  };

  // Hàm xử lý lưu thông tin
  const handleSave = () => {
    setIsEditing(false); // Đóng chế độ chỉnh sửa
    // Giả lập lưu thông tin (thực tế sẽ gọi API)
    console.log("Thông tin đã được lưu:", personalInfo);
  };

  return (
    <div>
      <Emp_Header /> {/* Header */}
      <main className="emp-personal-info-main-content">
        <h2>THÔNG TIN CÁ NHÂN</h2>
        {personalInfo ? (
          <div>
            <table className="personal-info-table">
              <tbody>
                <tr>
                  <td><strong>Mã Nhân viên</strong></td>
                  <td>{personalInfo.empId}</td>
                </tr>
                <tr>
                  <td><strong>Họ và tên</strong></td>
                  <td>
                    {isEditing ? (
                      <input
                        type="text"
                        name="name"
                        value={personalInfo.name}
                        onChange={handleInputChange}
                      />
                    ) : (
                      personalInfo.name
                    )}
                  </td>
                </tr>
                <tr>
                  <td><strong>Ngày tháng năm sinh</strong></td>
                  <td>
                    {isEditing ? (
                      <input
                        type="date"
                        name="dob"
                        value={personalInfo.dob}
                        onChange={handleInputChange}
                      />
                    ) : (
                      personalInfo.dob
                    )}
                  </td>
                </tr>
                <tr>
                  <td><strong>Giới tính</strong></td>
                  <td>
                    {isEditing ? (
                      <select
                        name="gender"
                        value={personalInfo.gender}
                        onChange={handleInputChange}
                      >
                        <option value="Nam">Nam</option>
                        <option value="Nữ">Nữ</option>
                        <option value="Khác">Khác</option>
                      </select>
                    ) : (
                      personalInfo.gender
                    )}
                  </td>
                </tr>
                <tr>
                  <td><strong>SĐT</strong></td>
                  <td>
                    {isEditing ? (
                      <input
                        type="text"
                        name="phone"
                        value={personalInfo.phone}
                        onChange={handleInputChange}
                      />
                    ) : (
                      personalInfo.phone
                    )}
                  </td>
                </tr>
                <tr>
                  <td><strong>Email</strong></td>
                  <td>{personalInfo.email}</td> {/* Không cho phép chỉnh sửa Email */}
                </tr>
                <tr>
                  <td><strong>Địa chỉ</strong></td>
                  <td>
                    {isEditing ? (
                      <input
                        type="text"
                        name="address"
                        value={personalInfo.address}
                        onChange={handleInputChange}
                      />
                    ) : (
                      personalInfo.address
                    )}
                  </td>
                </tr>
              </tbody>
            </table>
            {isEditing ? (
              <button className="edit-button" onClick={handleSave}>
                Lưu thay đổi
              </button>
            ) : (
              <button className="edit-button" onClick={() => setIsEditing(true)}>
                Chỉnh sửa
              </button>
            )}
          </div>
        ) : (
          <p>Đang tải...</p>
        )}
      </main>
    </div>
  );
};

export default Emp_PersonalInfo;
