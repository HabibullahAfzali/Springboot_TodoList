import { createRouter, createWebHistory } from "vue-router";
import SignUp from "../views/Register.vue";
const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "SignUp",
      component: SignUp,
    },
    {
      path: "/Welcome",
      name: "welcome",
      component: () => import("../views/Welcome.vue"),
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
