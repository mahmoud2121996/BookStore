import React, { useState } from 'react';
import AuthService from '../services/AuthService';
import { withRouter } from 'react-router-dom';
function Logout(props) {

    return (
        <div className="container">
            <div class="jumbotron jumbotron-fluid">
                <div class="container">
                    <h1 class="display-4">You are Logged Out</h1>
                </div>
            </div>
        </div>
    );
}

export default withRouter(Logout);
