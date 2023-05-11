import React from "react";
import styles from "./index.module.css";
import { MdArrowBackIos, MdLocationPin, MdShare } from "react-icons/md";
import { AiOutlineHeart /* , AiFillHeart */ } from "react-icons/ai";
import { GalleryCarrousel } from "../../components/GalleryCarrousel/GalleryCarrousel";
import { DetailsSection } from "../../layouts/DetailsSection/DetailsSection";
import kitchenIcon from "../../assets/icons/atomo kitchen.png";
import airIcon from "../../assets/icons/atomo air 3.png";
import petIcon from "../../assets/icons/atomo pet.png";
import tvIcon from "../../assets/icons/atomo tv.png";
import wifiIcon from "../../assets/icons/atomo wifi.png";
import { Calendars } from "../../layouts/Calendars/Calendars";
import { Button } from "../../components/Button/Button";
import { TitleNavigation } from "../../layouts/TitleNavigation/TitleNavigation";
import { useNavigate } from "react-router-dom";

export const ProductDetails = () => {
  let navigate = useNavigate();

  const {
    category,
    name,
    location,
    images,
    description,
    services,
    recommendations,
  } = {
    category: "Hotel",
    name: "Hermitage Hotel",
    location: {
      city: "Buenos Aires, Ciudad Autónoma de Buenos Aires,Argentina",
      distance: "A 940m del centro",
    },
    images: [
      {
        url: "https://farm4.staticflickr.com/3894/15008518202_c265dfa55f_h.jpg",
        description: "Photo of seashore by Folkert Gorter",
      },
      {
        url: "https://farm6.staticflickr.com/5591/15008867125_b61960af01_h.jpg",
        description: "Photo of mountain lake by Samuel Rohl",
      },
      {
        url: "https://farm4.staticflickr.com/3902/14985871946_86abb8c56f_b.jpg",
        description: "Photo of fog in the village by Ales Krivec",
      },
      {
        url: "https://farm6.staticflickr.com/5584/14985868676_b51baa4071_h.jpg",
        description: "Photo of river sunset by Michael Hull",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by Thomas Lefebvre",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by Thomasasdsdsssss Lefebvre",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by Thomas asdasdasdLefebvre",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by Thomasasdasdasd Lefebvre",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by ThomasasdasdasdLefebvre",
      },
      {
        url: "https://farm4.staticflickr.com/3920/15008465772_d50c8f0531_h.jpg",
        description: "Photo of bear by Thomas Lefebvressdsda",
      },
    ],
    description: {
      subtitle: "Alójate en el corazón de Buenos Aires",
      description: `Está situado a solo unas calles de la avenida Alvear, de la avenida Quintana, del parque San Martín y del distrito de Recoleta. En las inmediaciones también hay varios lugares de interés, como la calle Florida, el centro comercial Galerías Pacífico, la zona de Puerto Madero, la plaza de Mayo y el palacio Municipal./n
      Nuestros clientes dicen que esta parte de Buenos Aires es su favorita, según los comentarios independientes./n
      El Hotel es un hotel sofisticado de 4 estrellas que goza de una ubicación tranquila, a poca distancia de prestigiosas galerías de arte, teatros, museos y zonas comerciales.Además, hay WiFi gratuita.El establecimiento sirve un desayuno variado de 07:00 a 10:30.`,
    },
    services: [
      { name: "Cocina", icon: kitchenIcon },
      { name: "Televisor", icon: tvIcon },
      { name: "Aire acondicionado", icon: airIcon },
      { name: "Wifi", icon: wifiIcon },
      { name: "Apto mascotas ", icon: petIcon },
    ],
    recommendations: [
      {
        title: "Normas de las casa",
        items: ["Check-out: 10:00", "No se permiten fiestas", "No fumar"],
      },
      {
        title: "Salud y seguridad",
        items: [
          "Se aplican las pautas de distanciamiento social y otras normas relacionadas con el coronavirus",
          "Detector de humo",
          "Depósito de seguridad",
        ],
      },
      {
        title: "Política de cancelación",
        items: [
          "Agregá las fechas de tu viaje para obtener los detalles de cancelación de esta estadía.",
        ],
      },
    ],
  };
  return (
    <section>
      <TitleNavigation category={category.toLocaleUpperCase()} title={name} />
      <div className={styles.location}>
        <div className={styles.locationDescription}>
          <span className={styles.locationCity}>
            <MdLocationPin /> {location.city}
          </span>
          <span className={styles.locationDistance}>{location.distance}</span>
        </div>
      </div>
      <div className={styles.galleryMedia}>
        <div className={styles.socialMedia}>
          <MdShare />
          <AiOutlineHeart />
        </div>
        <GalleryCarrousel images={images} />
        <div className={styles.galleryDescription}>
          <h3 className={styles["galleryDescription__subtitle"]}>
            {description.subtitle}
          </h3>
          {description.description.split("/n").map((paragraph) => (
            <p key={paragraph}>{paragraph}</p>
          ))}
        </div>
      </div>
      <DetailsSection subtitle="¿Qué ofrece este lugar?">
        {services.map((service) => (
          <span key={service.name} style={{ display: "flex", gap: "0.5rem" }}>
            <img src={service.icon} alt="hola" />
            {service.name}
          </span>
        ))}
      </DetailsSection>
      <div className={styles.calendarContainer}>
        <Calendars customClassName={styles.calendar} />
        <div className={styles.calendarSection}>
          <span>Agregá tus fechas de viaje para obtener precios exactos</span>
          <Button
            isSecondary
            label="Iniciar reserva"
            onClick={() => {
              navigate("/products/reservation");
              window.scrollTo(0, 0);
            }}
          />
        </div>
      </div>
      <DetailsSection subtitle="¿Qué tenés que saber?">
        {recommendations.map((recommendation) => (
          <ul
            style={{
              display: "flex",
              flexDirection: "column",
              gap: "20px",
              marginBottom: "15px",
              lineHeight: "17px",
            }}
            key={recommendation.title}
          >
            <h2
              style={{
                fontSize: "1.2rem",
                fontWeight: "bold",
                color: "var(--gray-color)",
                margin: "10px 0 0",
              }}
            >
              {recommendation.title}
            </h2>
            {recommendation.items.map((item) => (
              <li key={item} style={{ padding: "0 5px" }}>
                {item}
              </li>
            ))}
          </ul>
        ))}
      </DetailsSection>
    </section>
  );
};
