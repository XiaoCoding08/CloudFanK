const routes = [
    {
        path: '/home',
        name: 'home',
        title: '首页',
        component: () => import('../components/HomePage.vue'), //.vue不能省略
    }
]
export default routes
