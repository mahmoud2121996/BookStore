import React, { useState, useEffect } from 'react';
import BookService from '../services/BookService';
import { withRouter } from 'react-router-dom';

function Books(props) {
    const [bookList, setBookList] = useState([]);
    const [errorMessage, setErrorMessage] = useState(null);
    const getAllBooks = async () => {
        try {
            const response = await BookService.getAllBooks();
            setBookList(response.data);
            setErrorMessage(null);
        } catch (error) {
            setErrorMessage("error in getting books : " + error.message)
        }
    }


    const deleteBook = async (id) => {
        try {
            const response = await BookService.deleteBook(id);
            if (response.status === 204) {
                getAllBooks();
            }
        } catch (error) {
            setErrorMessage("error in deleting book : " + error.message);
        }
    }


    useEffect(() => {
        getAllBooks();
    }, []);


    return (
        <div className="container">

            <div className="row">

                {errorMessage === null ? bookList.map((book) => (

                    <div className="col-sm-4" key={book.id}>
                        <div className="card">
                            <div className="card-body">
                                <h5 className="card-title">Book Name : {book.bookName}</h5>
                                <h5 className="card-title">Book Author : {book.authorName}</h5>
                                <button className="btn btn-warning" onClick={() => { props.history.push(`/Books/update/${book.id}`) }} >Update</button>
                                <button className="btn btn-danger" onClick={() => deleteBook(book.id)} > Delete</button>
                            </div>
                        </div>
                    </div>

                )) : <h1>{errorMessage}</h1>}

            </div>
        </div>

    );
}

export default withRouter(Books);