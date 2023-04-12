import { createRouter, createWebHistory } from 'vue-router'
import LandingPage from '../components/LandingPage.vue';
import Login from '../components/Login.vue';
import Register from '../components/Register.vue';
import MedicalUserDashboard from '../components/MedicalUserDashboard.vue';
import PatientUserDashboard from '../components/PatientUserDashboard.vue';
import TreatmentsManagement from '../components/TreatmentsManagement.vue';
import PatientsManagement from '../components/PatientsManagement.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: LandingPage
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    },
    {
      path: '/register',
      name: 'register',
      component: Register
    },
    {
      path: '/medicalUserDashboard',
      name: 'medical-user-dashboard',
      component: MedicalUserDashboard
    },
    {
      path: '/patientUserDashboard',
      name: 'patient-user-dashboard',
      component: PatientUserDashboard
    },
    {
      path: '/treatmentsManagement',
      name: 'treatmentsManagement',
      component: TreatmentsManagement,
      props: true
    },
    {
      path: '/patientsManagement',
      name: 'patientsManagement',
      component: PatientsManagement
    }
  ]
})

export default router;
