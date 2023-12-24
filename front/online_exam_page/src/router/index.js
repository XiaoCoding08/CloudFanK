import { createRouter, createWebHistory } from 'vue-router'
import Access from '@/views/Access/index.vue'
import stuLogin from '@/views/Access/Components/StuLogin.vue'
import stuSignup from '@/views/Access/Components/StuSignUp.vue'
import tcLogin from '@/views/Access/Components/TcLogin.vue'
import tcSignup from '@/views/Access/Components/TcSignUp.vue'
import index from '@/views/Index/index.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
      {
          path: '/',
          name: 'Index',
          component: index,
      },
    {
      path: '/access',
      name: 'Access',
      component: Access,
      children:[
          {
            path:'/student/login',
            component: stuLogin
          },
          {
            path:'/student/signup',
            component: stuSignup
          },
          {
              path:'/teacher/login',
              component: tcLogin
          },
          {
              path:'/teacher/signup',
              component: tcSignup
          }
      ]
    },

  ]
})

export default router
