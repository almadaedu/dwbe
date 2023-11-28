import React, { useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Room = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [image, setImage] = useState("");
  const [category, setCategory] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/room", {
        name,
        description,
        price,
        image,
      });

      if (response.status === 200) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          { name, description, price, image, category },
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
        <h1>Cadastrar Quarto</h1>
        <br />
        <Input
          type="text"
          placeholder="Nome"
          value={name}
          onChange={(e) => setName(e.target.value)}
        />
        <Input
          type="text"
          placeholder="Descrição"
          value={description}
          onChange={(e) => setDescription(e.target.value)}
        />
        <Input
          type="number"
          placeholder="Valor"
          value={price}
          onChange={(e) => setPrice(e.target.value)}
        />
        <Input
          type="text"
          placeholder="Foto"
          value={image}
          onChange={(e) => setImage(e.target.value)}
        />
        <Input
          type="text"
          placeholder="Categoria"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
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
                <th>Descrição</th>
                <th>Price</th>
                <th>URL da imagem</th>
                <th>Categoria</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td>{dados.name}</td>
                  <td>{dados.description}</td>
                  <td>{dados.price}</td>
                  <td>{dados.image}</td>
                  <td>{dados.category}</td>
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
