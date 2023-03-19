import { createApp } from "vue";
import App from "./App.vue";

import { createRouter, createWebHistory , VueRouter} from "vue-router";


const Home = { template: "<div>Home</div>" };
const About = { template: "<div>About</div>" };

const routers = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", component: Home },
    { path: "/about", component: About },
  ],
});

const router = VueRouter.createRouter({
    // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
    history: VueRouter.createWebHashHistory(),
    routers, // short for `routes: routes`
  })

createApp(App).use(router).mount("#app");
