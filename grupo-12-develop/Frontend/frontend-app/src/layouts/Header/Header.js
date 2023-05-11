import React, { useContext } from "react";
import { Button } from "../../components/Button/Button";
import { Logo } from "../../components/Logo/Logo";
import { MenuButton } from "../MenuButton/MenuButton";
import styles from "./index.module.css";
import { useNavigate } from "react-router-dom";
import { Account } from "../Account/Account";
import AuthContext from "../../context/AuthContext";

export const Header = () => {
  const authCtx = useContext(AuthContext);

  let navigate = useNavigate();
  return (
    <header className={styles.header}>
      <Logo />
      {authCtx.isLoggedIn ? (
        !authCtx.isMobile && <Account />
      ) : (
        <div className={styles.buttons}>
          <Button
            label="Crear cuenta"
            onClick={() => navigate("/registrarse")}
          />
          <Button
            label="Iniciar sesión"
            onClick={() => navigate("/iniciar_sesion")}
          />
        </div>
      )}
      <MenuButton />
    </header>
  );
};
