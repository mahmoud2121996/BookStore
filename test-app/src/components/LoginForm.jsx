import React, { useState } from 'react';
import AuthService from '../services/AuthService';
import { withRouter } from 'react-router-dom';
function LoginForm(props) {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessageObj, setErrorMessageObj] = useState(null);

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            const response = await AuthService.doLogin({
                "userName": username,
                password
            });

            if (response.status === 200) {
                AuthService.handleLoginData(response.data);
                props.history.push('/books');
            }

        } catch (error) {
            if (error.response.status === 400) {
                setErrorMessageObj(error.response.data.errorList);
            }
            else if (error.response.status === 401) {
                setErrorMessageObj([error.response.data.message]);
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
                    <label >Username</label>
                    <input type="text" className="form-control" aria-describedby="emailHelp" placeholder="Enter Username" value={username} onChange={handleUsernameChange} />
                </div>

                <div className="form-group">
                    <label >Password</label>
                    <input type="password" className="form-control" aria-describedby="emailHelp" placeholder="Enter Password" value={password} onChange={handlePasswordChange} />
                </div>

                <button className="btn btn-success" onClick={handleSubmit}>Login</button>
            </form>
        </div>
    );
}

export default withRouter(LoginForm);
