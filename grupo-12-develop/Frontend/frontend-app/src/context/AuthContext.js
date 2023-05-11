import React, { useEffect, useState } from "react";

const AuthContext = React.createContext({
  isLoggedIn: false,
  onLogout: () => {},
  onLogin: (email, password) => {},
  isMobile: false,
  isTablet: false,
});

export const AuthContextProvider = (props) => {
  const [isLoggedIn, setIsLoggedIn] = useState(true);

  useEffect(() => {
    const storedUserLoggedInInformation = localStorage.getItem("isLoggedIn");

    if (storedUserLoggedInInformation === "1") {
      setIsLoggedIn(true);
    }
  }, []);

  const logoutHandler = () => {
    localStorage.removeItem("isLoggedIn");
    setIsLoggedIn(false);
  };

  const loginHandler = () => {
    localStorage.setItem("isLoggedIn", "1");
    setIsLoggedIn(true);
  };

  const [isMobile, setIsMobile] = useState(false);

  //choose the screen size
  const handleResize = () => {
    if (window.innerWidth < 600) {
      setIsMobile(true);
    } else {
      setIsMobile(false);
    }
  };

  // create an event listener
  useEffect(() => {
    window.addEventListener("resize", handleResize);
  });

  const [isTablet, setIsTablet] = useState(false);

  //choose the screen size
  const handleTabletResize = () => {
    if (window.innerWidth < 900) {
      setIsTablet(true);
    } else {
      setIsTablet(false);
    }
  };

  // create an event listener
  useEffect(() => {
    window.addEventListener("resize", handleTabletResize);
    console.log("hola");
  });

  return (
    <AuthContext.Provider
      value={{
        isLoggedIn: isLoggedIn,
        onLogout: logoutHandler,
        onLogin: loginHandler,
        isMobile: isMobile,
        isTablet: isTablet,
      }}
    >
      {props.children}
    </AuthContext.Provider>
  );
};

export default AuthContext;
