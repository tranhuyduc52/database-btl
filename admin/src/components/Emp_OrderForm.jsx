import React, { useState } from "react";
import Emp_Header from "./Emp_Header"; 
import "../assets/css/Emp_OrderForm.css"; 

import traSenVangImage from "../assets/img/tra-sen-vang.svg";
import phindiChocoImage from "../assets/img/phindi.svg";
import phindiCassiaImage from "../assets/img/Phindi-Cassia.jpg";
import freezeTraxanhImage from "../assets/img/FREEZE-TRA-XANH.jpg";
import freezeChocoImage from "../assets/img/FREEZE-CHOCO.jpg";
import traThachDaoImage from "../assets/img/TRA_THANH_DAO.jpg";
import traThachVaiImage from "../assets/img/TRA_TACH_VAI.jpg";

// Hàm định dạng giá tiền
const formatPrice = (price) => {
  return price.toLocaleString("vi-VN") + "đ";
};

const Emp_OrderForm = () => {
  const [notification, setNotification] = useState(""); // Trạng thái thông báo
  const [orderDetails, setOrderDetails] = useState([]); // Lưu thông tin đơn hàng
  const [customerId, setCustomerId] = useState(""); // Mã khách hàng
  const [pointsUsed, setPointsUsed] = useState(0); // Điểm sử dụng

  // Dữ liệu sản phẩm
  const mockProductData = [
    { id: "001", name: "Trà sen vàng", price: 46000, image: traSenVangImage },
    { id: "002", name: "Phindi choco", price: 47000, image: phindiChocoImage },
    { id: "003", name: "Phindi Cassia", price: 50000, image: phindiCassiaImage },
    { id: "004", name: "Freeze trà xanh", price: 42000, image: freezeTraxanhImage },
    { id: "005", name: "Freeze Choco", price: 44000, image: freezeChocoImage },
    { id: "006", name: "Trà thanh đào", price: 45000, image: traThachDaoImage },
    { id: "007", name: "Trà thanh vải", price: 40000, image: traThachVaiImage },
    { id: "001", name: "Trà sen vàng", price: 46000, image: traSenVangImage },
    { id: "002", name: "Phindi choco", price: 47000, image: phindiChocoImage },
    { id: "003", name: "Phindi Cassia", price: 50000, image: phindiCassiaImage },
    { id: "004", name: "Freeze trà xanh", price: 42000, image: freezeTraxanhImage },
    { id: "005", name: "Freeze Choco", price: 44000, image: freezeChocoImage },
    { id: "006", name: "Trà thanh đào", price: 45000, image: traThachDaoImage },
    { id: "007", name: "Trà thanh vải", price: 40000, image: traThachVaiImage },
    { id: "001", name: "Trà sen vàng", price: 46000, image: traSenVangImage },
    { id: "002", name: "Phindi choco", price: 47000, image: phindiChocoImage },
    { id: "003", name: "Phindi Cassia", price: 50000, image: phindiCassiaImage },
    { id: "004", name: "Freeze trà xanh", price: 42000, image: freezeTraxanhImage },
    { id: "005", name: "Freeze Choco", price: 44000, image: freezeChocoImage },
    { id: "006", name: "Trà thanh đào", price: 45000, image: traThachDaoImage },
    { id: "007", name: "Trà thanh vải", price: 40000, image: traThachVaiImage },
  ];

  // Thêm món vào giỏ hàng
  const addProductToOrder = (product) => {
    const existingProduct = orderDetails.find(item => item.id === product.id);
    if (existingProduct) {
      // Nếu sản phẩm đã có trong đơn hàng, tăng số lượng
      setOrderDetails(orderDetails.map(item =>
        item.id === product.id
          ? { ...item, quantity: item.quantity + 1 }
          : item
      ));
    } else {
      // Nếu sản phẩm chưa có, thêm mới vào đơn hàng
      setOrderDetails([...orderDetails, { ...product, quantity: 1 }]);
    }

    // Thông báo "Đã thêm sản phẩm"
    setNotification("Đã thêm sản phẩm");
    setTimeout(() => setNotification(""), 1000); // Ẩn thông báo sau 1s
  };

  // Cập nhật số lượng món
  const updateQuantity = (id, action) => {
    setOrderDetails(orderDetails.map(item =>
      item.id === id
        ? { 
            ...item, 
            quantity: action === "increase" 
              ? item.quantity + 1 
              : item.quantity === 1 
              ? 0 // Xóa món khi số lượng là 1 và nhấn nút giảm
              : item.quantity - 1
        }
        : item
    ).filter(item => item.quantity > 0)); // Xóa món khỏi đơn hàng nếu số lượng là 0
  };

  // Tính tổng tiền và tích điểm
  const calculateTotal = () => {
    let subtotal = 0;
    orderDetails.forEach(item => {
      subtotal += item.price * item.quantity;
    });

    // Tính voucher giảm giá
    const discountAmount = (pointsUsed / 10 > 25 ? 25 : pointsUsed / 10) / 100;
    const totalAfterDiscount = subtotal * (1 - discountAmount);

    const pointsEarned = Math.floor(totalAfterDiscount / 100); // Tích điểm

    return {
      totalAfterDiscount,
      pointsEarned,
      discountAmount: discountAmount * 100, // Chuyển đổi về % để hiển thị
    };
  };

  // Xử lý xác nhận đơn hàng
  const handleConfirmOrder = () => {
    setNotification("Tạo đơn hàng thành công");
    setTimeout(() => {
      setNotification(""); // Reset thông báo
      setOrderDetails([]); // Reset đơn hàng
      setCustomerId(""); // Reset ID khách hàng
      setPointsUsed(0); // Reset điểm sử dụng
    }, 3000); // Sau 3 giây reset đơn hàng
  };

  const { totalAfterDiscount, pointsEarned, discountAmount } = calculateTotal();

  return (
    <div>
      <Emp_Header /> {/* Header */}
      <main className="orderform-main-content">
        <div className="menu">
          {mockProductData.map((product) => (
            <div className="item" key={product.id} onClick={() => addProductToOrder(product)}>
              <a href="#" className="product-link">
                <img src={product.image} alt={product.name} className="product-image" />
              </a>
              <p>{product.name}</p>
              <p>{formatPrice(product.price)}</p>
            </div>
          ))}
        </div>
        <div className="order">
          <h2>Đơn hàng</h2>
          <div className="order-details" id="order-details">
            <p>ID: 031224</p>
            <p>Khách hàng: 
              <input 
                type="text" 
                value={customerId} 
                onChange={(e) => setCustomerId(e.target.value)} 
                placeholder="Nhập ID khách hàng" 
              />
            </p>
            {orderDetails.map((item) => (
              <div className="order-item" key={item.id}>
                <span>{item.name}</span>
                <div className="quantity-control">
                  <span onClick={() => updateQuantity(item.id, "decrease")}>-</span>
                  <span>{item.quantity}</span>
                  <span onClick={() => updateQuantity(item.id, "increase")}>+</span>
                </div>
                <span>{formatPrice(item.price * item.quantity)}</span>
              </div>
            ))}
            <div className="summary">
              <p>Điểm sử dụng: 
                <input 
                  type="number" 
                  value={pointsUsed} 
                  onChange={(e) => setPointsUsed(Number(e.target.value))} 
                  min="0" 
                />
              </p>
              <p>Voucher giảm giá: {discountAmount}%</p>
              <p>Tích điểm: {pointsEarned}</p>
              <p><strong>Tổng: {formatPrice(totalAfterDiscount)}</strong></p>
            </div>
            <button id="confirm-order" onClick={handleConfirmOrder}>Xác nhận</button>
          </div>
        </div>
      </main>

      {/* Thông báo */}
      {notification && (
        <div className="notification show">
          {notification}
        </div>
      )}
    </div>
  );
};

export default Emp_OrderForm;
