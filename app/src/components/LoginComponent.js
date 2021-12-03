import React,{useState} from 'react';
import './Entreprise.scss'

import { ThemeProvider as MuiThemeProvider } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@mui/material/Button';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import {FormControl,InputLabel ,makeStyles} from '@material-ui/core'
import {Connexion} from "../actions/usAction";

import {logout} from "../actions/usAction";
import {getCurrentUser} from "../actions/usAction";
import Container from '@mui/material/Container';

class LoginComponent extends React.Component{
   
 
    
    constructor(props){
        super(props);

       
        this.state={
          username :"",
          password :"",
        }
      
        
    }
    
  
    handleUsernameChange =(event) =>{
      this.setState({
        username :event.target.value,
      })
     }
     handlePasswordChange =(event) =>{
      this.setState({
        password :event.target.value,
      })
     }
     handleAnnuler =(event) =>{
      this.setState({
        username :"",
        password :"",
      })
     }
     handleSubmit = (e) =>{
        
      const users ={
        username :this.state.username,
        password :this.state.password,   
      }
    
     this.props.Connexion(users);
     this.props.history.push("AjouterEntreprise");
     window.location.reload();
  }
     
    render(){
      const users ={
        username :this.state.username,
        password :this.state.password,   
      }
    
        return (
            <MuiThemeProvider>
         <div className="wrapper">

        <div className="form-wrapper">
         <h1 className="titre">Connectez vous</h1>
          <br/>
          <br/>
          <form  onSubmit={this.handleSubmit} >
          <FormControl margin="normal" style={{textAlign:'center'}}>
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Nom d'utilisateur </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre login"
          value ={this.state.username}
          onChange={this.handleUsernameChange}
        />
          </FormControl>
            <br/><br/>
          <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Mot de passe </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre mot de passe"
          type="password"
          value ={this.state.password}
          onChange={this.handlePasswordChange}
        />
          </FormControl>
          <br/><br/>
          <div style={{alignItems: 'center',display: 'flex',justifyContent: 'center'}}>
          <FormControl margin="normal"> 
          <Button variant="contained" color="success" style={{width:'200px'}} type="submit" >Se connecter</Button>
          </FormControl> 
          &nbsp;&nbsp;&nbsp;
          <FormControl margin="normal"> 
          <Button variant="contained" color="error" style={{width:'200px'}} onClick={this.handleAnnuler}>
           Annuler
         </Button>
            </FormControl>
            </div>
          </form>
          </div>
          </div>
           </MuiThemeProvider>
        )
    }
}

const styles={
    button:{
        margin : 15
    }
}

   

LoginComponent.propTypes = {
  
  users : PropTypes.array.isRequired,
  Connexion :PropTypes.array.isRequired,
}
const mapStateToProps = state => {
    return {
      users : state.entreprise.users
    }
};
export default connect(mapStateToProps, {Connexion })(LoginComponent)