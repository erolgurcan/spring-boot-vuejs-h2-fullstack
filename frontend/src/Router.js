import { createRouter, createWebHistory } from "vue-router";
import LandingPage from "./components/LandingPage";

createRouter({
  history: createWebHistory(),
  routes: [{ path: "/", component: LandingPage }],
});
