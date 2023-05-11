import React, { useState } from "react";
import { CardList } from "../../layouts/CardList/CardList";
import { Categories } from "../../layouts/Categories/Categories";
import { Searcher } from "../../layouts/Searcher/Searcher";
import data from "../../mocks/CardList.json";

export const Home = () => {
  const [categorySelected, setCategorySelected] = useState(null);

  const handlerCategory = (categoryId) => {
    setCategorySelected(categoryId);
  };

  return (
    <>
      <div>
        <Searcher />
      </div>
      <div className="category">
        <Categories
          handlerCategory={handlerCategory}
          categorySelected={categorySelected}
        />
      </div>
      <div
        style={{
          display: "flex",
          flexDirection: "column",
          padding: "20px",
          gap: "20px",
          backgroundColor: "#E5E5E5",
        }}
      >
        <CardList data={data} />
      </div>
    </>
  );
};
