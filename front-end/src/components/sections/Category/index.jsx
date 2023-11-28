import React, { useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const User = () => {
  const [name, setName] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/category", {
        name,
      });

      if (response.status === 200) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([...dadosEnviados, { name }]);
      } else {
        console.error("Erro ao enviar os dados");
      }
    } catch (error) {
      console.error("Erro:", error);
    }
  };

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Categoria</h1>
        <br />
        <Input
          type="text"
          placeholder="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Button type="submit">Enviar</Button>
      </form>

      {dadosEnviados.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>Nome</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td>{dados.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default User;
