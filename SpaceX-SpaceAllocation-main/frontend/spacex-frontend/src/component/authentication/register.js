import { React, useState} from "react";
import "./login.css";
function Register() {
  const [formData, setFormData] = useState({
    empId: "",
    empName: "",
    password : ""
  });
  const handleChange=(e)=>{
    
    setFormData({...formData, [e.target.name]: e.target.value})
  }
  const handleSubmit=(e)=>{
    e.preventDefault();
    console.log('handleSubmit', formData);
    
  }
  return (
    <div class="outerDiv">
      <div class="box">
        <h3 class="heading">REGISTER</h3>

        <form class="form-style" onSubmit={handleSubmit}>
          <div class="form-group">
            <label for="empId">Employee ID</label>
            <input type="string" class="form-control" id="empId" aria-describedby="empId" placeholder="Enter Employee ID" value={formData.empId} name="empId" onChange={handleChange} />
          </div>
          <div class="form-group">
            <label for="empName">Employee Name</label>
            <input type="string" class="form-control" id="empName" aria-describedby="empName" placeholder="Enter Employee Name" value={formData.empName} name="empName" onChange={handleChange}/>
          </div>
          <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" placeholder="Password" value={formData.password} name="password" onChange={handleChange}/>
          </div>
          <div class="btn-style">
          <button class="btn btn-dark" type="submit">Register</button>
          </div>
          <div class="container signin">
            <p>Already have an account? <a href="/">Sign In</a>.</p>
          </div>
        </form>
      </div>
    </div>
   
    
    
  );
}

export default Register;