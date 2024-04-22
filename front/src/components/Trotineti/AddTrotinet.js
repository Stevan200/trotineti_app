import React, { useState, useEffect, useCallback } from 'react';
import { Row, Col, Form, Button } from "react-bootstrap";
import { useNavigate } from 'react-router-dom';
import CinemaAxios from '../../apis/CinemaAxios';

const AddTrotinet = () => {

    var player = {
        adresaId: null,
        sifra: '',
        nivoBaterije: 0,
        maksimalnaBrzina: 0,
        iznajmljen: false,
    }

    const [newtroti, setNewTroti] = useState(player);
    const [adrese, setAdrese] = useState([])
    const navigate = useNavigate()

    useEffect(() => {
        getAdrese()
    }, [])

    const getAdrese = useCallback(() => {
        CinemaAxios.get("/adrese")
        .then(res => {
            console.log(res.data)
            setAdrese(res.data)
        })
        .catch(error => {
            console.log(error)
            alert('Error while fetching movies')
        })
    }, [])

    const create = () => {
        var params = {
            sifra: newtroti.sifra,
            nivoBaterije: newtroti.nivoBaterije,
            maksimalnaBrzina: newtroti.maksimalnaBrzina,
            iznajmljen: newtroti.iznajmljen,
            adresaId: newtroti.adresaId
        };
    
        CinemaAxios.post("/trotineti", params)
          .then((res) => {
            // handle success
            console.log(res);
            alert("Player was added successfully!");
            navigate("/trotineti");
          })
          .catch((error) => {
            // handle error
            console.log(error);
            alert("Error occured please try again!");
          });
      }

      const onSifraChange = (event) => {
        const value = event.target.value;
        setNewTroti({...newtroti, sifra: value});
    };

    const onNivoChange = (event) => {
        const value = event.target.value;
        setNewTroti({...newtroti, nivoBaterije: value});
    };

    const onMaksimalnaBrzinaChange = (event) => {
        const value = event.target.value;
        setNewTroti({...newtroti, maksimalnaBrzina: value});
    };

    const onadresaIdChange = (event) => {
        const value = event.target.value;
        setNewTroti({...newtroti, adresaId: value});
    };

    const onIznajmljenChange = (event) => {
        const checked = event.target.checked; 
        setNewTroti({...newtroti, iznajmljen: checked });
    };
    
   

    const renderAdrese = () => {
        return adrese.map((adresa)=><option key={adresa.id} value={adresa.id}>{adresa.ulica}</option>)
    }

    

    return (
        <>
            <Row>
                <Col></Col>
                <Col xs={12} sm={10} md={8}>
                    <h1>Add Player</h1>
                    <Form>
                        <Form.Group>
                            <Form.Label>Sifra </Form.Label>
                            <Form.Control id="pSifra" name="sifra" onChange={(e) => onSifraChange(e)} /> <br />
                        </Form.Group>
                        
                        <Form.Group>
                            <Form.Label>nivoBaterije </Form.Label>
                            <Form.Control type="number" step="1" min={0} max={100} id="pNivoBaterije" name="nivoBaterije" onChange={(e) => onNivoChange(e)} /> <br />
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>maksimalnaBrzina </Form.Label>
                            <Form.Control type="number" step="1" id="PMaksimalnaBrzina" name="maksimalnaBrzina" onChange={(e) => onMaksimalnaBrzinaChange(e)} /> <br />
                        </Form.Group>
                      
                        <Form.Group>
                            <Form.Label>Adresa</Form.Label>
                            <Form.Control id="pAdresaId" as="select" name="adresaId" onChange={(e) => onadresaIdChange(e)}>
                                <option>Izaberi Adresu</option>
                                {renderAdrese()}
                            </Form.Control><br />
                        </Form.Group>
                        <Button style={{ marginTop: "25px" }} onClick={create}>Add</Button>
                    </Form>
                </Col>
                <Col></Col>
            </Row>
        </>
    )

}

export default AddTrotinet
