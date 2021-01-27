import React, { useState } from 'react';
import AuthService from '../services/AuthService';
import { withRouter } from 'react-router-dom';
function SignUpForm(props) {

    const [username, setUsername] = useState('');
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [confirmPassword, setConfirmPassword] = useState('');
    const [errorMessageObj, setErrorMessageObj] = useState(null);

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
    }


    const handleEmailChange = (event) => {
        setEmail(event.target.value);
    }

    const handlePasswordChange = (event) => {
        setPassword(event.target.value);
    }

    const handleConfirmPasswordChange = (event) => {
        setConfirmPassword(event.target.value);
    }

    const handleSubmit = async (event) => {
        event.preventDefault();
        try {
            if (password === confirmPassword) {
                const response = await AuthService.doSignUp({
                    "userName": username,
                    email,
                    password
                });

                if (response.status === 200) {
                    props.history.push('/users/login');
                }
            }
            else {
                setErrorMessageObj(["the passwords you entered must match"]);
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
                    <label >Username</label>
                    <input type="text" className="form-control" aria-describedby="emailHelp" placeholder="Enter Username" value={username} onChange={handleUsernameChange} />
                </div>

                <div className="form-group">
                    <label >Email</label>
                    <input type="email" className="form-control" aria-describedby="emailHelp" placeholder="Enter Email" value={email} onChange={handleEmailChange} />
                </div>

                <div className="form-group">
                    <label >Password</label>
                    <input type="password" className="form-control" aria-describedby="emailHelp" placeholder="Enter Password" value={password} onChange={handlePasswordChange} />
                </div>

                <div className="form-group">
                    <label >Confirm Password</label>
                    <input type="password" className="form-control" aria-describedby="emailHelp" placeholder="Confirm Password" value={confirmPassword} onChange={handleConfirmPasswordChange} />
                </div>

                <button className="btn btn-success" onClick={handleSubmit}>Sign Up</button>
            </form>
        </div>
    );
}

export default withRouter(SignUpForm);
