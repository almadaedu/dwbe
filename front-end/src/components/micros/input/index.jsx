import React from "react";
import "./styles.css";

const Input = ({ type, placeholder, onChange, value, mask }) => {
  return (
    <div className="input">
      <input
        type={type}
        placeholder={placeholder}
        onChange={onChange}
        value={value}
        mask={mask}
      ></input>
    </div>
  );
};

export default Input;
