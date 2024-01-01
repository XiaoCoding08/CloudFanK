import { createRouter, createWebHistory ,createWebHashHistory} from 'vue-router'
import Access from '@/views/Access/index.vue'
import stuLogin from '@/views/Access/Components/StuLogin.vue'
import stuSignup from '@/views/Access/Components/StuSignUp.vue'
import tcLogin from '@/views/Access/Components/TcLogin.vue'
import tcSignup from '@/views/Access/Components/TcSignUp.vue'
import index from '@/views/Index/index.vue'
import studentindex from '../views/StudentPage/Studentlayout/index.vue'
import studentclass from '../views/StudentPage/classpage.vue'
import studentexamination from '../views/StudentPage/examination.vue'
import studentexampage from '../views/StudentPage/exampage.vue'
import teacherindex from '../views/TeacherPage/Teacherlayout/index.vue'
import teacherclass from '../views/TeacherPage/class.vue'
import teacherexamination from '../views/TeacherPage/examination.vue'
import teacherquestion from '../views/TeacherPage/question.vue'
import teachercourse from '../views/TeacherPage/course.vue'
import teacherexampape from '../views/TeacherPage/exampape.vue'
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
      component:studentindex,
     
      children: [
        { name: 'class', path: '/student/class', component: studentclass },
        { name: 'test', path: '/student/exam', component: studentexamination },
        { name: 'exampage', path: '/student/exampage', component: studentexampage }
      ]
    },
{
      path: '/teacher',
      name:'/teacher',
      component: teacherindex,
     
      children: [
        { name: 'home', path: '/teacher/classinformation', component: teacherclass },
        { name: 'exam', path: '/teacher/exam', component: teacherexamination},
        { name: 'question', path: '/teacher/question', component: teacherquestion},
        { name: 'course', path: '/teacher/course', component: teachercourse },
        { name: 'expage', path: '/teacher/expage', component: teacherexampape }
        
      ]
    }
  ]
})
export default router