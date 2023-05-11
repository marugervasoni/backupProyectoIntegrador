import React from "react";
import { Footer } from "../../layouts/Footer/Footer";
import { Header } from "../../layouts/Header/Header";
import { Outlet } from "react-router-dom";

export const RootLayout = () => {
  return (
    <>
      <Header />
      <main
        style={{
          minHeight: "calc(100vh - 160px)",
        }}
      >
        <Outlet />
      </main>
      <Footer />
    </>
  );
};
