import React, { useContext } from "react";
import { SocialMediaButtons } from "../SocialMediaButtons/SocialMediaButtons";
import styles from "./index.module.css";
import { AiOutlineClose } from "react-icons/ai";
import { Account } from "../Account/Account";
import AuthContext from "../../context/AuthContext";

export const MenuMobile = ({ handleToggleMenu }) => {
  const autCtx = useContext(AuthContext);

  return (
    <div className={styles.menu}>
      <div className={styles.menuHeader}>
        <AiOutlineClose
          className={styles.closeButton}
          onClick={handleToggleMenu}
        />
        {autCtx.isLoggedIn ? <Account /> : <h1>MENÚ</h1>}
      </div>
      <div className={styles.menuList}></div>
      <div className={styles.menuFooter}>
        <SocialMediaButtons />
      </div>
    </div>
  );
};
