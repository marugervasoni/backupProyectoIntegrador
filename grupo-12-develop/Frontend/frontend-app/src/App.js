import React from "react";
import "./App.css";

import "@fontsource/roboto/300.css";
import "@fontsource/roboto/400.css";
import "@fontsource/roboto/500.css";
import "@fontsource/roboto/700.css";

import { RouterProvider, createBrowserRouter } from "react-router-dom";
import { RootLayout } from "./pages/Root/Root";
import Login from "./pages/Login-Form/Login";
import Register from "./pages/Registro-Form/Registro";
import { Home } from "./pages/Home/Home";
import { ProductDetails } from "./pages/ProductDetails/ProductDetails";
import { Reservation } from "./pages/Reservation/Reservation";

const router = createBrowserRouter([
  {
    path: "/",
    element: <RootLayout />,
    children: [
      { path: "/", element: <Home /> },
      { path: "/iniciar_sesion", element: <Login /> },
      { path: "/registrarse", element: <Register /> },
      { path: "/products/:productId", element: <ProductDetails /> },
      { path: "/products/reservation", element: <Reservation /> },
    ],
  },
]);

function App() {
  return <RouterProvider router={router} />;
}

export default App;
