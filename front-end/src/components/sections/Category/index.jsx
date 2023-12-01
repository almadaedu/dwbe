import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const User = () => {
  const [name, setName] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (dadosEnviados.some((dados) => dados.name === name)) {
      alert("Categoria já existe!");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/category", {
        name,
      });

      if (response.status === 200 || 201) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([...dadosEnviados, { name }]);
      } else {
        alert("Erro ao enviar os dados");
      }
    } catch (error) {
      alert("Erro:", error);
    }
  };

  useEffect(()=>{
    fetch("http://localhost:8080/category")
    .then(res=>res.json())
    .then((result)=>{
      setDadosEnviados(result);
    }
  )
  },[])

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
                  <td style={{padding: 10}}>{dados.name}</td>
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
