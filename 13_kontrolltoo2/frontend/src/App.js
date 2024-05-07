
import { useEffect, useRef, useState } from 'react';
import './App.css';

function App() {
  const [pood, setPood] = useState([]);
  const nimiRef = useRef();
  const avamisAegRef = useRef();
  const sulgemisAegRef = useRef();
  const kulastunuteArvRef = useRef();


  useEffect(() => {
    fetch("http://localhost:8080/Pood")
      .then(response => response.json())
      .then(body => {
        setPood(body);
      })
  }, []);

  function kustuta(primaarivoti) {
     fetch("http://localhost:8080/Pood/" + primaarivoti, {"method": "DELETE"})
       .then(response => response.json()) 
       .then(json => {
         setPood(json);
       })
   }

   function lisa() {
     if (nimiRef.current.value.trim() === "") {
       return;
     }
     const pood = {
       "nimetus": nimiRef.current.value,
       "avamisAeg": avamisAegRef.current.value,
       "sulgemisAeg":sulgemisAegRef.current.value,
       "kulastunuteArv": kulastunuteArvRef.current.value,
     }
     fetch("http://localhost:8080/Pood", 
     {
       "method": "POST", 
       "body": JSON.stringify(pood), 
       "headers": {"Content-Type": "application/json"}
     })
       .then(response => response.json()) 
       .then(json => {
        setPood(json);
       })
   }


  return (
    <div className="App">
      <div>
        
        <label>Poe nimi</label> <br/>
        <input ref={nimiRef} type="text" /> <br />
        <label>Avamis aeg</label> <br/>
        <input ref={avamisAegRef} type="text" /> <br />
        <label>Sulgemis aeg</label> <br/>
        <input ref={sulgemisAegRef} type="text" /> <br />
        <label>Poe kulastunute arv</label> <br/>
        <input ref={kulastunuteArvRef} type="text" /> <br />
        <button onClick={() => lisa()}>Sisesta</button> <br />
        <br /> 

        {pood.map(p => 
          <div>{p.id} | {p.nimetus} | {p.avamisAeg} | {p.sulgemisAeg} | {p.kulastunuteArv}
            {<button onClick={() => kustuta(p.id)}>x</button>}
          </div> )}
      </div>
    </div>
  );
}

export default App;
