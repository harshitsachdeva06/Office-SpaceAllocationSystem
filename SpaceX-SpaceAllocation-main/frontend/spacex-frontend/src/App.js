import Register from "./component/authentication/register";
import Login from "./component/authentication/login";
import { BrowserRouter, Routes, Route  } from "react-router-dom";
import VP from "./component/members/vp";
import AVP from "./component/members/avp";
import Employee from "./component/members/emp.js";
import Seats from "./component/seatBlocks/seats";

function App() {
return (
  <div className="App">
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/members/vp" element={<VP />} />
        <Route path="/members/avp" element={<AVP />} />
        <Route path="/members/emp" element={<Employee />} />
        <Route path="/members/emp" element={<Employee />} />
        <Route path="/seats" element={<Seats />} />
      </Routes>
    </BrowserRouter>
  </div>
);
}

export default App;
