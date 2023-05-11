import React, { useContext } from "react";
import logoImg from "../../assets/img/logo 1.png";
import slogan from "../../assets/img//Sentite como en tu hogar.png";
import styles from "./index.module.css";
import { useNavigate } from "react-router-dom";
import AuthContext from "../../context/AuthContext";

export const Logo = () => {
  let navigate = useNavigate();
  const { isMobile } = useContext(AuthContext);

  return (
    <div
      className={styles.logo}
      style={{
        display: "flex",
        alignItems: "center",
        gap: "10px",
      }}
      onClick={() => navigate("/")}
    >
      <img src={logoImg} alt="Logo" />
      {!isMobile && <img src={slogan} alt="Eslogan" />}
    </div>
  );
};
