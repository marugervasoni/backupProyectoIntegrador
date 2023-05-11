import React, { useState } from "react";
import "./index.module.css";
import { Autocomplete, TextField } from "@mui/material";

export function Select({ endpoint, placeholder }) {
  const [options, setOptions] = useState([
    { value: "1", label: "Ciudad de Panama" },
    { value: "2", label: "Buenos Aires" },
    { value: "3", label: "Bogota" },
  ]);

  return (
    <Autocomplete
      disablePortal
      id="combo-box-demo"
      options={options}
      sx={{
        backgroundColor: "var(--white-color)",
        padding: "5px",
        borderRadius: "5px",
        width: "100%",
      }}
      renderInput={(params) => (
        <TextField {...params} label="Seleccione una ciudad" />
      )}
    />
  );
}
