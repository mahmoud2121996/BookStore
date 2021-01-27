import {
    Link
} from "react-router-dom";
import { withRouter } from "react-router";

import React from 'react';
import AuthService from "../services/AuthService";
function Header(props) {
    const isLoggedIn = AuthService.isLoggedIn();
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <div> <Link className="navbar-brand" to="/">Book Store </Link></div>
                <ul className="navbar-nav">
                    <li><Link className="nav-link" to="/">Home</Link></li>
                    {isLoggedIn && <li><Link className="nav-link" to="/books">Books</Link></li>}
                    {isLoggedIn && <li><Link className="nav-link" to="/books/add">New Book</Link></li>}
                </ul>
                <ul className="navbar-nav navbar-collapse justify-content-end">
                    {!isLoggedIn && <li><Link className="nav-link" to="/users/signUp">SignUp</Link></li>}
                    {!isLoggedIn && <li><Link className="nav-link" to="/users/login">Login</Link></li>}
                    {isLoggedIn && <li><Link className="nav-link" to="/users/logout" onClick={AuthService.logout}>Logout</Link></li>}
                </ul>
            </nav>
        </header>
    );
}

export default withRouter(Header);
