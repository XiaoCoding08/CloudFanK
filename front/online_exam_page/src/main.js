import { createApp } from 'vue'
import './style.css'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router/index'
import axios from './plugins/axiosInstance.js'

const app = createApp(App)
app.config.globalProperties.$axios = axios
app.use(router)
app.use(ElementPlus)
app.mount('#app')
