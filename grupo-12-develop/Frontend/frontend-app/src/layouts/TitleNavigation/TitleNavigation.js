import React from "react";
import styles from "./index.module.css";
import { MdArrowBackIos } from "react-icons/md";
import { useNavigate } from "react-router-dom";

export const TitleNavigation = ({ title, category }) => {
  const navigate = useNavigate();

  return (
    <div>
      <div className={styles.header}>
        <div className={styles.headerTitle}>
          <span className={styles.headerCategory}>{category}</span>
          <h3 className={styles.headerName}>{title}</h3>
        </div>
        <MdArrowBackIos
          className={styles.backIcon}
          onClick={() => navigate(-1)}
        />
      </div>
    </div>
  );
};
