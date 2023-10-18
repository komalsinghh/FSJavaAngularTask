import React from "react";
import './style.css';
import { Link } from "react-router-dom";

function Navbar() {
  return (
    <header className="home-header">
      <div style={{float: 'right'}}>
      <Link to="/create" className="btn btn-success my-3">Create Post</Link>
      </div>
      <h1>
        <span>"</span>Blog<span>"</span>
      </h1>
      <p>awesome place to make oneself<br/>
      productive and entertained through daily updates.
      </p>
    </header>
  );
}

export default Navbar;
