import React from "react";
import { Button } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";

const TrotinetRow = (props) => {
    const navigate = useNavigate();

    const deleteTrotinet= (trotinetId) => {
        CinemaAxios.delete('/trotineti/' + trotinetId)
            .then(res => {
                console.log(res);
                alert('Player was deleted successfully!');
                window.location.reload();
            })
            .catch(error => {
                console.log(error);
                alert('Error occurred. Please try again!');
            });
    }

    const iznajmljen = (iznjamljen) => {
        return iznajmljen ? "Da" : "Ne";
    }

   

    const isAdmin = localStorage.getItem('role') === 'ROLE_ADMIN'; // Provera da li je korisnik admin


    return (
        <tr>
            <td>{props.trotinet.sifra}</td>
            <td>{props.trotinet.maksimalnaBrzina}Km</td>
            <td>{props.trotinet.nivoBaterije}%</td>
            <td>{props.trotinet.adresaUlica}</td>

            <td>
                {props.trotinet.iznajmljen && <Button >Iznajmljen</Button>}
            </td>
            <td>
                {isAdmin && (
                   !props.trotinet.iznajmljen && <Button variant="danger" onClick={() => deleteTrotinet(props.trotinet.id)}>Obrisi</Button>
                )}
            </td>
            <td>
                {isAdmin && (
                   !props.trotinet.iznajmljen &&  <Button variant="warning" >Napuni trotinet</Button>
                )}
            </td>
        </tr>
    );
}

export default TrotinetRow;
