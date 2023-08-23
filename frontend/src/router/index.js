import { createRouter, createWebHistory } from "vue-router";
import WelcomeView from "../views/Welcome.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "WelcomeView",
      component: WelcomeView,
    },
    {
      path: "/devlist",
      name: "DevList",
      component: () => import("../views/Task.vue"),
    },
    {
      path: "/register",
      name: "register",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/Register.vue"),
    },
  ],
});

export default router;
