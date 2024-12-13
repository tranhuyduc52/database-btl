import React, { useState, useEffect } from 'react';
import Admin_Header from './Admin_Header'; 
import "../assets/css/Admin_ManageOrder.css";

const Admin_ManageOrder = () => {
    const [orderData, setOrderData] = useState([]);
    const [filters, setFilters] = useState({
        id: '',
        date: '',
        employee: '',
        customer: '',
        orderList: '',
        total: '',
        payment: '',
    });

    const [sortOrder, setSortOrder] = useState(1); // 1: ASC, -1: DESC

    const [err, setErr] = useState("");
    const [order, setOrd] = useState([]);

    // Giả lập API lấy dữ liệu đơn hàng
    useEffect(() => {
        const getOrder = async(e) => {
            const token = localStorage.getItem("token");

            try {
                const res = await axios.get(
                    "http://localhost:8080/manager/view/order",
                    {
                        headers: {
                            Authorization: `Bearer ${token}`,
                            "Content Type": "application/json",
                        }
                    }
                )
                setOrd(res.data);
            }
            catch(err) {
                setErr(err.message);
            }
        }

        const data = [
            { id: "001", date: "15:00 - 01/12/2024", employee: "Nguyễn Văn A", customer: "Khách hàng 1", orderList: "Phindi cafe x1 47.000đ, Trà sen vàng x1 46.000đ", total: "93.000 VNĐ", payment: "Tiền mặt" },
            { id: "002", date: "16:00 - 02/12/2024", employee: "Nguyễn Thị B", customer: "Khách hàng 2", orderList: "Trà xanh x1 40.000đ, Phindi choco x1 47.000đ", total: "87.000 VNĐ", payment: "Thẻ ngân hàng" },
            { id: "003", date: "17:00 - 03/12/2024", employee: "Phạm Văn C", customer: "Khách hàng 3", orderList: "Phindi vanilla x1 48.000đ, Trà sen vàng x1 45.000đ", total: "93.000 VNĐ", payment: "Tiền mặt" },
            { id: "004", date: "18:00 - 04/12/2024", employee: "Trần Thị D", customer: "Khách hàng 4", orderList: "Trà đậu đỏ x1 42.000đ, Phindi choco x1 47.000đ", total: "89.000 VNĐ", payment: "Chuyển khoản" },
            { id: "005", date: "19:00 - 05/12/2024", employee: "Lê Minh E", customer: "Khách hàng 5", orderList: "Phindi choco x1 47.000đ, Trà sen vàng x1 45.000đ", total: "92.000 VNĐ", payment: "Tiền mặt" },
        ];
        setOrderData(data);

        getOrder();
    }, []);

    // Lọc dữ liệu
    const handleFilterChange = (e) => {
        const { id, value } = e.target;
        setFilters((prev) => ({ ...prev, [id]: value.toLowerCase() }));
    };

    const filteredData = orderData.filter((order) => {
        return (
            (!filters.id || order.id.toLowerCase().includes(filters.id)) &&
            (!filters.date || order.date.toLowerCase().includes(filters.date)) &&
            (!filters.employee || order.employee.toLowerCase().includes(filters.employee)) &&
            (!filters.customer || order.customer.toLowerCase().includes(filters.customer)) &&
            (!filters.orderList || order.orderList.toLowerCase().includes(filters.orderList)) &&
            (!filters.total || order.total.toLowerCase().includes(filters.total)) &&
            (!filters.payment || order.payment.toLowerCase().includes(filters.payment))
        );
    });

    // Sắp xếp tổng tiền
    const sortTotal = () => {
        const sorted = [...orderData].sort((a, b) => {
            const totalA = parseFloat(a.total.replace(' VNĐ', '').replace('.', ''));
            const totalB = parseFloat(b.total.replace(' VNĐ', '').replace('.', ''));
            return sortOrder * (totalA - totalB);
        });
        setOrderData(sorted);
        setSortOrder(-sortOrder);
    };

    return (
        <div>
            {/* Header */}
            <Admin_Header />

            {/* Nội dung chính */}
            <h2 className="order-title">QUẢN LÝ ĐƠN HÀNG</h2>

            {/* Bảng đơn hàng */}
            <div className="order-table-container">
                <table id="order-table">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Ngày</th>
                            <th>Tên nhân viên</th>
                            <th>Tên khách hàng</th>
                            <th>Danh sách đơn</th>
                            <th>
                                Tổng tiền
                                <span className="sort-icon" onClick={sortTotal}>
                                    <i className="fa fa-sort"></i>
                                </span>
                            </th>
                            {/* <th>Phương thức thanh toán</th> */}
                        </tr>
                    </thead>
                    <tbody className="filter-row">
                        <tr>
                            <td><input type="text" id="id" className="filter-input" placeholder="Lọc theo ID" onChange={handleFilterChange} /></td>
                            <td><input type="text" id="date" className="filter-input" placeholder="Lọc theo ngày" onChange={handleFilterChange} /></td>
                            <td><input type="text" id="employee" className="filter-input" placeholder="Lọc theo nhân viên" onChange={handleFilterChange} /></td>
                            <td><input type="text" id="customer" className="filter-input" placeholder="Lọc theo khách hàng" onChange={handleFilterChange} /></td>
                            <td><input type="text" id="orderList" className="filter-input" placeholder="Lọc theo danh sách đơn" onChange={handleFilterChange} /></td>
                            <td><input type="text" id="total" className="filter-input" placeholder="Lọc theo tổng tiền" onChange={handleFilterChange} /></td>
                            {/* <td><input type="text" id="payment" className="filter-input" placeholder="Lọc theo phương thức thanh toán" onChange={handleFilterChange} /></td> */}
                        </tr>
                    </tbody>
                    <tbody id="order-data">
                        {order.map((order, index) => (
                            <tr key={index}>
                                <td>{order.id}</td>
                                <td>{order.order_time}</td>
                                <td>{order.employeeName}</td>
                                <td>{order.customerName}</td>
                                <td>
                                    {order.producList.map((item, idx) => (
                                        <>
                                            {item.productResponseDto.name}, {item.productResponseDto.unit_price},
                                            {item.productResponseDto.discount}, {item.productResponseDto.rating},
                                            {item.productResponseDto.description}, {item.productResponseDto.id}
                                        </>
                                    ))}
                                </td>
                                <td>{order.total_charge}</td>
                                {/* <td>{order.payment}</td> */}
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};

export default Admin_ManageOrder;
