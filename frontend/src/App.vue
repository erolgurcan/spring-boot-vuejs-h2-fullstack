<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <div class = "col-lg-10 m-auto text-center"  >
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container-fluid">
        <RouterLink class="navbar-brand" aria-current="page" to="/">Home</RouterLink>
        <button
          class="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse col-lg-10" id="navbarSupportedContent">
          <ul class="navbar-nav ms-auto mb-2 mb-lg-0 justify-content-end">
            <li class="nav-item">
              <RouterLink class="nav-link active" aria-current="page" to="/Login">Login</RouterLink>
            </li>
            <li class="nav-item">
              <RouterLink class="nav-link active" aria-current="page" to="/Register"
                >Register</RouterLink
              >
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <RouterView />
  </div>
</template>

<style scoped></style>
