//import logo from './logo.svg';
import { useEffect, useState, useRef } from 'react';
import './App.css';

function App() {
  const [kogus, setKogus] = useState(0); //HTMLs esinevad muutujad peavad olema useState sees
  const [stats, setstats] = useState([]); 
  const adRef = useRef();
  const hpRef = useRef();
  const armorRef = useRef();
  const mrRef = useRef();
  const [champions, setchampions] = useState([]);
  //CHAMPION ENTITY
  useEffect(() => {
    fetch("http://localhost:8080/api/stats", {"method": "GET"})
    .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
    .then((json) => {
      setKogus(json.length)
      setstats(json);
    }) //body
  }, []);

  function kustuta (primaarvoti){
    fetch("http://localhost:8080/api/stats/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
      .then((json) => {
        setKogus(json.length)
        setstats(json);
      })
  }
  function lisa (){
    if (adRef.current.value.trim() ===""){
      return;
    }
    const Stat = ({
      "baseAD": adRef.current.value,
      "baseHP": hpRef.current.value,
      "baseArmor": armorRef.current.value,
      "baseMagicResist": mrRef.current.value
  });
    fetch("http://localhost:8080/api/stats", {"method": "POST", 
    "body": JSON.stringify(Stat), 
    "headers": {"content-Type": "application/json"}})
      .then(response => response.json()) 
      .then((json) => {
        setKogus(json.length)
        setstats(json);
      })
  }
  //CHAMPION (muuda asju)
  useEffect(() => {
    fetch("http://localhost:8080/champions", {"method": "GET"})
    .then(response => response.json()) 
    .then((json) => {
      setchampions(json);
    })
  }, []);
  function kustutaCP (primaarvoti){
    fetch("http://localhost:8080/champions/" + primaarvoti, {"method": "DELETE"})
      .then(response => response.json()) //koos metadataga (headerid, staatuskood, OK)
      .then((json) => {
        setchampions(json);
      })
  }
  const championEntityRef = useRef();
  const championNameRef = useRef(); // inputi luger, mist loev HTMLst mida kirjutati
  const beCostRef = useRef();
  function lisaCP (){
    const lisatavCP = {
      "championEntity": {baseAD: championEntityRef.current.value},
      "name": championNameRef.current.value,
      "beCost": beCostRef.current.value
    }
    if (championNameRef.current.value.trim() ===""){
      return;
    }
    fetch("http://localhost:8080/champions", 
    {
      "method": "POST",
      "body": JSON.stringify(lisatavCP), 
      "headers": {"content-Type": "application/json"}
    })
    .then(response => response.json()) 
    .then((json) => {
      setchampions(json);
    })
  }
  return (
    <div className="App">
      Mul on {kogus} Statline'i
      <br/><br/> 
      <label>Stat AD</label> <br/> 
      <input ref={adRef} type = "text"/> <br/>
      <label>Stat HP</label> <br/> 
      <input ref={hpRef} type = "text"/> <br/>
      <label>Stat Armor</label> <br/> 
      <input ref={armorRef} type = "text"/> <br/>
      <label>Stat MagicResist</label> <br/> 
      <input ref={mrRef} type = "text"/> <br/>
      <button onClick={()=> lisa ()}>Insert</button> <br/>
      <br/>
      

      {stats.map(ce => <div>{ce.baseAD} <button onClick={()=> kustuta(ce.nimetus)}>X</button> </div> )}

      <hr />
      <label>Base AD</label> <br/> 
      <input ref={championEntityRef} type = "text"/> <br/>
      <label>Champion name</label> <br/> 
      <input ref={championNameRef} type = "text"/> <br/>
      <label>Blue Essence Cost</label> <br/> 
      <input ref={beCostRef} type = "text"/> <br/>
      <button onClick={()=> lisaCP ()}>Insert</button> <br/>

      {champions.map(CP => <div>{CP.id} | {CP.name} | {CP.beCost} | <button onClick={()=> kustutaCP(CP.id)}>X</button> </div> )}
    </div>
  );
}

export default App;
