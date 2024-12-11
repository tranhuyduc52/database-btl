import './UserOrder.css';
import { useState, useEffect } from 'react';
import axios from 'axios';

function UserOrder() {
    const [order, setOrder] = useState([]);
    const [err, setErr] = useState("");

    useEffect(() => {
        const token = localStorage.getItem("token");

        const fetchOrder = async(e) => {
            try {
                const res = await axios.get(
                    "http://localhost:8080/customer/order/view",
                    {
                        headers: {
                            Authorization: `Bearer ${token}`,
                            "Content-Type": "application/json",
                        }
                    }
                )
                setOrder(res.data);
                console.log(res.data);
            }
            catch(err) {
                setErr(err.message || "Something went wrong!")
            }
        }

        fetchOrder();
    }, [])

    return (
        <>
            <div className="userOrder-fullscreen">
                <div className="userOrder-center">
                    <p className="userOrder-title">
                        Đơn hàng
                    </p>
                    <div className="userOrder-box">
                        <div className="userOrder-leftBox">
                            <ul className="userOrder-leftBox-ul">
                                <li className="userOrder-leftBox-li">
                                    ID:
                                </li>
                                <li className="userOrder-leftBox-li">
                                    Tổng giá tiền:
                                </li>
                                <li className="userOrder-leftBox-li">
                                    Thời gian:
                                </li>
                                <li className="userOrder-leftBox-li">
                                    Tên nhân viên:
                                </li>
                                <li className="userOrder-leftBox-li">
                                    Tên khách hàng:
                                </li>
                            </ul>
                        </div>
                        <div className="userOrder-rightBox">
                            <ul className="userOrder-right-ul">
                                <li className="userOrder-right-li">
                                    <div className="userOrder-right-li-box">
                                        <p className="userOrder-right-li-name">
                                            Tên: aaa
                                        </p>
                                        <p className="userOrder-right-li-price">
                                            Số lượng: 10
                                        </p>
                                    </div>
                                    <div className="userOrder-right-li-box">
                                        <p className="userOrder-right-li-discount">
                                            Giảm giá: 
                                        </p>
                                        <p className="userOrder-right-li-rate">
                                            Đánh giá: 
                                        </p>
                                        <p className="userOrder-right-li-id">
                                            ID: 
                                        </p>
                                    </div>
                                    <p className="userOrder-right-description">
                                        Mô tả: 
                                    </p>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

export default UserOrder;