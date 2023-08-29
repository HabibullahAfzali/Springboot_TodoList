<script setup>
import Navbar from '../components/Navbar.vue';
import { ref, onMounted } from 'vue';
import { useRouter, useRoute } from 'vue-router';
import axios from 'axios';

const task = ref({
    title: '',
    description: '',
    dueDate: '',
    isCompleted: ''
});
const users = ref([]);
const selectedUser = ref('');
const router = useRouter();
const route = useRoute();
// changes date format
const formatDueDateForBackend = (date) => {
    const formattedDate = new Date(date);

    const year = formattedDate.getFullYear();
    const month = (formattedDate.getMonth() + 1).toString().padStart(2, '0');
    const day = formattedDate.getDate().toString().padStart(2, '0');
    const hours = formattedDate.getHours().toString().padStart(2, '0');
    const minutes = formattedDate.getMinutes().toString().padStart(2, '0');
    const seconds = formattedDate.getSeconds().toString().padStart(2, '0');
    const formattedDateString = `${year}-${month}-${day}T${hours}:${minutes}:${seconds}`;
    return formattedDateString;
};
onMounted(() => {
    getTasks();
    fetchUsers();
});
const getTasks = () => {
    axios.get(`http://localhost:8080/tasks/${route.params.id}`)
        .then((res) => {
            task.value = res.data;
            selectedUser.value = res.data.user.id;
            task.value.dueDate = res.data.dueDate.split('T')[0];

        })
        .catch((error) => { console.error('Not able to fetch tasks:', error.response) });

};
const fetchUsers = () => {
    axios.get('http://localhost:8080/users')
        .then(res => {
            users.value = res.data;
        })
        .catch(error => {
            console.error('Users not found!', error);
        });
};
const updateTask = () => {
    const formattedDueDate = formatDueDateForBackend(task.value.dueDate);
    const updatedTask = {
        ...task.value, dueDate: formattedDueDate, user: { id: selectedUser.value }
    }
    axios.put(`http://localhost:8080/tasks/${task.value.id}`, updatedTask)
        .then(() => {
            alert("Task updated successfully");
            router.push('/tasklist');
        })
        .catch((error) => {
            console.error("Not able to Update the task:", error.response)
        });
};
</script>
<template>
    <main>
        <Navbar/>
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Keep in mind that you'r goin to <br />
                        <span style="color: hsl(218, 81%, 75%)">Make your future</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Good Luck!
                    </p>
                </div>
                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>
                    <h2 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">Update Todo
                        List</h2>
                    <div class="card-body px-4 py-5 px-md-5">
                        <form @submit.prevent="updateTask">
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="title" class="form-label">Title</label>
                                    <input id="title" type="text" name="Title" class="form-control" placeholder="Title"
                                        required v-model="task.title">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="description" class="form-label">Description</label>
                                    <textarea id="description" type="text" name="description" class="form-control"
                                        placeholder="description" required v-model="task.description"></textarea>
                                </div>
                            </div>
                            <div class="mr-3">
                                <label for="dueDate" class="form-label">Due Date</label>
                                <input id="dueDate" type="date" name="dueDate" class="form-control" required
                                    v-model="task.dueDate" />
                            </div>
                            <!--  Dropdown -->
                            <div class="row">
                                <div class="col-md-12 form-group mb-3">
                                    <label for="userName" class="form-label">User</label>
                                    <select id="userName" name="userName" class="form-control" v-model="selectedUser">
                                        <option value="Select_from_list" disabled>Select_from_list</option>
                                        <option v-for="user in users" :key="user.id" :value="user.id">{{ user.username }}
                                        </option>
                                    </select>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12 form-group">
                                    <input class="btn btn-primary w-100" type="submit" value="Submit">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>