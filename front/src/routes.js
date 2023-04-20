import RegisterForm from './vistas/RegisterForm.vue'
import HomePage from './vistas/HomePage.vue'
import LoginView from './vistas/LoginView.vue'
import DashBoard from './vistas/DashBoard.vue'
import EmergenciasView from './vistas/EmergenciasView.vue'
import PerfilView from './vistas/PerfilView.vue'

export default [
    {
        path: '/',
        component: HomePage
    },
    {
        path: '/register',
        component: RegisterForm
    },
    {
        path: '/login',
        component: LoginView
    },
    {
        path: '/dashboard',
        component: DashBoard
    },
    {
        path: '/emergencias',
        component: EmergenciasView
    },
    {
        path: '/perfil',
        component: PerfilView
    }
]