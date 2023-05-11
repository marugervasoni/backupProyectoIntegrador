import React from "react";
import styles from "./index.module.css";

export const Button = ({
  label,
  type,
  onClick,
  isSecondary,
  className = "",
}) => {
  return (
    <button
      onClick={onClick}
      className={`${styles.basicButton} ${
        isSecondary ? styles.buttonSecondary : styles.buttonPrimary
      } ${className}`}
      type={type || "button"}
    >
      {label}
    </button>
  );
};
