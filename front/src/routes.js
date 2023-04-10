import RegisterForm from './vistas/RegisterForm.vue'
import HomePage from './vistas/HomePage.vue'
export default [
    {
        path: '/',
        component: HomePage
    },
    {
        path: '/register',
        component: RegisterForm
    }
]