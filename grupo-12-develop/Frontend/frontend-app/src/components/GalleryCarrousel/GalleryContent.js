import React, { useContext } from "react";
import { Item } from "react-photoswipe-gallery";
import AuthContext from "../../context/AuthContext";
import { Carousel } from "react-responsive-carousel";
import styles from "./index.module.css";
import "photoswipe/dist/photoswipe.css";
import "react-responsive-carousel/lib/styles/carousel.min.css"; // requires a loader

export const GalleryContent = ({ images }) => {
  const authCtx = useContext(AuthContext);
  const imagesTail = [...images];
  const widtherImage = imagesTail.shift();

  const smallItemStyles = {
    cursor: "pointer",
    objectFit: "cover",
    width: "100%",
    maxHeight: "100%",
    height: "100%",
    borderRadius: "15px",
  };

  return (
    <>
      {authCtx.isTablet ? (
        <div style={{ padding: "20px" }}>
          <Carousel showThumbs={false}>
            {images.map((img) => (
              <div key={img.description}>
                <img
                  className={styles.carouselImg}
                  src={img.url}
                  alt={img.description}
                  width="600"
                  height="450"
                />
              </div>
            ))}
          </Carousel>
        </div>
      ) : (
        <div
          style={{
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          <div
            style={{
              height: "55vh",
              width: "90%",
              display: "grid",
              gridTemplateColumns: "2fr 1fr 1fr",
              gridTemplateRows: "45% 45%",
              gridGap: 12,
              borderRadius: "25%",
              justifyContent: "center",
              padding: "10px 0",
            }}
          >
            <Item
              original={widtherImage.url}
              thumbnail={widtherImage.url}
              width="600"
              height="500"
              alt={widtherImage.description}
            >
              {({ ref, open }) => (
                <img
                  style={{
                    cursor: "pointer",
                    width: "100%",
                    gridRow: "span 2",
                    height: "100%",
                    borderRadius: "15px",
                  }}
                  alt={widtherImage.description}
                  src={widtherImage.url}
                  ref={ref}
                  onClick={open}
                />
              )}
            </Item>
            {imagesTail.map((img, index) =>
              index <= 3 ? (
                <Item
                  original={img.url}
                  thumbnail={img.url}
                  width="600"
                  height="450"
                  alt={img.description}
                  key={img.description}
                >
                  {({ ref, open }) => (
                    <div style={{ position: "relative" }}>
                      <img
                        style={smallItemStyles}
                        src={img.url}
                        ref={ref}
                        alt={img.description}
                        onClick={open}
                      />
                      {index === 3 && (
                        <button
                          style={{
                            position: "absolute",
                            bottom: "10px",
                            right: "5px ",
                            color: "var(--white-color)",
                            border: "none",
                          }}
                          type="button"
                          onClick={() => open(1)}
                        >
                          Ver más
                        </button>
                      )}
                    </div>
                  )}
                </Item>
              ) : (
                <Item
                  original={img.url}
                  thumbnail={img.url}
                  width="600"
                  height="450"
                  alt={img.description}
                  key={img.description}
                >
                  {({ ref, open }) => <span ref={ref} onClick={open}></span>}
                </Item>
              )
            )}
          </div>
        </div>
      )}
    </>
  );
};
