<script setup>
import { ref, onMounted, computed } from 'vue';
import { useRouter } from 'vue-router';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';

const task = ref({
    title: '',
    description: '',
    dueDate: '',
    isCompleted: ''
});

const users = ref([]);
const selectedUser = ref("Select_from_list");
const router = useRouter();
const addtask = () => {
    const formattedDueDate = new Date(task.value.dueDate).toISOString();
    const newtask = {
        ...task.value,
        dueDate: formattedDueDate,
        user: {
            id: selectedUser.value
        }
    }
    axios.post('http://localhost:8080/tasks', newtask)
        .then(() => {
            alert("task Sucessfully added!")
            router.push('/tasklist');
        })
        .catch(error => {
            console.error("Not able to add task:", error);
            console.log(Response.error.data);
        });
};
const fetchUsers = () => {
    axios.get('http://localhost:8080/users')
        .then(res => {
            users.value = res.data;
        }).catch(error => {
            console.error('Role Not found!', error);
        });
};
const isCompleted = computed(() => {
    return (
        task.value.description.trim() !== '' &&
        task.value.title.trim() !== '' &&
        task.value.dueDate.trim() !== '' &&
        selectedUser.value !== 'Select_from_list'   
    );
})
onMounted(() => {
    fetchUsers();
});
</script>
<template>
    <main>
        <Navbar/>
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)"> Keep in mind that you'r going to
                      <br />
                        <span style="color: hsl(218, 81%, 75%)">Make your future</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Good Luck!
                    </p>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                    <h2 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">{{ $t("taskPageTitle") }}</h2>
                    <div class="card-body px-4 py-5 px-md-5">
                        <form @submit.prevent="addtask">
                            <div class="form-outline mb-4">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="title" class="form-label">{{ $t("Title") }}</label>
                                    <input id="title" type="text" name="name" class="form-control" placeholder="title"
                                        required v-model="task.title">
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="description" class="form-label">{{ $t("description") }}</label>
                                    <textarea id="description" type="text" name="description" class="form-control"
                                        placeholder="description" required v-model="task.description"></textarea>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <label for="dueDate" class="form-label">{{$t("duedate")}}</label>
                                <input id="dueDate" type="date" name="dueDate" class="form-control" required
                                    v-model="task.dueDate" />
                            </div>
                            <!-- Dropdown -->
                            <div class="form-outline mb-4">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="userName" class="form-label">{{ $t("assignTo") }}</label>
                                    <select id="userName" name="userName" class="form-control" v-model="selectedUser">
                                        <option value="Select_from_list" disabled>Select_from_list</option>
                                        <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}
                                        </option>
                                    </select>
                                </div>
                            </div>
                            <br><br>
                            <div class="form-outline mb-4">
                                <div class="col-md-12 form-group">
                                    <input class="btn btn-primary w-100" type="submit" :disabled="!isCompleted" value="Submit">
                                </div>
                            </div>
                            <div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>