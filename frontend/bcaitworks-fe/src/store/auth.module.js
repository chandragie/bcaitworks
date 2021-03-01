import loginDS from "../services/LoginDataService";

const user = JSON.parse(localStorage.getItem('token'));
const initialState = user ? {
    status: {
        loggedIn: true
    },
    user
} : {
    status: {
        loggedIn: false
    },
    user: null
};

export const auth = {
    namespaced: true,
    state: initialState,
    actions: {
        login({
            commit
        }, user) {
            return loginDS.login(user).then(
                    user => {
                        commit('loginSuccess', user);
                        return Promise.resolve(user);
                    }
                )
                .catch(error => {
                    commit('loginFailure');
                    localStorage.removeItem('token');
                    localStorage.removeItem('username');
                    return Promise.reject(error);
                });
        },
        logout({
            commit
        }) {
            loginDS.logout().then((response) => {
                commit('logout');
                return Promise.resolve(response);
            }).catch(error => {
                return Promise.reject(error);
            });
        },
        register({
            commit
        }, user) {
            return loginDS.register(user).then(response => {
                commit('registerSuccess');
                return Promise.resolve(response.data);
            }, error => {
                commit('registerFailure');
                return Promise.reject(error);
            });
        }
    },
    mutations: {
        loginSuccess(state, user) {
            state.status.loggedIn = true;
            state.user = user;
        },
        loginFailure(state) {
            state.status.loggedIn = false;
            state.user = null;
        },
        logout(state) {
            state.status.loggedIn = false;
            state.user = null;
        },
        registerSuccess(state) {
            state.status.loggedIn = false;
        },
        registerFailure(state) {
            state.status.loggedIn = false;
        }
    }
};