import React from "react";
import "./styles.css";

const Button = ({ placeholder }) => {
  return (
    <div>
      <input type="submit" placeholder={placeholder}></input>
    </div>
  );
};

export default Button;
