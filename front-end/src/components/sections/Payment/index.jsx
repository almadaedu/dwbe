import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Payment = () => {
  const [moment, setMoment] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/payment", {
        moment,
      });

      if (response.status === 200 || 201) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          {moment},
        ]);
      } else {
        console.error("Erro ao enviar os dados");
      }
    } catch (error) {
      console.error("Erro:", error);
    }
  };

  useEffect(()=>{
    fetch("http://localhost:8080/payment")
    .then(res=>res.json())
    .then((result)=>{
      setDadosEnviados(result);
    }
  )
  },[])

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Pagamento</h1>
        <br />
        <Input
          type="text"
          placeholder="Momento"
          value={moment}
          onChange={(e) => setMoment(e.target.value)}
        />
        <Button type="submit">Enviar</Button>
      </form>

      {dadosEnviados.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>Momento</th>
                <th>Payment Status</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td style={{padding: 10}}>{dados.moment}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Payment;
