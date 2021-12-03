import { Logout } from "@mui/icons-material";
import apiClient from "../utils/apiClient";
import {
    FETCH_LOGIN_SUCCESS, FETCH_LOGIN_BEGIN, FETCH_LOGIN_FAILURE,
    FETCH_SIGNIN_SUCCESS, FETCH_SIGNIN_BEGIN, FETCH_SIGNIN_FAILURE
} from './types';


export const Inscription = (user) => dispatch => {

    dispatch({ type: FETCH_LOGIN_BEGIN })
    console.log("action",user)
    return apiClient.post(`/Inscription`,user)
      .then(res =>
        dispatch({
          type: FETCH_LOGIN_SUCCESS,
          payload: res.data,
        }),
  
      ).catch(error => {
        dispatch({
          type: FETCH_LOGIN_FAILURE,
          payload: { error },
        })
      });
  };
  export const Connexion = (user) => dispatch => {
    console.log("action",user.username)
   
    dispatch({ type: FETCH_SIGNIN_BEGIN })
    return apiClient.post(`/Connexion`,user)
      .then(res =>
        dispatch({
          type: FETCH_SIGNIN_SUCCESS,
          payload: res.data,
        }),
        localStorage.setItem("user",user.username)    
      ).catch(error => {
        dispatch({
          type: FETCH_SIGNIN_FAILURE,
          payload: { error },
        })
      });
  };

  export const logout = () => {
    localStorage.removeItem("user");
  }
  export const getCurrentUser = () => {
   return localStorage.getItem('user');
  }


  