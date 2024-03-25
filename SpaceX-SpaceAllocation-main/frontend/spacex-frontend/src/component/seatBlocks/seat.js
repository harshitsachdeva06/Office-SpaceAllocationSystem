import React from "react";
import "./style.css";

const Seat=(props)=> {
  const {k}=props;
  const isBooked=[];
  // data.map((val,key)=>{
  //   console.log(val)

  // })
  // const classes = ["div1", ? "btn-green" : "btn-red"].join(" ");

    return (
      <div >
         <div className="div1" >
          <span class="tooltiptext">{k}</span>
         </div>
      </div>
      
    );
  }

  export default Seat;