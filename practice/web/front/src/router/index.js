import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    { path: '/', component: () => import('../components/LoginRegPage') },
    { path: '/index', component: () => import ('../components/HomePage')},
]

const router = new VueRouter({
    mode: 'history',
    routes
})

export default router