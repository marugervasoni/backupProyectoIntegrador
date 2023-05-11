import React from "react";
import { MdFacebook } from "react-icons/md";
import { FaLinkedinIn, FaTwitter, FaInstagram } from "react-icons/fa";

export const SocialMediaButtons = () => {
  return (
    <div
      style={{
        alignItems: "center",
        display: "flex",
        gap: "10px",
        fontSize: "30px",
      }}
    >
      <MdFacebook />
      <FaLinkedinIn />
      <FaTwitter />
      <FaInstagram />
    </div>
  );
};
