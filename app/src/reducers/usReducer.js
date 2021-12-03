import {
    FETCH_LOGIN_SUCCESS, FETCH_LOGIN_BEGIN, FETCH_LOGIN_FAILURE,
    FETCH_SIGNIN_SUCCESS, FETCH_SIGNIN_BEGIN, FETCH_SIGNIN_FAILURE
} from '../actions/types';

export const initialState = {
    users: [],
    fetchLoginLoading:false,
    fetchSignInLoading:false,
    fetchLoginError:false,
    fetchSigninError:false,
    LoginFetching:false,
    SingInFetching:false,
}
    const usReducer = (state = initialState, action) => {
        switch (action.type) {
            case FETCH_LOGIN_BEGIN:
                return {
                    ...state,
                    LoginFetching: true,
                }
            case FETCH_LOGIN_SUCCESS:
                return {
                    ...state,
                    fetchLoginLoading: false,
                    users :[
                        ...state.users,
                        action.payload
                    ]
    
                }
            case FETCH_LOGIN_FAILURE:
                return {
                    ...state,
                    LoginFetching: false,
                    fetchLoginError: action.payload.error,
                }

              case FETCH_SIGNIN_BEGIN:
                return {
                    ...state,
                    SingInFetching: true,
                }
            case FETCH_SIGNIN_SUCCESS:
                return {
                    ...state,
                    fetchSignInLoading: false,
                    users :[
                        ...state.users,
                        action.payload
                    ]
    
                }
            case FETCH_SIGNIN_FAILURE:
                return {
                    ...state,
                    fetchSignInLoading: false,
                    fetchSigninError: action.payload.error,
                }
                default:
                    return state;
            }        



            }
export default usReducer;
    