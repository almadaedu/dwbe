import React from "react";
import { Link as RouterLink } from "react-router-dom";
import "./styles.css";

const Header = () => {
  return (
    <header>
      <nav>
        <li>
          <RouterLink className="tab" to="/user">
            Usuário
          </RouterLink>
        </li>
        <li>
          <RouterLink className="tab" to="/category">
            Categoria
          </RouterLink>
        </li>
        <li>
          <RouterLink className="tab" to="/payment">
            Pagamentos
          </RouterLink>
        </li>
        <li>
          <RouterLink className="tab" to="/room">
            Quartos
          </RouterLink>
        </li>
        <li>
          <RouterLink className="tab" to="/booking">
            Reserva
          </RouterLink>
        </li>
      </nav>
    </header>
  );
};

export default Header;
