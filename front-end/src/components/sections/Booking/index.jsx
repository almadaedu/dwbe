import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Booking = () => {
  const [moment, setMoment] = useState("");
  const [bookingStatus, setBookingStatus] = useState("");
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/booking", {
        moment,
        bookingStatus,
      });

      if (response.status === 200 || 201) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          {moment, bookingStatus},
        ]);
      } else {
        console.error("Erro ao enviar os dados");
      }
    } catch (error) {
      console.error("Erro:", error);
    }
  };

  useEffect(()=>{
    fetch("http://localhost:8080/booking")
    .then(res=>res.json())
    .then((result)=>{
      setDadosEnviados(result);
    }
  )
  },[])

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Reserva</h1>
        <br />
        <Input
          type="text"
          placeholder="Momento"
          value={moment}
          onChange={(e) => setMoment(e.target.value)}
        />
        <Input
          type="text"
          placeholder="Status do pagamento"
          value={bookingStatus}
          onChange={(e) => setBookingStatus(e.target.value)}
        />
        <Button />
      </form>


      {dadosEnviados.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>Momento</th>
                <th>Booking Status</th>
              </tr>
            </thead>
            <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td style={{padding: 10}}>{dados.moment}</td>
                  <td style={{padding: 10}}>{dados.bookingStatus}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      )}
    </div>
  );
};

export default Booking;
