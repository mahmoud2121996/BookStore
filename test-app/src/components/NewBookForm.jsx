import React, { useState } from 'react';
import BookService from '../services/BookService';
import { withRouter } from 'react-router-dom';
function NewBookForm(props) {

    const [bookName, setBookName] = useState('');
    const [authorName, setAuthorName] = useState('');
    const [bookPages, setBookPages] = useState(0);
    const [errorMessageObj, setErrorMessageObj] = useState(null);

    const handleBookNameChange = (event) => {
        setBookName(event.target.value);
    }

    const handleAuthorNameChange = (event) => {
        setAuthorName(event.target.value);
    }

    const handleBookPagesChange = (event) => {
        setBookPages(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await BookService.createNewBook(
                {
                    "bookName": bookName,
                    "authorName": authorName,
                    "pages": bookPages
                }
            );
            if (response.status === 201) {
                props.history.push('/books');
            }
        } catch (error) {
            if (error.response.status === 400) {
                setErrorMessageObj(error.response.data.errorList);
            }
        }
    }

    return (
        <div className="container">

            {errorMessageObj && <div className="alert alert-danger" role="alert">
                <ul>
                    {errorMessageObj.map((error, index) => <li key={index}>{error}</li>)}
                </ul>
            </div>
            }
            <form>
                <div className="form-group">
                    <label >Book Name</label>
                    <input type="text" className="form-control" aria-describedby="emailHelp" placeholder="Enter Book Name" value={bookName} onChange={handleBookNameChange} />
                </div>

                <div className="form-group">
                    <label >Author Name</label>
                    <input type="text" className="form-control" aria-describedby="emailHelp" placeholder="Enter Author Name" value={authorName} onChange={handleAuthorNameChange} />
                </div>

                <div className="form-group">
                    <label >Book Pages</label>
                    <input type="number" className="form-control" placeholder="Book Pages" value={bookPages} onChange={handleBookPagesChange} />
                    <small id="emailHelp" className="form-text text-muted">Must Be 200 pages Or More...</small>
                </div>
                <button className="btn btn-success" onClick={handleSubmit}>Create New Book</button>
            </form>
        </div>
    );
}

export default withRouter(NewBookForm);
