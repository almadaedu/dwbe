import React, { useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const User = () => {
  const [name, setName] = useState("");
  const [cpf, setCpf] = useState("");
  const [birth, setBirth] = useState("");
  const [cell, setCell] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/users", {
        name,
        cpf,
        birth,
        cell,
      });

      if (response.status === 200) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          { name, cpf, birth, cell },
        ]);
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
        <h1>Cadastrar Usuário</h1>
        <br />
        <Input
          type="text"
          placeholder="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Input
          type="text"
          placeholder="CPF"
          value={cpf}
          onChange={(e) => setCpf(e.target.value)}
          mask="(^\d{3}\x2E\d{3}\x2E\d{3}\x2D\d{2}$)"
        />
        <Input
          type="text"
          placeholder="Data de nascimento"
          value={birth}
          onChange={(e) => setBirth(e.target.value)}
        />
        <Input
          type="tel"
          placeholder="Número do Telefone"
          value={cell}
          onChange={(e) => setCell(e.target.value)}
        />
        <Button type="submit">Enviar</Button>
      </form>

      {dadosEnviados.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>name</th>
                <th>CPF</th>
                <th>Data de Nascimento</th>
                <th>Número do Telefone</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td>{dados.name}</td>
                  <td>{dados.cpf}</td>
                  <td>{dados.birth}</td>
                  <td>{dados.cell}</td>
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
