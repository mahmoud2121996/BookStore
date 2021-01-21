import axios from 'axios';
import { apiUrl } from '../constants';

class BookService {

    getAllBooks() {
        return axios.get(`${apiUrl}/book`);
    }

    createNewBook(newBook) {
        return axios.post(`${apiUrl}/book`, newBook);
    }

    deleteBook(id) {
        return axios.delete(`${apiUrl}/book/${id}`);
    }
    
    updateBook(id, updatedBook) {
        return axios.put(`${apiUrl}/book/${id}`, updatedBook);
    }

    getBookById(id) {
        return axios.get(`${apiUrl}/book/${id}`);
    }
}


export default new BookService();