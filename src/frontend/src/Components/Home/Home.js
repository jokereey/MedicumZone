import vac from './vac.jpg';
import { useHistory } from "react-router";
import './Home.css';
const Home = () => {

    const history = useHistory();
    const handleClick = () => {
        history.push("/szczepienia");
    }
    return (
        <div className="home">
            <div className="imagespace">
                <img className="image" src={vac} />
                <div className="text">
                    <h1 className="title"> MedicumZone - Twoja przychodnia</h1>
                    <p>Nie pozwól Covidowi pokrzyżować twoich planów.</p>
                    <p>Zaszczep się już dziś.</p>
                    <p>Sprawdź dostępne punkty MedicumZone i umów się na szczepienie!</p>
                    <button onClick={handleClick}>Szczepię się</button>
                </div>
            </div>
            <p></p>
        </div>


    );
}

export default Home;