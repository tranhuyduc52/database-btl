import './UserProduct.css';
import { useState } from 'react';


function UserDetailProduct({ toggle, toggleVisibility}) {
    return (
        <>
            <div className="detail-product"
            id="detail-product"
            style={{
                transform: toggle ? 'translateX(0)' : 'translateX(100%)',
                opacity: toggle ? 1 : 0,
                transition: 'all 0.2s ease',
            }}>
                <div className="detail-product-middle">
                    <svg xmlns="http://www.w3.org/2000/svg"
                    viewBox="0 0 384 512"
                    className="detail-product-middle-svg"
                    onClick={toggleVisibility}>
                        <path d="M342.6 150.6c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L192 210.7 86.6 105.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3L146.7 256 41.4 361.4c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L192 301.3 297.4 406.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3L237.3 256 342.6 150.6z"/>
                    </svg>
                    <div className="detail-product-middle-left">
                        <div className="detail-product-middle-left-box">
                            <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} 
                            alt="" className="detail-product-middle-left-img"/>
                            <p className="detail-product-middle-left-name">
                                Phindi Cassia
                            </p>
                        </div>
                    </div>
                    <div className="detail-product-middle-right">
                        <div className="detail-product-middle-right-box">
                            <div className="detail-product-middle-right-top">
                                <p className="detail-product-middle-right-evaluate">
                                    Đánh giá sản phẩm
                                </p>
                                <div className="detail-product-middle-right-rate">
                                    5 trên 5
                                </div>
                            </div>
                            <ul className="detail-product-middle-right-ul">
                                <li className="detail-product-middle-right-li">
                                    <div className="detail-product-middle-right-user">
                                        <p className="detail-product-middle-right-name">
                                            hngvnphmth855
                                        </p>
                                        <div className="detail-product-middle-right-star">
                                            <span data-value="5" title="5 sao">&#9733;</span>
                                            <span data-value="4" title="4 sao">&#9733;</span>
                                            <span data-value="3" title="3 sao">&#9733;</span>
                                            <span data-value="2" title="2 sao">&#9733;</span>
                                            <span data-value="1" title="1 sao">&#9733;</span>
                                        </div>
                                        <p className="detail-product-middle-right-date">
                                            2/12/2024 10:25
                                        </p>
                                        <p className="detail-product-middle-right-comment">
                                            Đồ uống dở ẹc
                                        </p>
                                    </div>
                                    <img src={require(`../img/Avatar.png`)} alt="" className="detail-product-middle-right-ava"/>
                                </li>
                                <li className="detail-product-middle-right-li">
                                    <div className="detail-product-middle-right-user">
                                        <p className="detail-product-middle-right-name">
                                            hngvnphmth855
                                        </p>
                                        <div className="detail-product-middle-right-star">
                                            <span data-value="5" title="5 sao">&#9733;</span>
                                            <span data-value="4" title="4 sao">&#9733;</span>
                                            <span data-value="3" title="3 sao">&#9733;</span>
                                            <span data-value="2" title="2 sao">&#9733;</span>
                                            <span data-value="1" title="1 sao">&#9733;</span>
                                        </div>
                                        <p className="detail-product-middle-right-date">
                                            2/12/2024 10:25
                                        </p>
                                        <p className="detail-product-middle-right-comment">
                                            Đồ uống dở ẹc
                                        </p>
                                    </div>
                                    <img src={require(`../img/Avatar.png`)} alt="" className="detail-product-middle-right-ava"/>
                                </li>
                                <li className="detail-product-middle-right-li">
                                    <div className="detail-product-middle-right-user">
                                        <p className="detail-product-middle-right-name">
                                            hngvnphmth855
                                        </p>
                                        <div className="detail-product-middle-right-star">
                                            <span data-value="5" title="5 sao">&#9733;</span>
                                            <span data-value="4" title="4 sao">&#9733;</span>
                                            <span data-value="3" title="3 sao">&#9733;</span>
                                            <span data-value="2" title="2 sao">&#9733;</span>
                                            <span data-value="1" title="1 sao">&#9733;</span>
                                        </div>
                                        <p className="detail-product-middle-right-date">
                                            2/12/2024 10:25
                                        </p>
                                        <p className="detail-product-middle-right-comment">
                                            Đồ uống dở ẹc
                                        </p>
                                    </div>
                                    <img src={require(`../img/Avatar.png`)} alt="" className="detail-product-middle-right-ava"/>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </>
    );
}

