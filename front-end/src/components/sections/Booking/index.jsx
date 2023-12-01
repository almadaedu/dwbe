import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Booking = () => {
  const [moment, setMoment] = useState("");
  const [bookingStatus, setBookingStatus] = useState("");
  const [users, setUsers] = useState("");
  const [rooms, setRooms] = useState("");
  const [usersBooking, setUsersBooking] = useState([]);
  const [roomsBooking, setRoomsBooking] = useState([]);
  const [dadosEnviados, setDadosEnviados] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/booking", {
        moment,
        bookingStatus,
        userId: users,
        roomId: rooms,
      });

      if (response.status === 200 || response.status === 201) {
        console.log("Dados enviados com sucesso!");
        setDadosEnviados([
          ...dadosEnviados,
          { moment, bookingStatus, userId: users, roomId: rooms },
        ]);
      } else {
        console.error("Erro ao enviar os dados");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  const handleAssociateUser = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/booking/1/user/${users}`
      );

      if (response.status === 200) {
        alert("Usuário associado à reserva com sucesso!");
      } else {
        alert("Erro ao associar usuário à reserva");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  const handleAssociateRoom = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/booking/1/room/${rooms}`
      );

      if (response.status === 200) {
        alert("Quarto associado com sucesso");
      } else {
        alert("Erro ao associar quarto à reserva");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  useEffect(() => {
    fetch("http://localhost:8080/booking")
      .then((res) => res.json())
      .then((result) => {
        setDadosEnviados(result);
      });
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/users")
      .then((response) => setUsersBooking(response.data))
      .catch((error) => console.error("Erro ao carregar usuários", error));
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/room")
      .then((response) => setRoomsBooking(response.data))
      .catch((error) => console.error("Erro ao carregar quartos", error));
  }, []);



  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Reserva</h1>
        <br />
        <label>
          Data e horário da reserva:
          <Input
            type="datetime-local"
            placeholder="Momento"
            value={moment}
            onChange={(e) => setMoment(e.target.value)}
          />
        </label>
        <label>
          Status do pagamento:
          <Input
            type="integer"
            placeholder="Status do pagamento"
            value={bookingStatus}
            onChange={(e) => setBookingStatus(e.target.value)}
          />
        </label>
        <label>
          Selecionar Usuário:
          <br />
          <select
            name="users"
            value={users}
            onChange={(e) => setUsers(e.target.value)}
            required
          >
            <option>Selecione um usuário</option>
            {usersBooking.map((user) => (
              <option key={user.id} value={user.id}>
                {user.name}
              </option>
            ))}
          </select>
          <button type="button" onClick={handleAssociateUser}>
            Associar Usuário à Reserva
          </button>
        </label>
        <br />
        <br />
        <label>
          Selecionar Quarto:
          <br />
          <select
            name="rooms"
            value={rooms}
            onChange={(e) => setRooms(e.target.value)}
            required
          >
            <option>Selecione um quarto</option>
            {roomsBooking.map((rooms) => (
              <option key={rooms.id} value={rooms.id}>
                {rooms.name}
              </option>
            ))}
          </select>
          <button type="button" onClick={handleAssociateRoom}>
            Associar Quarto à Reserva
          </button>
        </label>
        <br />
        <br />

        <Button type="submit">Enviar</Button>
      </form>

      {dadosEnviados.length > 0 && (
        <div>
        <h2>Dados Enviados</h2>
        <table>
          <thead>
          <tr>
                <th>Momento do agendamento</th>
                <th>Status do agendamento</th>
              </tr>
          </thead>
          <tbody>
              {dadosEnviados.map((dados, index) => (
                <tr key={index}>
                  <td style={{ padding: 10 }}>{dados.moment}</td>
                  <td style={{ padding: 10 }}>{dados.bookingStatus}</td>
                  <td style={{ padding: 10 }}>
                    {dados.users &&
                      usersBooking.find((user) => user.id === dados.users)
                        ?.name}
                  </td>
                  <td style={{ padding: 10 }}>
                    {dados.rooms &&
                      roomsBooking.find((room) => room.id === dados.rooms)
                        ?.name}
                  </td>
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
