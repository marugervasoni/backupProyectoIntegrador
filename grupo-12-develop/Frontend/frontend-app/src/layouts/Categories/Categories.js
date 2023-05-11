import React, { useEffect, useState } from "react";
import { Loader } from "../../components/Loader/Loader";
import categoryService from "../../services/categoryService";
import "./Categories.css";

function Categories({ categorySelected, handlerCategory }) {
  const [categoriesData, setCategoriesData] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await categoryService.getAllCategories();
        setCategoriesData(response);
      } catch (error) {
        console.error("error");
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, [categorySelected]);

  const onClickCategory = (id) => {
    if (id !== categorySelected) {
      handlerCategory(id);
      return;
    }
    handlerCategory(null);
  };

  return (
    <>
      {loading && <Loader />}
      <section className="category">
        <h2 className="category__title">Buscar por tipo de alojamiento</h2>
        <div className="container">
          {categoriesData.map((category) => (
            <div
              className={`container--card ${
                category.id === categorySelected
                  ? "container--cardSelected"
                  : ""
              }`}
              onClick={() => {
                onClickCategory(category.id);
              }}
              key={category.id}
            >
              <img
                className="container--card--image_url"
                src={category.imageUrl}
                alt={category.title}
              />
              <h3 className="container--card--nameCategory">
                {category.title}
              </h3>
              <p className="container--card--descriptions">
                {category.description}
              </p>
            </div>
          ))}
        </div>
      </section>
    </>
  );
}

export { Categories };
