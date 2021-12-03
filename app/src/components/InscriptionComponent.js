import React,{useState} from 'react';
import './Entreprise.scss'

import { ThemeProvider as MuiThemeProvider } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@mui/material/Button';
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import {FormControl,InputLabel ,makeStyles} from '@material-ui/core';
import {Inscription} from "../actions/usAction";


class InscriptionComponent extends React.Component{
   
 
    
    constructor(props){
        super(props);

        this.state={
          username :"",
          password :"",
          email :"",
          codepostale:"",
  
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
     handleEmailChange =(event) =>{
      this.setState({
        email :event.target.value,
      })
     }
     handlePostaleChange =(event) =>{
      this.setState({
        codepostale :event.target.value,
      })
     }
     handleAnnuler =(event) =>{
      this.setState({
        username :"",
        password :"",
        email :"",
        codepostale:"",
      })
     }

     handleSubmit = (e) =>{
        
      const users ={
        username :this.state.username,
        password :this.state.password,
        email :this.state.email,
        codepostale:this.state.codepostale,
       
      }
    
     this.props.Inscription(users);
  }
    render(){
      const users ={
        username :this.state.username,
        password :this.state.password,
        email :this.state.email,
        codepostale:this.state.codepostale,
       
      }
    
        return (
            <MuiThemeProvider>
         <div className="wrapper">

        <div className="form-wrapper">
         <h1 className="titre">Créer un compte</h1>
          <br/>
          <br/>
          <form  onSubmit={this.handleSubmit} >
          <FormControl margin="normal" style={{textAlign:'center'}}>
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Nom d'utilisateur </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre login d'inscription"
          value ={this.state.username}
          onChange={this.handleUsernameChange}
        />
          </FormControl>
         <br/><br/>
         <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Mot de passe </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre mot de passe d'inscription"
          type="password"
          value ={this.state.password}
          onChange={this.handlePasswordChange}
        />
         </FormControl>
         <br/><br/>
        
          
          <FormControl margin="normal" style={{textAlign:'center'}}>
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Email </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre email "
          value ={this.state.email}
          onChange={this.handleEmailChange}
        />
          </FormControl>
            <br/><br/>
        

        <FormControl margin="normal" style={{textAlign:'center'}}>
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Code Postale </InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez votre Code Postal "
          value ={this.state.codepostale}
          onChange={this.handlePostaleChange}
        />
          </FormControl>

          <br/><br/>
          <div style={{alignItems: 'center',display: 'flex',justifyContent: 'center'}}>
          <FormControl margin="normal"> 
          <Button variant="contained" color="success" style={{width:'200px'}} type="submit">Créer mon compte</Button>
          </FormControl> 
          &nbsp;&nbsp;&nbsp;
          <FormControl margin="normal"> 
          <Button  variant="contained" color="error" style={{width:'200px'}} onClick={this.handleAnnuler}>
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

   

InscriptionComponent.propTypes = {
  
  users : PropTypes.array.isRequired,
  Inscription :PropTypes.array.isRequired,
}
const mapStateToProps = state => {
    return {
      users : state.entreprise.users
    }
};
export default connect(mapStateToProps, { Inscription })(InscriptionComponent)