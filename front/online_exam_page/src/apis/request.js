//axios基础封装
import axios from 'axios'

//使用axios下面的create([config])方法创建axios实例，其中config参数为axios最基本的配置信息。
const httpInstance = axios.create({
    baseURL:'http://39.101.78.10:8080/', //请求后端数据的基本地址，自定义
    headers: {
        "Content-Type": "application/json;charset=utf-8",
    },
    timeout: 5000                   //请求超时设置，单位ms
})
// 拦截器
// 请求拦截器
httpInstance.interceptors.request.use(config => {
    return config
}, e => Promise.reject(e))
// 响应拦截器
httpInstance.interceptors.response.use(res =>res.data, e => {
   return  Promise.reject(e)
})
//导出我们建立的axios实例模块，ES6 export用法
export default  httpInstance;