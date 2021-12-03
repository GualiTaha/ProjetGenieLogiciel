import React,{useState} from 'react';
import './Home.scss'

import { ThemeProvider as MuiThemeProvider } from '@material-ui/core/styles';
import { connect } from 'react-redux';
import test from '../assets/images/test.png';
class SupprimerTechnologieComponnent extends React.Component{
   

    
    constructor(props){
        super(props);

    }

    render(){
        return (
            <MuiThemeProvider>
         
      <div className="wrapper">


<header>
	<div class="overlay">
<h1>ESN LEADER</h1>
<h3>Comme son l'indique leader en services numériques</h3>
<p>Dans un monde qui change, les méthodes traditionnelles sont remises en question, bousculant des industries entières.</p>
	<br/>
  <img src={test} style={{width:'35%'}} />
  <br/>
	<button><a style={{fontSize:'30px'}} href="/Login">Connectez vous</a></button>
		</div>
</header>
  </div>
           </MuiThemeProvider>
        )
    }
}


   

SupprimerTechnologieComponnent.propTypes = {
  
   
}
const mapStateToProps = state => {
    return {
      
    }
};
export default connect(mapStateToProps, { })(SupprimerTechnologieComponnent)