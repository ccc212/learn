import Vue from 'vue'
import VueRouter from 'vue-router';
import router from './router'
import App from './App.vue'
import axios from 'axios';
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css'

axios.defaults.baseURL = '/api';

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;
Vue.use(ElementUI);
Vue.use(VueRouter)

new Vue({
  render: h => h(App),
  router
}).$mount('#app')
