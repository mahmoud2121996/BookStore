import './App.css';
import Header from './components/Header';
import {
  BrowserRouter as Router,
  Switch,
  Route,
} from "react-router-dom";


import Home from './components/Home';
import Books from './components/Books';
import NewBookForm from './components/NewBookForm';
import UpdateBookForm from './components/UpdateBookForm';
import SignUpForm from './components/SignUpForm';
import LoginForm from './components/LoginForm';
import Logout from './components/Logout';
import LoggedInRoute from './components/LoggedInRoute';

function App() {
  return (
    <div>
      <Router>
        <>
          <Header />
          <Switch>
            <Route exact path="/">
              <Home />
            </Route>
            <LoggedInRoute exact path="/books">
              <Books />
            </LoggedInRoute>
            <LoggedInRoute path="/books/add">
              <NewBookForm />
            </LoggedInRoute>
            <LoggedInRoute path="/books/update/:id">
              <UpdateBookForm />
            </LoggedInRoute>
            <Route exact path="/users/signUp">
              <SignUpForm />
            </Route>
            <Route path="/users/login">
              <LoginForm />
            </Route>

            <LoggedInRoute path="/users/logout">
              <Logout />
            </LoggedInRoute>

          </Switch>
        </>
      </Router>
    </div>
  );
}

export default App;
