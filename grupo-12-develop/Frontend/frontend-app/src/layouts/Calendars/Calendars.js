import React, { useEffect, useState } from "react";
import "react-datepicker/dist/react-datepicker.css"; // Estilos de la librería
import DatePicker from "react-datepicker";

export const Calendars = ({ className }) => {
  const [isMobile, setIsMobile] = useState(2);

  //choose the screen size
  const handleCalendarResize = () => {
    if (window.innerWidth < 700) {
      setIsMobile(1);
    } else {
      setIsMobile(2);
    }
  };

  // create an event listener
  useEffect(() => {
    window.addEventListener("resize", handleCalendarResize);
  });

  const [startDate, setStartDate] = useState(null);
  const [endDate, setEndDate] = useState(null);
  const onChange = (dates) => {
    const [start, end] = dates;
    setStartDate(start);
    setEndDate(end);
  };

  return (
    <DatePicker
      className={className}
      inline
      selected={startDate}
      onChange={onChange}
      startDate={startDate}
      endDate={endDate}
      selectsRange
      monthsShown={isMobile}
    />
  );
};
