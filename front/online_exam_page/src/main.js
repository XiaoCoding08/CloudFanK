import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import App from './App.vue'
import router from './router'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import httpInstance from "@/utils/http.js";
// import {test} from '@/apis/testApi.js'
const app = createApp(App)

// //接口测试
// test().then((res) =>{
//     console.log(res)
// })

app.use(createPinia())
app.use(router)
app.use(ElementPlus)
app.config.globalProperties.$axios = httpInstance
app.mount('#app')
