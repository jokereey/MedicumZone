import './VaccinationSearcher.css';
import vac from './vac.jpg';
const VaccinationSearcher = () => {
    const handleClick = (e) =>{
        e.target.preventDefault();
    }
    return ( 
        <div className="search">
             <img className="image" src={vac} />
           <div className="data">
            <h2>Wybierz jedno spośród dostępnych miast:</h2>
            <form >
                <select  >
          <option className="option" value="Kraków" style={{color:'black'}}>Kraków</option>
          <option  className="option" value="Warszawa" style={{color:'black'}}>Warszawa</option>
          <option className="option"value="Sandomierz" style={{color:'black'}}>Sandomierz</option>
          <option className="option"value="Szczecin" style={{color:'black'}}>Szczecin</option>
          <option className="option"value="Katowice" style={{color:'black'}}>Katowice</option>
        </select>
        <button onClick ={(e) =>handleClick(e)}>Sprawdź dostępne terminy</button>
      </form>
      </div>
        </div>
     );
}
 
export default VaccinationSearcher;