import axios from 'axios';
import { apiUrl } from '../constants';

class BookService {
    constructor() {
        if (localStorage.getItem('jwtToken') === null) { this.token = '' }
        else {
            this.token = localStorage.getItem('jwtToken');
        }

    }

    getAllBooks() {
        return axios.get(`${apiUrl}/book`, { headers: { authorization: `Bearer ${this.token}` } });
    }

    createNewBook(newBook) {
        return axios.post(`${apiUrl}/book`, newBook, { headers: { authorization: `Bearer ${this.token}` } });
    }

    deleteBook(id) {
        return axios.delete(`${apiUrl}/book/${id}`, { headers: { authorization: `Bearer ${this.token}` } });
    }

    updateBook(id, updatedBook) {
        return axios.put(`${apiUrl}/book/${id}`, updatedBook, { headers: { authorization: `Bearer ${this.token}` } });
    }

    getBookById(id) {
        return axios.get(`${apiUrl}/book/${id}`, { headers: { authorization: `Bearer ${this.token}` } });
    }
}


export default new BookService();