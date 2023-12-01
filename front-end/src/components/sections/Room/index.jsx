import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Room = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [category, setCategory] = useState("");
  const [roomCategory, setRoomCategory] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    if (dadosEnviados.some((dados) => dados.name === name)) {
      alert("Quarto já existe!");
      return;
    }

    try {
      const response = await axios.post("http://localhost:8080/room", {
        name,
        description,
        price,
        categoryId: category,
      });

      if (response.status === 200 || response.status === 201) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          { name, description, price, category },
        ]);
      } else {
        alert("Erro ao enviar os dados");
      }
    } catch (error) {
      alert("Erro:", error);
    }
  };

  const handleAssociateCategory = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/room/1/category/${category}`
      );

      if (response.status === 200) {
        alert("Quarto associado à reserva com sucesso!");
      } else {
        alert("Erro ao associar quarto à reserva");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  useEffect(() => {
    fetch("http://localhost:8080/room")
      .then((res) => res.json())
      .then((result) => {
        setDadosEnviados(result);
      });
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/category")
      .then((response) => setRoomCategory(response.data))
      .catch((error) => console.error("Erro ao carregar categorias", error));
  }, []);

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Quarto</h1>
        <br />
        <label>
          Nome: 
        <Input
          type="text"
          placeholder="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        </label>
        <label>
          Descrição:
        <Input
          type="text"
          placeholder="Descrição"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        </label>
        <label>
          Valor:
        <Input
          type="number"
          placeholder="Valor"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        </label>
        <label>
          Categoria:
        <select
          name="selectedRoom"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
        >
          <option>Selecione uma categoria</option>
          {roomCategory.length > 0 ? (
            roomCategory.map((category) => (
              <option key={category.id} value={category.id}>
                {category.name}
              </option>
            ))
          ) : (
            <option disabled>Carregando categorias...</option>
          )}
        </select>
        </label>
        <button type="button" onClick={handleAssociateCategory}>
            Adicionar
        </button>
        <Button type="submit">Enviar</Button>
      </form>

      {dadosEnviados.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Price</th>
                <th>Categoria</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td style={{ padding: 10 }}>{dados.name}</td>
                  <td style={{ padding: 10 }}>{dados.description}</td>
                  <td style={{ padding: 10 }}>{dados.price}</td>
                  <td style={{ padding: 10 }}>{dados.category.name}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Room;
