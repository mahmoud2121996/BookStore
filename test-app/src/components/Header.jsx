import {
    Link
} from "react-router-dom";
import { withRouter } from "react-router";

import React from 'react';
function Header(props) {
    return (
        <header>
            <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                <div> <Link className="navbar-brand" to="/">Book Store </Link></div>
                <ul className="navbar-nav">
                    <li><Link className="nav-link" to="/">Home</Link></li>
                    <li><Link className="nav-link" to="/Books">Books</Link></li>
                    <li><Link className="nav-link" to="/Books/add">New Book</Link></li>
                </ul>
                {/* <ul className="navbar-nav navbar-collapse justify-content-end">
                    <li><input type="text" className="form-control" placeholder="search" /></li>
                </ul> */}
            </nav>
        </header>
    );
}

export default withRouter(Header);
