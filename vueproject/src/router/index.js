import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Login from '@/components/Login'
import Register from '@/components/Register'
import Recommand from '@/components/Recommand'
import MovieSet from '@/components/MovieSet'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home,
      meta: {
        keepAlive: true
      }
    },
    {
      path: '/login',
      name: 'Login',
      component: Login,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: Register,
      meta: {
        keepAlive: false
      }
    },
    {
      path: '/recommand',
      name: 'Recommand',
      component: Recommand,
      meta: {
        requireAuth: true,
        keepAlive: true
      }
    },
    {
      path: '/movieset',
      name: 'MovieSet',
      component: MovieSet,
      meta: {
        keepAlive: true,
        requireAuth: true
      }
    }
  ]
})
