import React, { useContext, useState } from "react";
import ReactDOM from "react-dom";
import { MenuMobile } from "../MenuMobile/MenuMobile";
import { GiHamburgerMenu } from "react-icons/gi";
import styles from "./index.module.css";
import AuthContext from "../../context/AuthContext";

export const MenuButton = () => {
  const [toggleMenu, setToggleMenu] = useState(false);
  const { isMobile } = useContext(AuthContext);

  const handleToggleMenu = () => {
    setToggleMenu(!toggleMenu);
  };

  return (
    <>
      <GiHamburgerMenu
        className={styles.menuButton}
        onClick={handleToggleMenu}
      />
      {toggleMenu &&
        ReactDOM.createPortal(
          isMobile && (
            <div>
              <MenuMobile handleToggleMenu={handleToggleMenu} />
            </div>
          ),
          document.getElementById("modal")
        )}
    </>
  );
};
