import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import Header from "./components/sections/Header";
import User from "./components/sections/User";
import Room from "./components/sections/Room";
import Category from "./components/sections/Category";
import Booking from "./components/sections/Booking";
import Page404 from "./components/sections/Page404";
import "./App.css";

const App = () => {
  return (
    <Router>
      <div className="container">
        <Header />
        <Routes>
          <Route path="/user" element={<User />} />
          <Route path="/category" element={<Category />} />
          <Route path="/room" element={<Room />} />
          <Route path="/booking" element={<Booking />} />
          <Route path="*" element={<Page404 />} />
        </Routes>
      </div>
    </Router>
  );
};

export default App;
