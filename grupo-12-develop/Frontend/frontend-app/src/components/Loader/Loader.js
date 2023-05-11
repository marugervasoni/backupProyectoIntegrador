import React from "react";
import { ThreeCircles } from "react-loader-spinner";

export const Loader = () => {
  return (
    <div
      style={{
        position: "fixed",
        zIndex: "1000",
        top: "0",
        left: "0",
        backgroundColor: "#fafafa50",
        width: "100vw",
        height: "100vh",
        display: "flex",
        alignItems: "center",
        justifyContent: "center",
      }}
    >
      <ThreeCircles
        height="150px"
        width="150px"
        color="#4fa94d"
        wrapperStyle={{}}
        wrapperClass=""
        visible={true}
        ariaLabel="three-circles-rotating"
        outerCircleColor="var(--gray-color)"
        innerCircleColor="var(--gray-color)"
        middleCircleColor="var(--gray-color)"
      />
    </div>
  );
};
