import React from 'react'
import { Route, Redirect, withRouter } from 'react-router-dom'
import AuthService from '../services/AuthService';

function LoggedInRoute(props) {

    if (AuthService.isLoggedIn()) {
        return <Route {...props} />
    } else {
        return <Redirect to="/users/login" />
    }
}


export default withRouter(LoggedInRoute);