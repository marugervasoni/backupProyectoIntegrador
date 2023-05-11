import React from "react";
import { useForm } from "../../hooks/useForm";
import { Calendars } from "../../layouts/Calendars/Calendars";
import { DetailsSection } from "../../layouts/DetailsSection/DetailsSection";
import { TitleNavigation } from "../../layouts/TitleNavigation/TitleNavigation";
import { MdLocationPin } from "react-icons/md";
import { useNavigate } from "react-router-dom";
import { Button } from "../../components/Button/Button";
import styles from "./index.module.css";

const initialForm = {
  email: "",
  password: "",
};

const validationForm = (form) => {
  let errors = {};
  let regexName = /^[A-Za-zÑñÁáÉéÍíÓóÚúÜü\s]+$/;
  let regexEmail = /^(\w+[/./-]?){1,}@[a-z]+[/.]\w{2,}$/;

  if (!form.email.trim()) {
    errors.email = "El campo 'email' es requerido";
  } else if (!regexEmail.test(form.email.trim())) {
    errors.email = "El email ingresado es incorrecto";
  }

  if (!form.password.trim()) {
    errors.password = "El campo 'contraseña' es requerido";
  } else if (!regexName.test(form.password.trim())) {
    errors.password = "La contraseña ingresada es incorrecta";
  } else if (form.password.trim().length < 6) {
    errors.password = "La contraseña debe contener al menos 6 caracteres";
  }

  return errors;
};

export const Reservation = () => {
  const { form, errors, handleChange, handleBlur, handleSubmit } = useForm(
    initialForm,
    validationForm
  );

  let navigate = useNavigate();

  const recommendations = [
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
  ];

  return (
    <section>
      <TitleNavigation title="Hotel Arame" category="Hotel" />
      <div className={styles.mainContent}>
        <div className={styles.content}>
          <h2>Completá tus datos</h2>
          <div className={styles.containerUserInfo}>
            <div className={styles.userInfo}>
              <span className={styles.labelContainer}>
                <label className={styles.label}>Nombre</label>
                <input
                  id={styles.mail}
                  className={styles.input}
                  type="email"
                  name="email"
                  placeholder="Escribe tu Nombre"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={form.email}
                  required
                />
                {errors.email && (
                  <p className={styles.errores}> {errors.email} </p>
                )}
              </span>
              <span className={styles.labelContainer}>
                <label className={styles.label}>Apellido</label>
                <input
                  id={styles.mail}
                  className={styles.input}
                  type="email"
                  name="email"
                  placeholder="Escribe tu Apellido"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={form.email}
                  required
                />
                {errors.email && (
                  <p className={styles.errores}> {errors.email} </p>
                )}
              </span>
              <span className={styles.labelContainer}>
                <label className={styles.label}>Correo electronico</label>
                <input
                  id={styles.mail}
                  className={styles.input}
                  type="email"
                  name="email"
                  placeholder="Escribe tu email"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={form.email}
                  required
                />
                {errors.email && (
                  <p className={styles.errores}> {errors.email} </p>
                )}
              </span>
              <span className={styles.labelContainer}>
                <label className={styles.label}>Ciudad</label>
                <input
                  id={styles.mail}
                  className={styles.input}
                  type="email"
                  name="email"
                  placeholder="Escribe tu Ciudad"
                  onBlur={handleBlur}
                  onChange={handleChange}
                  value={form.email}
                  required
                />
                {errors.email && (
                  <p className={styles.errores}> {errors.email} </p>
                )}
              </span>
            </div>
          </div>
          <h2>Seleccioná tu fecha de reserva</h2>

          <div className={styles.calendarContainer}>
            <Calendars customClassName={styles.calendar} />
          </div>
        </div>
        <article className={styles.reservationInfo}>
          <h2>Detalle de reserva</h2>
          <div className={styles.card}>
            <img
              className={styles.reservationInfoImg}
              src={` https://images.unsplash.com/photo-1571896349842-33c89424de2d?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=580&q=80`}
              alt="Esta imagen no esta disponible en estos momentos"
            />
            <div className={styles.container}>
              <div className={styles.reservationInfoContent}>
                <h4 className={styles.reservationInfoCategory}>HOTEL</h4>
                <h3 className={styles.title}>Hermitage Hotel</h3>
                <div className={styles.location}>
                  <MdLocationPin />{" "}
                  <span>
                    Av. Colón 1643, Buenos Aires, Ciudad Autónoma de Buenos
                    Aires, Argentina
                  </span>
                </div>
              </div>
              <div
                style={{
                  display: "flex",
                  justifyContent: "center",
                  marginTop: "20px",
                  flexDirection: "column",
                  gap: "10px",
                }}
              >
                <span>Check in </span>
                <span>Check out </span>
                <Button
                  className={styles.showMoreButton}
                  onClick={() => {
                    navigate(`/products/`);
                    window.scrollTo(0, 0);
                  }}
                  isSecondary
                  label="Confirmar Reserva"
                />
              </div>
            </div>
          </div>
        </article>
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
