import './UserInfo.css';
import { use, useRef } from 'react';
import axios from 'axios';
import { useState, useEffect } from 'react';
import React from 'react';


function UserFormInfo() {
    const nameRef = useRef();
    const addressRef = useRef();
    const phoneRef = useRef();
    const dobRef = useRef();

    const [selectedGender, setSelectedGender] = useState("");

    

    const handleGenderChange = (event) => {
        setSelectedGender(event.target.value);
    };

    const [error, setError] = useState(null);

    const handleClick=async (e) => {
        e.preventDefault();
        
        const name = nameRef.current.value.trim();
        const address = addressRef.current.value.trim();
        const phone = phoneRef.current.value.trim();
        const dob = dobRef.current.value;
        const gender = document.querySelector('input[name="gender"]:checked');

        if (!name || !address || !phone || !dob || !gender) {
            alert("Vui lòng điền đầy đủ thông tin trước khi gửi!");
            return;
        }

        const token = localStorage.getItem("token");
        console.log(token);

        const userName = nameRef.current.value;
        const userAddress = addressRef.current.value;
        const userPhone = phoneRef.current.value;
        const userDoB = dobRef.current.value;

        const user = {
            dob:userDoB, 
            phoneNumber:userPhone, 
            address: userAddress,
            name: userName,
            gender:selectedGender,
        };

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
            )
            console.log(res.data);
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
                        <label htmlFor="UserPhone" className="userInfo-form-label">
                            Số điện thoại
                        </label>
                        <input type="text" className="userInfo-form-input" 
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
                    <li className="userInfo-form-li">
                        <label className="userInfo-form-label">Giới tính</label>
                        <div className="userInfo-form-input-group">
                            <label>
                                <input
                                    type="radio"
                                    name="gender"
                                    value="M"
                                    className="userInfo-form-input-radio"
                                    onClick={handleGenderChange}
                                />
                                Nam
                            </label>
                            <label>
                                <input
                                    type="radio"
                                    name="gender"
                                    value="F"
                                    className="userInfo-form-input-radio"
                                    onClick={handleGenderChange}
                                />
                                Nữ
                            </label>
                        </div>
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

function UserPersonalInfo() {
    const [userInfo, setuserInfo] = useState("");
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchUserInfo = async(e) => {
            const token = localStorage.getItem("token");

            try {
                const res = await axios.get(
                    "http://localhost:8080/customer/info",
                    {
                        headers: {
                            Authorization: `Bearer ${token}`,
                            "Content-Type": "application/json",
                        },
                        //withCredentials: true,
                    },
                )
                setuserInfo(res.data);
                console.log(res.data);
            } catch(err) {
                setError(err.message || "Something went wrong!")
            }
        }

        fetchUserInfo();
    }, [])

    return (
        <>
            <div className="PersonalInfo">
                <h6 className="Pinfo-title">
                    Thông tin cá nhân
                </h6>
                <ul className="userInfo-form-ul">
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Họ tên</p>
                        <p className="Pinfo">{userInfo.name ? userInfo.name : "Chưa cập nhật"}</p>
                    </li>
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Địa chỉ</p>
                        <p className="Pinfo">{userInfo.address ? userInfo.address : "Chưa cập nhật"}</p>
                    </li>
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Email</p>
                        <p className="Pinfo">{userInfo.email ? userInfo.email : "Chưa cập nhật"}</p>
                    </li>
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Số điện thoại</p>
                        <p className="Pinfo">{userInfo.phoneNumber ? userInfo.phoneNumber : "Chưa cập nhật"}</p>
                    </li>
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Ngày sinh</p>
                        <p className="Pinfo">{userInfo.dob ? userInfo.dob : "Chưa cập nhật"}</p>
                    </li>
                    <li className="userInfo-form-li">
                        <p className="Pinfo Pinfo1">Giới tính</p>
                        <p className="Pinfo">{userInfo.gender ? userInfo.gender : "Chưa cập nhật"}</p>
                    </li>
                </ul>
            </div>
        </>
    );
}

function UserInfo() {
    return (
        <div className='userInfoScreen'>
            <div className="userInfoScreen-mid">
                <UserFormInfo/>
                <UserPersonalInfo/>
            </div>
        </div>
    );
}

export default UserInfo