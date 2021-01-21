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

function App() {
  return (
    <div>
      <Router>
        <Header />
        <Switch>
          <Route exact path="/">
            <Home />
          </Route>
          <Route exact path="/books">
            <Books />
          </Route>
          <Route path="/books/add">
            <NewBookForm />
          </Route>
          <Route path="/books/update/:id">
            <UpdateBookForm />
          </Route>
        </Switch>
      </Router>
    </div>
  );
}

export default App;
