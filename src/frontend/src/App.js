
import {BrowserRouter as Router,Route, Switch} from 'react-router-dom';
import Header from "./Components/Header/Header";
import Home from './Components/Home/Home';
import VaccinationSearcher from './Components/VaccinationSearcher/VaccinationSearcher';

function App() {
  return (
   <Router>
     <div className="App">
       <Header/>
       <div className="content">
         <Switch>
           <Route exact path ="/">
            <Home/>
           </Route>
           <Route exact path ="/szczepienia">
            <VaccinationSearcher/>
           </Route>
         </Switch>
       </div>
     </div>
   </Router>
  );
}

export default App;
