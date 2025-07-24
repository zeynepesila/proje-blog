import { createRouter, createWebHistory } from 'vue-router'
import Login from '../views/Login.vue'
import Signup from '../views/Signup.vue'
import Admin from '../views/Admin.vue'

const routes = [
  {
    path: '/',
    name: 'Login',
    component: Login
  },
  {
    path: '/signup',
    name: 'Signup',
    component: Signup
  },
  {
    path: '/admin',
    name: 'Admin',
    component: Admin,
    meta: { requiresAdmin: true }
  }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})


router.beforeEach((to, from, next) => {
  const role = localStorage.getItem('role');

  if (to.meta.requiresAdmin && role !== 'admin') {
    alert('Bu sayfaya erişim izniniz yok.');
    next('/');
  } else {
    next();
  }
});

export default router
