import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Room = () => {
  const [name, setName] = useState("");
  const [description, setDescription] = useState("");
  const [price, setPrice] = useState("");
  const [image, setImage] = useState("");
  const [category, setCategory] = useState("");
  const [roomCategory, setRoomCategory] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/room", {
        name,
        description,
        price,
        image,
        category,
      });

      if (response.status === 200 || response.status === 201) {
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

  console.log(category);

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
        {/* <Input
          type="text"
          placeholder="Categoria"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
        /> */}
        <select
          name="selectedRoom"
          value={category}
          onChange={(e) => setCategory(e.target.value)}
          required
        >
          <option>Selecione um quarto</option>
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
                  <td style={{ padding: 10 }}>{dados.name}</td>
                  <td style={{ padding: 10 }}>{dados.description}</td>
                  <td style={{ padding: 10 }}>{dados.price}</td>
                  <td style={{ padding: 10 }}>{dados.image}</td>
                  <td style={{ padding: 10 }}>{dados.category}</td>
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
