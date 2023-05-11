import React from "react";
import { Card } from "../../components/Card/Card";
import styles from "./index.module.css";

export const CardList = ({ data }) => {
  return (
    <section>
      <h2
        style={{
          fontSize: "2rem",
          color: "var(--darkBlue-color)",
          fontWeight: "bold",
          padding: "10px 40px",
        }}
      >
        Recomendaciones
      </h2>
      <div className={styles.containerCardList}>
        <div className={styles.cardList}>
          {data?.map((card, index) => (
            <Card
              key={card.id}
              id={card.id}
              img={card.img}
              category={card.category}
              title={card.title}
              location={card.location}
              description={card.description}
            />
          ))}
        </div>
      </div>
    </section>
  );
};
