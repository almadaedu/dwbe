import React, { useEffect, useState } from "react";
import Input from "../../micros/input";
import Button from "../../micros/button";
import axios from "axios";

const Booking = () => {
  const [moment, setMoment] = useState("");
  const [bookingStatus, setBookingStatus] = useState("");
  const [selectedUser, setSelectedUser] = useState("");
  const [booking, setBooking] = useState([]);
  const [users, setUsers] = useState([]);
  const [room, setRoom] = useState([]);

  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      const response = await axios.post("http://localhost:8080/booking", {
        moment,
        bookingStatus,
        clientId: selectedUser,
      });

      if (response.status === 200 || response.status === 201) {
        console.log("Dados enviados com sucesso!");
        setBooking([
          ...booking,
          { moment, bookingStatus, userId: selectedUser },
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
        `http://localhost:8080/booking/1/user/${selectedUser}`
      );

      if (response.status === 200) {
        console.log("Usuário associado à reserva com sucesso!");
      } else {
        console.error("Erro ao associar usuário à reserva");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  const handleAssociateRoom = async () => {
    try {
      const response = await axios.put(
        `http://localhost:8080/booking/1/room/${selectedUser}`
      );

      if (response.status === 200) {
        console.log("Usuário associado à reserva com sucesso!");
      } else {
        console.error("Erro ao associar usuário à reserva");
      }
    } catch (error) {
      console.error("Erro:", error.message);
    }
  };

  useEffect(() => {
    axios
      .get("http://localhost:8080/booking")
      .then((response) => setBooking(response.data))
      .catch((error) => console.error("Erro ao carregar reservas", error));
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/users")
      .then((response) => setUsers(response.data))
      .catch((error) => console.error("Erro ao carregar usuários", error));
  }, []);

  useEffect(() => {
    axios
      .get("http://localhost:8080/room")
      .then((response) => setRoom(response.data))
      .catch((error) => console.error("Erro ao carregar usuários", error));
  }, []);

  return (
    <div>
      <form onSubmit={handleSubmit}>
        <h1>Cadastrar Reserva</h1>
        <br />
        <Input
          type="datetime-local"
          placeholder="Momento"
          value={moment}
          onChange={(e) => setMoment(e.target.value)}
        />
        <Input
          type="integer"
          placeholder="Status do pagamento"
          value={bookingStatus}
          onChange={(e) => setBookingStatus(e.target.value)}
        />
        <label>
          Selecionar Usuário:
          <br />
          <select
            name="selectedUser"
            value={selectedUser}
            onChange={(e) => setSelectedUser(e.target.value)}
            required
          >
            <option>Selecione um usuário</option>
            {users.map((user) => (
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
            name="selectedUser"
            value={selectedUser}
            onChange={(e) => setSelectedUser(e.target.value)}
            required
          >
            <option>Selecione um quarto</option>
            {room.map((user) => (
              <option key={user.id} value={user.id}>
                {user.name}
              </option>
            ))}
          </select>
          <button type="button" onClick={handleAssociateRoom}>
            Associar Quarto à Reserva
          </button>
        </label>

        <Button type="submit">Enviar</Button>
      </form>

      {booking.length > 0 && (
        <div>
          <h2>Dados Enviados</h2>
          <table>
            <thead>
              <tr>
                <th>Momento</th>
                <th>Booking Status</th>
                <th>ID do Usuário</th>
              </tr>
            </thead>
            <tbody>
              {booking.map((bookingItem, index) => (
                <tr key={index}>
                  <td style={{ padding: 10 }}>{bookingItem.moment}</td>
                  <td style={{ padding: 10 }}>{bookingItem.bookingStatus}</td>
                  <td style={{ padding: 10 }}>{bookingItem.userId}</td>
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
