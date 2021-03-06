import React,{useState} from 'react';
import './Entreprise.scss'

import { ThemeProvider as MuiThemeProvider } from '@material-ui/core/styles';
import TextField from '@material-ui/core/TextField';
import Button from '@mui/material/Button';
import {Select, MenuItem,FormControl,InputLabel ,makeStyles} from '@material-ui/core'
import PropTypes from 'prop-types';
import { connect } from 'react-redux';
import {UpdateProjet}  from "../actions/ProjetAction";
import {fetchProjet} from '../actions/ProjetAction';

class ModifierProjeComponent extends React.Component{
   
    componentDidMount(){
        const p = this.props;
        p.fetchProjet()
        
     }
    
    constructor(props){
        super(props);

        this.state={
            idProjet :"",
            client :"",
            client1:"",
            description : "" ,
            duree :"",
            nom_projet:"",
            type_projet:"",
            ProjetSelected:null,
        }    
        
    }
    handleNomChange =(event) =>{
      this.setState({
          nom_projet :event.target.value,
          ProjetSelected :event.target.value,
          idProjet:this.state.ProjetSelected.idProjet,
          client1:this.state.ProjetSelected.client
      })
     }
     handleClientChange =(event) =>{
      this.setState({
        client:this.state.client1
      })
     }
     handleDescriptionchange =(event) =>{
      this.setState({
        description :event.target.value
      })
     }
     handleDureechange =(event) =>{
      this.setState({
        duree :event.target.value
      })
     }

     handleNomProjetTelchange =(event) =>{
      this.setState({
        nom_projet :event.target.value
      })
     }
     handleTypeProjetchange =(event) =>{
        this.setState({
        type_projet :event.target.value
        })
       }

     handleSubmit = (e) =>{
        
        const projet ={
            idProjet:this.state.idProjet,
            client:this.state.client1,
            description:this.state.description,
            duree:this.state.duree,
            nom_projet:this.state.nom_projet,
            type_projet:this.state.type_projet,
        }
      
    
     this.props.UpdateProjet(projet);
  }
    render(){
        const{projets}=this.props;
        const projet ={
          idProjet:this.state.idProjet,
          client:this.state.client1,
          description:this.state.description,
          duree:this.state.duree,
          nom_projet:this.state.nom_projet,
          type_projet:this.state.type_projet,
      }
    console.log("test",projet)
        return (
            <MuiThemeProvider>
         <div className="wrapper">

        <div className="form-wrapper">
         <h1 className="titre">Modifier Votre Projet</h1>
          <br/>
          <br/>
          <form  onSubmit={this.handleSubmit} >
           
                
          <InputLabel style={{fontSize:'18px',marginBottom:'-40px'}}>Nom du projet a modifi??</InputLabel>
          <FormControl margin="normal">
          <Select
          
          className="a1a"
          value={this.state.nom_projet}
          onChange={this.handleNomChange}
        >
          
          {projets ? projets.map(
                        projet =>(
                            this.state.ProjetSelected=projet,
                            this.state.test=projet.nom_projet,
          <MenuItem key={projet.idProjet}id={projet.idProjet} value={projet.nom_projet} >{projet.nom_projet}</MenuItem>
                            
          )) :'' }
        </Select>
          
          </FormControl> 
          <br/>
          <br/>
          <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Nom du client</InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez le nom de votre client"
          value={this.state.client1}
          InputProps={{
            readOnly: true,
          }}
          onChange={this.handleClientChange}
        />       
        </FormControl>    
          <br/>
          <br/>
          <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Description du projet</InputLabel>
          <TextField
          className="a1a"
          multiline="true"
          placeholder="Saissez la description de votre projet"
          value ={this.state.description}
          onChange={this.handleDescriptionchange}
        />
          </FormControl> 
          <br/>
          <br/>
          <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Dur??e du projet</InputLabel>
          <TextField
          className="a1a"
          placeholder="Saissez le num??ro de votre filiale"
          value ={this.state.duree}
          onChange={this.handleDureechange}
        />
          </FormControl>
          <br/>    
            <br/>
          <FormControl margin="normal">
          <InputLabel style={{fontSize:'18px',marginTop:'-10px'}}>Type du projet</InputLabel>
          <TextField
            hintText="Site"
            placeholder="Saissez le type de votre projet"
            className="a2a"
            value ={this.state.type_projet}
            onChange={this.handleTypeProjetchange}
            />
              <br/>    
            <br/>
          </FormControl> 
             <div style={{alignItems: 'center',display: 'flex',justifyContent: 'center'}}>
          <FormControl margin="normal"> 
          <Button variant="contained" color="success" style={{width:'200px'}} type="submit">Valider</Button>
          </FormControl> 
          &nbsp;&nbsp;&nbsp;
          <FormControl margin="normal"> 
          <Button variant="contained" color="error" style={{width:'200px'}}>
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

   

ModifierProjeComponent.propTypes = {
  projets: PropTypes.array.isRequired,
  UpdateProjet : PropTypes.array.isRequired,
  fetchProjet : PropTypes.func.isRequired,
   
}
const mapStateToProps = state => {
    return {
        projets : state.projet.projets
    }
};
export default connect(mapStateToProps, { UpdateProjet,fetchProjet })(ModifierProjeComponent)



