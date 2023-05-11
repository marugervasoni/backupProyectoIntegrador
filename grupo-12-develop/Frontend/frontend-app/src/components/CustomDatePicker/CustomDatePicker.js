import React, { useRef } from "react";
import "react-multi-date-picker/styles/colors/teal.css";
import DatePicker, { DateObject } from "react-multi-date-picker";
import transition from "react-element-popper/animations/transition";
import opacity from "react-element-popper/animations/opacity";
import "./customDatePicker.css";
import useMediaQuery from "../../hooks/useMediaQuery";

function CustomDatePicker() {
  const datePickerRef = useRef();
  const weekDays = ["S", "M", "T", "W", "T", "F", "S"];

  return (
    <DatePicker
      weekDays={weekDays}
      ref={datePickerRef}
      calendarPosition="bottom-center"
      inputClass="input-calendar"
      className="teal"
      numberOfMonths={useMediaQuery("(max-width: 726px)") ? 1 : 2}
      disableMonthPicker
      disableYearPicker
      range
      minDate={new DateObject()}
      hideYear
      placeholder="Check in - Check out"
      animations={[opacity(), transition({ from: 35, duration: 800 })]}
    >
      <button
        className="CalendarButton"
        onClick={() => datePickerRef.current.closeCalendar()}
      >
        Aplicar
      </button>
    </DatePicker>
  );
}

export default CustomDatePicker;
