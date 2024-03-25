import DropdownButton from 'react-bootstrap/DropdownButton';
import Dropdown from 'react-bootstrap/Dropdown'
import React, { useState } from "react";
import { useLocation } from "react-router-dom";
import { Form } from 'react-bootstrap';
import "./styles.css"
import Seats from '../seatBlocks/seats';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import axios from 'axios';
// import moment from 'moment';
const AVP = () => {
  const location = useLocation();
  const [floor, setFloor] = useState(1);
  const [show, setShow] = useState(false);
  let [num, setNum]= useState(0);
  let incNum =()=>{
      if(num<160)
      {
          setNum(Number(num)+1);
      }
  };
  let decNum = () => {
      if(num>0)
      {
          setNum(num - 1);
      }
  }
  let handleChange = (e)=>{
      setNum(e.target.value);
  }
  const handleClose = () => setShow(false);
  const handleSelect = (e) => {
    setFloor(e)
  }
  const handleClick=()=>{
    setShow(current => !current);
    
  }
  
  return (
    <div class="outer-div">
      <div class="upr-div row" >
        <div class="col-lg-8">
          <img style={{ height: "60px", marginLeft: "8px" }} src="http://www.fundraiso.ch/wp-content/uploads/2021/02/CS-Logo-1-scaled.jpg"></img>
        </div>
      </div>
      <div>
        <div class="row dropDownRow">
          <div className="col-lg-6">
            <div class="dropDownBtn" >
              <DropdownButton variant='info'
                title={floor == 0 ? '  Floor   ' : '  Floor ' + floor + ' '}
                onSelect={handleSelect}>
                <Dropdown.Item eventKey="1" >Floor 1</Dropdown.Item>
                <Dropdown.Item eventKey="2">Floor 2</Dropdown.Item>
                <Dropdown.Item eventKey="3">Floor 3</Dropdown.Item>
                <Dropdown.Item eventKey="4">Floor 4</Dropdown.Item>
              </DropdownButton>

            </div>
          </div>
          <div className='col-lg-6'>
            <div class="row box-style">
              <div class="col-lg-4" style={{ margin: '0 2px 2px',width:'30%' }}>
                <div className="row">
                  <div className="col-md-12" style={{ backgroundColor: 'navy', padding: '10px,5px', color: 'white', padding: '4px' }}>
                    <Form.Group controlId="startDate">
                      <Form.Label>Start Date</Form.Label>
                      <Form.Control type="date" name="startDate" placeholder="Start Date" />
                    </Form.Group>
                  </div>
                </div>
              </div>
              <div class="col-lg-4" style={{ margin: '0 2px',width:'30%' }}>
                <div className="row">
                  <div className="col-md-12" style={{ backgroundColor: 'navy', padding: '10px,5px', color: 'white', padding: '4px' }}>
                    <Form.Group controlId="endDate">
                      <Form.Label>End Date</Form.Label>
                      <Form.Control type="date" name="endDate" placeholder="End Date" />
                    </Form.Group>
                  </div>
                </div>
              </div>
            </div>


          </div>

        </div>

      </div>
      <div class="seatBox">
        <div class="row" style={{margin:0,padding:0,display:'flex',justifyContent:'space-between'}} >
          <div class="col=lg-6" style={{ width: "49%",boxShadow:'navy 1px 5px 8px 2px',borderRadius:'5px',margin:'2px' }}>
            <Seats wing="A" floor={floor}></Seats>
          </div>
          <div class="col=lg-6" style={{ width: "49%", float: "left" ,boxShadow:'navy 1px 5px 8px 2px',borderRadius:'5px',margin:'2px'}}>
            <Seats wing="B" floor={floor}></Seats>
          </div>

        </div>
        <br></br>
        <div class="row" style={{margin:0,padding:0,display:'flex',justifyContent:'space-between'}} >
          <div class="col=lg-6"style={{ width: "49%",boxShadow:'navy 1px 5px 8px 2px',borderRadius:'5px',margin:'2px' }}>
            <Seats wing="C" floor={floor}></Seats>
          </div>
          <div class="col=lg-6" style={{ width: "49%",boxShadow:'navy 1px 5px 8px 2px',borderRadius:'5px',margin:'2px' }}>
            <Seats wing="D" floor={floor}></Seats>
          </div>

        </div>

      </div>
      <div style={{ textAlign: 'center', padding: '15px 0' }}>
        <button class="btn bookBtn" style={{ backgroundColor: 'navy', color: 'white' }} onClick={handleClick}>Book Seat</button>
        {show && 
        <Modal show={show} onHide={handleClose}>
          <Modal.Header style={{textAlign:"center"}} closeButton>
            <Modal.Title>Number of seats to book</Modal.Title>
          </Modal.Header>
          <Modal.Body>
              <div >
                  <div class="input-group row">
                      <div class="input-group-prepend col " style={{display:'flex',justifyContent:'flex-end'}}> 
                      <button class="btn btn-outline-primary" type="button" style={{width:'40px'}} onClick={decNum}>-</button>
                      </div>
                      <input type="text" class="form-control col " style={{textAlign:'center',boxShadow:'#e0e8f6 1px 1px 12px 4px'}} value={num} onChange={handleChange}/>
                      <div class="input-group-prepend col " style={{display:'flex',justifyContent:'flex-start'}}>
                      <button class="btn btn-outline-primary" style={{width:'40px'}}  type="button" onClick={incNum}>+</button>
                      </div>
                  </div>
              </div>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={handleClose}>
              Close
            </Button>
            <Button variant="primary" onClick={handleClose}>
              Save Changes
            </Button>
          </Modal.Footer>
      </Modal>}
      </div>
    </div>

  );
}

export default AVP;
