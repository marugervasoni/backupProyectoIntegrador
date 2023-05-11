import React, { useContext } from "react";
import styles from "./index.module.css";
import { FaWindowClose } from "react-icons/fa";
import AuthContext from "../../context/AuthContext";

export const Account = () => {
  const autCtx = useContext(AuthContext);

  const userInfo = {
    initials: "DB",
    name: "Daniela Bermudez",
  };
  return (
    <div className={styles.account}>
      <span className={styles.initials}>{userInfo.initials}</span>
      <div className={styles.greeting}>
        <span>Hola,</span>
        <span className={styles.fullName}> {userInfo.name}</span>
      </div>
      <FaWindowClose className={styles.closeButton} onClick={autCtx.onLogout} />
    </div>
  );
};
