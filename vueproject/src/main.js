// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'

var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:8081'
axios.defaults.withCredentials = false
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(ElementUI)

// router.beforeEach((to, from, next) => {
//  if (to.meta.requireAuth) {
//    console.log('跳到main.js这里了')
//    axios.get('/authentication').then(resp => {
//      console.log(resp.data)
//      if (resp.data) {
//        if (to.path.startsWith('/admin')) {
//          initAdminMenu(router, store)
//        }
//        next()
//      } else {
//        next({
//          path: 'login',
//          query: {redirect: to.fullPath}
//        })
//      }
//    })
//  } else {
//    next()
//  }
// }
// )

const formatRoutes = (routes) => {
  let fmtRoutes = []
  routes.forEach(route => {
    if (route.children) {
      route.children = formatRoutes(route.children)
    }

    let fmtRoute = {
      path: route.path,
      name: route.name,
      nameZh: route.nameZh,
      iconCls: route.iconCls,
      children: route.children
    }
    fmtRoutes.push(fmtRoute)
  })
  return fmtRoutes
}

// const initAdminMenu = (router, store) => {
//  if (store.state.adminMenus.length > 0) {
//    console.log('为空')
//    return
//  }
//  axios.get('/menu').then(resp => {
//    if (resp && resp.status === 200) {
//      resp.data.sort((a, b) => { return a.id - b.id })
//      const fmtRoutes = formatRoutes(resp.data)
//      store.commit('initAdminMenu', fmtRoutes)
//    }
//  })
// }

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
