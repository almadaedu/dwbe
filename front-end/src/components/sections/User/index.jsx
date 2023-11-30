import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const User = () => {
  const [name, setName] = useState("");
  const [cpf, setCpf] = useState("");
  const [birth, setBirth] = useState("");
  const [cell, setCell] = useState("");
  const [users, setUsers] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/users", {
        name,
        cpf,
        birth,
        cell,
      });

      if (response.status === 200 || response.status === 201) {
        console.log("Usuário cadastrado com sucesso!");
        setUsers([...users, { name, cpf, birth, cell }]);
      } else {
        console.error("Erro ao cadastrar usuário");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/users")
      .then((response) => setUsers(response.data))
      .catch((error) => console.error("Erro ao carregar usuários", error));
  }, []);

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Usuário</h1>
        <br />
        <label>
          Nome:
          <Input
            type="text"
            placeholder="Nome"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          CPF:
          <Input
            type="text"
            placeholder="CPF"
            value={cpf}
            onChange={(e) => setCpf(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          Data de Nascimento:
          <Input
            type="date"
            value={birth}
            onChange={(e) => setBirth(e.target.value)}
            required
          />
        </label>
        <br />
        <label>
          Número de Celular:
          <Input
            type="text"
            placeholder="Nº de Celular"
            value={cell}
            onChange={(e) => setCell(e.target.value)}
          />
        </label>
        <br />
        <Button type="submit">Cadastrar</Button>
      </form>

      {users.length > 0 && (
        <div>
          <h2>Usuários Cadastrados</h2>
          <table>
            <thead>
              <tr>
                <th>Nome</th>
                <th>CPF</th>
                <th>Data de Nascimento</th>
                <th>Nº de Celular</th>
              </tr>
            </thead>
            <tbody>
              {users.map((user, index) => (
                <tr key={index}>
                  <td>{user.name}</td>
                  <td>{user.cpf}</td>
                  <td>{user.birth}</td>
                  <td>{user.cell}</td>
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
