import Vue from "vue";
import App from "./App.vue";
import "./assets/css/tailwind.css";
import {
  router
} from "./router";
import VeeValidate from "vee-validate";
import store from './store';

Vue.config.productionTip = false;
Vue.use(VeeValidate);

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");