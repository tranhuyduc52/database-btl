import './UserInfo.css';
import { useRef } from 'react';
import axios from 'axios';
import { useState } from 'react';
import React, { Component }  from 'react';


function UserFormInfo() {
    const nameRef = useRef();
    const addressRef = useRef();
    const emailRef = useRef();
    const phoneRef = useRef();
    const dobRef = useRef();

    const token="eyJhbGciOiJIUzM4NCJ9.eyJzdWIiOiJhYmMiLCJpYXQiOjE3MzM1NDA2ODAsImV4cCI6MTczMzU3MDY4MH0.uz9_LqUG-ckQClfFuIm0g7LEhpQjP2AffSKbA9pWz1gHMtHwjLzXfd0_K0jhXsi5";

    const [error, setError] = useState(null);

    const handleClick=async (e) => {
        e.preventDefault();
        
        const userName = nameRef.current.value;
        const userAddress = addressRef.current.value;
        const userEmail = emailRef.current.value;
        const userPhone = phoneRef.current.value;
        const userDoB = dobRef.current.value;

        const user = {
            dob:userDoB, 
            phoneNumber:userPhone, 
            address: userAddress,
            name: userName,
            email:userEmail,
            gender:"Nam"
        };
        console.log(user);

        try {
            const res = await axios.patch(
                "http://localhost:8080/customer/updateInfo",
                user, {
                    headers: {
                        Authorization: `Bearer ${token}`,
                        "Content-Type": "application/json",
                    },
                    //withCredentials: true,
                }
                
            );
        } catch(err) {
            setError(err.message || "Something went wrong");
        }
    }

    return (
        <>
            <form className='userInfo-form'>
                <h6 className="userInfo-form-title">
                    Chỉnh sửa thông tin cá nhân
                </h6>
                <ul className="userInfo-form-ul">
                    <li className="userInfo-form-li">
                        <label className='userInfo-form-label'
                        htmlFor='userName'>
                            Họ tên
                        </label>
                        <input type="text" 
                        className="userInfo-form-input" 
                        id = "userName"
                        placeholder='Nhập họ tên'
                        ref={nameRef}/>
                    </li>
                    <li className="userInfo-form-li">
                        <label htmlFor="userAddress"
                        className="userInfo-form-label">
                            Địa chỉ
                        </label>
                        <input type="text" className="userInfo-form-input" 
                        id='userAddress'
                        placeholder='Nhập địa chỉ'
                        ref={addressRef}/>
                    </li>
                    <li className="userInfo-form-li">
                        <label htmlFor="userEmail" className="userInfo-form-label">
                            Email
                        </label>
                        <input type="text" className="userInfo-form-input" 
                        id='userEmail'
                        placeholder='Nhập email'
                        ref={emailRef}/>
                    </li>
                    <li className="userInfo-form-li">
                        <label htmlFor="UserPhone" className="userInfo-form-label">
                            Số điện thoại
                        </label>
                        <input type="number" className="userInfo-form-input" 
                        id='userPhone'
                        placeholder='Nhập số điện thoại'
                        ref={phoneRef}/>
                    </li>
                    <li className="userInfo-form-li">
                        <label htmlFor="userDoB" className="userInfo-form-label">
                            Ngày sinh
                        </label>
                        <input type="date" className="userInfo-form-input" 
                        id='userDoB'
                        ref={dobRef}/>
                    </li>
                </ul>
                <button className="userInfo-form-button"
                onClick={handleClick}>
                    Gửi
                </button>
            </form>
        </>
    );
}



function UserInfo() {
    return (
        <div className='userInfoScreen'>
            <div className="userInfoScreen-mid">
                <UserFormInfo/>
            </div>
        </div>
    );
}

export default UserInfo