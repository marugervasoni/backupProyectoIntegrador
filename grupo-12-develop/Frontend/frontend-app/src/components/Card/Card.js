import React from "react";
import { Button } from "../Button/Button";
import { useNavigate } from "react-router-dom";
import { MdLocationPin } from "react-icons/md";
import styles from "./index.module.css";

export const Card = ({ img, category, title, location, description, id }) => {
  let navigate = useNavigate();
  const formatDescription =
    description.length > 130 ? (
      <p className={styles.description}>
        {description.substring(0, 120)}
        <a className={styles.showMore} href="/">
          {" "}
          más...
        </a>
      </p>
    ) : (
      <p className={styles.description}>{description}</p>
    );
  return (
    <div className={styles.card}>
      <img
        className={styles.img}
        src={img}
        alt="Esta imagen no esta disponible en estos momentos"
      />
      <div className={styles.container}>
        <div className={styles.content}>
          <h3 className={styles.category}>{category.toUpperCase()}</h3>
          <h2 className={styles.title}>{title}</h2>
          <div className={styles.location}>
            <MdLocationPin /> <span>{location}</span>
          </div>
        </div>

        {formatDescription}
        <Button
          className={styles.showMoreButton}
          onClick={() => {
            navigate(`/products/${id}`);
            window.scrollTo(0, 0);
          }}
          isSecondary
          label="Ver más"
        />
      </div>
    </div>
  );
};
