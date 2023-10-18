import React from "react";
import "./App.css";
import { Route, Routes } from "react-router-dom";
import Home from "./pages/Home/home";
import Create from "./pages/Post/Create";
import Update from "./pages/Post/Update";
import View from "./pages/Post/View";


function App() {
  return (
    <div className="container">
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/create" element={<Create/>} />
        <Route path="/edit/:id" element={<Update/>}/>
        <Route path="/view/:id" element={<View/>}/>
      </Routes>
    </div>
  );
}

export default App;
