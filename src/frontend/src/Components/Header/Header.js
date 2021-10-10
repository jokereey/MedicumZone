import { Link } from "react-router-dom";
import './Header.css';
const Header = () => {
    return ( 
        <nav className="header">
            <h2 style={{textDecoration:"none"}}>MedicumZone</h2>
            <div className="links">
                <Link to ="/" style={{textDecoration:'none'}}><a>Home </a></Link>
                <a>login </a>
                <a>registration </a>
            </div>
        </nav>
     );
}
 
export default Header;