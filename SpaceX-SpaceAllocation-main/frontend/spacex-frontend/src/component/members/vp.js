import React from "react";
import { useLocation } from "react-router-dom";
import "./styles.css"
const VP=()=> {
  const location = useLocation();
 console.log(location.state); 
  
  return (
    <div class="outer-div">
       <div class="upr-div">
        <img style={{height:"60px",marginLeft:"8px"}} src="http://www.fundraiso.ch/wp-content/uploads/2021/02/CS-Logo-1-scaled.jpg"></img>
       </div>
       <h1>I am VP</h1>
    </div>
    
  );
}

export default VP;