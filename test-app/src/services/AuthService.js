import axios from 'axios';
import { apiUrl } from '../constants';

class AuthService {

    doSignUp(userData) {
        return axios.post(`${apiUrl}/user/signup`, userData);
    }

    doLogin(userData) {
        return axios.post(`${apiUrl}/user/signin`, userData);
    }

    handleLoginData(data) {
        localStorage.setItem("jwtToken", data.jwtToken);
    }

    logout() {
        localStorage.removeItem('jwtToken');
    }

    isLoggedIn() {
        return localStorage.getItem("jwtToken") != null;
    }
}


export default new AuthService();