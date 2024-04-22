import React, { useEffect, useState } from "react";
import {Button, Col, Form, Row, Table} from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import CinemaAxios from "../../apis/CinemaAxios";
import TrotinetRow from "./TrotinetRow";

const Trotineti = (props) => {

    const empty_search = {
        adresaId: "",
        baterijaOd: "",
        baterijaDo: ""

    }

    const [totalPages, setTotalPages] = useState(0)
    const [pageNo, setPageNo] = useState(0)
    const [search, setSearch] = useState(empty_search)
    const [showSearch, setShowSearch] = useState(false)
    const navigate = useNavigate()
    const [trotineti, setTrotineti] = useState([])
    const [adrese, setAdrese] = useState([])

    useEffect(()=>{
        getTrotineti(0)
        getAdrese()
      },[])

      const getTrotineti = (newPageNo) => {
        let config = {
            params: {
                pageNo: newPageNo,
                adresaId: search.adresaId,
                baterijaOd: search.baterijaOd,
                baterijaDo: search.baterijaDo

            }
        };
    
        CinemaAxios.get("/trotineti", config)
            .then((result) => {
                setPageNo(newPageNo);
                setTotalPages(result.headers["total-pages"]);
                setTrotineti(result.data);
            })
            .catch((error) => {
                console.log(error);
                alert("Error while fetching trotineti");
            });
    };
    

    const getAdrese = () => {
        CinemaAxios.get("/adrese")
        .then((resp) => {
            setAdrese(resp.data)
        })
        .catch((err=>{console.log(err)}))
    }

    const renderPlayers = () => {
        return trotineti.map((trotinet, index) => {
            return <TrotinetRow key={trotinet.id} trotinet={trotinet} editCallback={props.callback}></TrotinetRow>
         })
    }

    const onInputChange = (event) => {
      const name = event.target.name;
      const value = event.target.value;
  
      setSearch({
          ...search,
          [name]: value,
      });
  };

  const goToAdd = () => {
    navigate("/trotineti/add");
  }

  const isAdmin = localStorage.getItem('role') === 'ROLE_ADMIN'; // Provera da li je korisnik admin

  
  const renderSearchForm = () => {
    return (
        <>
        <Form style={{ width: "99%" }}>
    
    <Row>
        <Col>
            <Form.Group>
                <Form.Label>Adresa</Form.Label>
                <Form.Control
                    name="adresaId"
                    as="select"
                    onChange={(e) => onInputChange(e)}>
                    <option value="">Izaberite adresu</option>
                    {adrese.map((adresa) => (
                        <option key={adresa.id} value={adresa.id}>
                            {adresa.ulica}
                        </option>
                    ))}
                </Form.Control>
            </Form.Group>
        </Col>
    </Row>
    <Row><Col>
                <Form.Group>
                    <Form.Label>baterijaOd</Form.Label>
                    <Form.Control
                        name="baterijaOd"
                        as="input"
                        type="text"
                        onChange={(e) => onInputChange(e)}></Form.Control>
                </Form.Group>
            </Col></Row>
            <Row><Col>
                <Form.Group>
                    <Form.Label>baterijaOd </Form.Label>
                    <Form.Control
                        name="baterijaDo"
                        as="input"
                        type="text"
                        onChange={(e) => onInputChange(e)}></Form.Control>
                </Form.Group>
            </Col></Row>
</Form>

        <Row><Col>
            <Button className="mt-3" onClick={() => getTrotineti()}>Search</Button>
        </Col></Row>
        </>
    );
}

  return (
        <div>
          <h1>Trotineti</h1>
  
          <div>
            <div>
                <label>
                <input type="checkbox" onChange={()=>setShowSearch(!showSearch)}/>
                    Show Search
                </label>
            </div>
            <Row hidden={!showSearch} >
                {renderSearchForm()}
            </Row>
            <br/>
            <div >
                {isAdmin && (
                    <Button onClick={() => goToAdd()}> ADD</Button>
                )}
            <Button style={{ float: 'right' }} disabled={pageNo==totalPages-1} onClick={()=>getTrotineti(pageNo+1)}>Next</Button>
            <Button style={{ float: 'right' }} disabled={pageNo===0} 
                    onClick={()=>getTrotineti(pageNo-1)}
                    className="mr-3">Prev</Button>
            </div>
            <br/>
            <Table id="trotineti-table">
              <thead>
                <tr>
                  <th>Sifra</th>
                  <th>Maksimalna Brzina</th>
                  <th>Nivo baterije  </th>
                  <th>Adresa </th>
                </tr>
              </thead>
              <tbody>
                  {renderPlayers()}
              </tbody>
            </Table>
          </div>
        </div>
    );
}

export default Trotineti;
