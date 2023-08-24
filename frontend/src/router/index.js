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
      path: "/register",
      name: "register",
      component: () => import("../views/Register.vue"),
    },
    {
      path: "/addtask",
      name: "addtask",
      component: () => import("../views/AddTask.vue"),
    },
    {
      path: "/tasklist",
      name: "tasks",
      component: () => import("../views/Tasks.vue"),
    },
    {
      path: "/update/:id",
      name: "update",
      component: () => import("../views/UpdateTask.vue"),
    },
  ],
});

export default router;
