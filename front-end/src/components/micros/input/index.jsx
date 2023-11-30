import React from "react";
import "./styles.css";

const Input = ({ type, placeholder, onChange, value, name }) => {
  return (
    <div className="input">
      <input
        type={type}
        name={name}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
      ></input>
    </div>
  );
};

export default Input;
