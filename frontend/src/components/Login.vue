<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div>
    <p>Login Page</p>

    <li class="nav-item">
      <RouterLink class="nav-link active" aria-current="page" to="/medicalUserDashboard"
        >MedicalUserDashBoard</RouterLink
      >
    </li>
    <li class="nav-item">
      <RouterLink class="nav-link active" aria-current="page" to="/patientUserDashboard"
        >Patient User Dashboard</RouterLink
      >
    </li>
  </div>
</template>

<style scoped></style>