function UserProduct() {
    const [toggle, settoggle] = useState(false);

    const toggleDetail = () => {
        settoggle(!toggle);
    }

    return (
        <>
            <div className="product">
                <div className="product-best-choice">
                    <div className="box-with-margin">
                        <div className="product-best-choice-left">
                            <h6>Sản phẩm của chúng tôi</h6>
                            <p>
                                Khám phá bộ sưu tập cà phê tinh tế của chúng tôi, 
                                nơi tôn vinh hương vị đậm đà và nghệ thuật pha chế. 
                                Từ hạt cà phê nguyên chất đến các loại cà phê pha sẵn, mỗi sản phẩm đều là minh chứng cho chất lượng, phong cách, và sự quyến rũ vượt thời gian của cà phê.
                            </p>
                            <div className="product-best-choice-2img">
                                <div className="product-best-choice-image">
                                    <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                    />
                                    <div className="product-best-choice-image-intro">
                                        <h6>Phindi Cassia</h6>
                                        <p>55.000đ</p>
                                    </div>
                                </div>
                                <div className="product-best-choice-image">
                                    <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                    />
                                    <div className="product-best-choice-image-intro">
                                        <h6>Phindi Cassia</h6>
                                        <p>55.000đ</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="product-best-choice-right">
                            <div className="product-best-choice-2img">
                                <div className="product-best-choice-image">
                                    <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                    />
                                    <div className="product-best-choice-image-intro">
                                        <h6>Phindi Cassia</h6>
                                        <p>55.000đ</p>
                                    </div>
                                </div>
                                <div className="product-best-choice-image">
                                    <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                    />
                                    <div className="product-best-choice-image-intro">
                                        <h6>Phindi Cassia</h6>
                                        <p>55.000đ</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div className="product-most-popular">
                    <div className="box-with-margin-popular">
                        <p className="product-most-popular-title">
                            Phổ biến nhất
                        </p>
                        <p className="product-most-popular-introduce">
                            Khám phá những sản phẩm mới nhất tại cửa hàng</p>
                        <table className="product-most-popular-table">
                            <tbody className="product-most-popular-body">
                                <tr className="most-popular-table-row">
                                    <td className="most-popular-table-cl1">
                                        <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                        onClick={toggleDetail}/>
                                        <p className="most-popular-table-name-product"
                                        onClick={toggleDetail}>
                                            Phindi Cassia
                                        </p>
                                        <p className="most-popular-table-price">
                                            55.000đ
                                        </p>
                                    </td>
                                    <td className="most-popular-table-cl1">
                                        <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                        onClick={toggleDetail}/>
                                        <p className="most-popular-table-name-product"
                                        onClick={toggleDetail}>
                                            Phindi Cassia
                                        </p>
                                        <p className="most-popular-table-price">
                                            55.000đ
                                        </p>
                                    </td>
                                    <td className="most-popular-table-cl1">
                                        <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                        onClick={toggleDetail}/>
                                        <p className="most-popular-table-name-product"
                                        onClick={toggleDetail}>
                                            Phindi Cassia
                                        </p>
                                        <p className="most-popular-table-price">
                                            55.000đ
                                        </p>
                                    </td>
                                    <td className="most-popular-table-cl1">
                                        <img src={require(`../img/270_crop_Phindi_Cassia_Highlands_products_Image1.jpg`)} alt=""
                                        onClick={toggleDetail}/>
                                        <p className="most-popular-table-name-product"
                                        onClick={toggleDetail}>
                                            Phindi Cassia
                                        </p>
                                        <p className="most-popular-table-price">
                                            55.000đ
                                        </p>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <UserDetailProduct toggle={toggle} toggleVisibility={toggleDetail}/>
        </>
    );
}

export default UserProduct;