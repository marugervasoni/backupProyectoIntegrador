import React from "react";
import { Button } from "../../components/Button/Button";
import CustomDatePicker from "../../components/CustomDatePicker/CustomDatePicker";
import { Select } from "../../components/Select/Select";
import styles from "./index.module.css";

export const Searcher = () => {
  return (
    <div className={styles.searcher}>
      <h2 className={styles.title}>
        Buscar ofertas en hoteles, casas y mucho más
      </h2>
      <div className={styles.container}>
        <Select
          className={styles.select}
          placeholder="Selecciona una ciudad"
          type="text"
        />
        <CustomDatePicker className={styles.datePicker} />
        <Button isSecondary label="Buscar" className={styles.button} />
      </div>
    </div>
  );
};
