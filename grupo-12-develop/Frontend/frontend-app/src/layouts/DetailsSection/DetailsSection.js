import React from "react";
import styles from "./index.module.css";

export const DetailsSection = ({ subtitle, children }) => {
  return (
    <section className={styles.detailsSection}>
      <h3 className={styles.subtitle}>{subtitle}</h3>
      <hr className={styles.hr} />
      <div className={styles.container}>{children}</div>
    </section>
  );
};
