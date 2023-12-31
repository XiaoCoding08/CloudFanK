import { createRouter, createWebHistory } from 'vue-router'
import Access from '@/views/Access/index.vue'
import stuLogin from '@/views/Access/Components/StuLogin.vue'
import stuSignup from '@/views/Access/Components/StuSignUp.vue'
import tcLogin from '@/views/Access/Components/TcLogin.vue'
import tcSignup from '@/views/Access/Components/TcSignUp.vue'
import index from '@/views/Index/index.vue'


const router = createRouter({
  history: createWebHistory(),
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

{
      path: '/student',
      name:'/student',
      component: () => import('../views/StudentPage/Studentlayout/index.vue'),
     
      children: [
        { name: 'class', path: '/student/class', component: () => import('../views/StudentPage/classpage.vue') },
        { name: 'test', path: '/student/exam', component: () => import('../views/StudentPage/examination.vue') },
        { name: 'exampage', path: '/student/exampage', component: () => import('../views/StudentPage/exampage.vue') }
      ]
    },
{
      path: '/teacher',
      name:'/teacher',
      component: () => import('../views/TeacherPage/Teacherlayout/index.vue'),
     
      children: [
        { name: 'home', path: '/teacher/classinformation', component: () => import('../views/TeacherPage/class.vue') },
        { name: 'exam', path: '/teacher/exam', component: () => import('../views/TeacherPage/examination.vue') },
        { name: 'question', path: '/teacher/question', component: () => import('../views/TeacherPage/question.vue') },
        { name: 'course', path: '/teacher/course', component: () => import('../views/TeacherPage/course.vue') },
        { name: 'expage', path: '/teacher/expage', component: () => import('../views/TeacherPage/exampape.vue') }
        
      ]
    }
  ]
})
export default router