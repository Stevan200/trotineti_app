import React, { useState } from 'react';
import { createRoot } from 'react-dom/client';
import { Route, Link, BrowserRouter as Router, Routes, Navigate } from 'react-router-dom';
import { Navbar, Nav, Button, Container} from 'react-bootstrap';
import Home from './components/Home';
import Login from './components/authorization/Login'
import NotFound from './components/NotFound';
import {logout} from './services/auth';
import Trotineti from './components/Trotineti/Trotinet';
import AddTrotinet from './components/Trotineti/AddTrotinet';


const App = () => {

    const [selectedTrotinet, setSelecetedTrotinet] = useState({})

    const jwt = window.localStorage['jwt'];

    if(jwt){
        return (
        <>
            <Router>
                <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand as={Link} to="/">
                        JWD
                    </Navbar.Brand>
                    <Nav>
                    <Nav.Link as={Link} to="/trotineti">
                        Trotineti
                    </Nav.Link>
                    <Button onClick={()=>logout()}>Logout</Button>:
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Navigate replace to='/'/>} />
                    <Route path="/trotineti" element={<Trotineti callback={(trotinet)=>setSelecetedTrotinet(trotinet)}/>} />
                    <Route path="/trotineti/add" element={<AddTrotinet/>} />
                    <Route path="*" element={<NotFound/>} />
                </Routes>
            </Container>
            </Router>
        </>
    );
    }else{
        return( 
        <>
            <Router>
            <Navbar expand bg="dark" variant="dark">
                    <Navbar.Brand as={Link} to="/">
                        JWD
                    </Navbar.Brand>
                    <Nav>
                    <Nav.Link as={Link} to="/trotineti">
                        Trotineti
                    </Nav.Link>
                    <Nav.Link as={Link} to="/login">
                        Login
                    </Nav.Link>
                    </Nav>
                </Navbar>
                <Container style={{paddingTop:"10px"}}>
                <Routes>
                    <Route path="/" element={<Home/>} />
                    <Route path="/login" element={<Login/>}/>
                    <Route path="/trotineti" element={<Trotineti/>} />
                    <Route path="*" element={<Navigate replace to = "/login"/>}/>
                </Routes>
                </Container>
            </Router>
        </>);
    }
}

const rootElement = document.getElementById('root');
const root = createRoot(rootElement);

root.render(
    <App/>,
)