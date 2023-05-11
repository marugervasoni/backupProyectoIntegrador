import React, { useContext } from "react";
import AuthContext from "../../context/AuthContext";
import { SocialMediaButtons } from "../SocialMediaButtons/SocialMediaButtons";
import styles from "./index.module.css";

export const Footer = () => {
  const { isMobile } = useContext(AuthContext);

  return (
    <footer className={styles.footer}>
      <h3>©2021 Digital Booking</h3>
      {!isMobile && <SocialMediaButtons />}
    </footer>
  );
};
