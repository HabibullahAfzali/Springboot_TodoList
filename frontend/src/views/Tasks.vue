<script setup>
import { ref, onMounted } from 'vue';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';

const tasks = ref([]);
const searchQuery = ref('');
const filterUsername = ref('');
const filteredTasks = ref([]);

const reminder = (task) => {
    const currentDate = new Date();
    const dueDateValue = new Date(task.dueDate);
    const timeRemainingInDays = Math.ceil((dueDateValue - currentDate) / (1000 * 60 * 60 * 24));
    return timeRemainingInDays < 2 ? "table-danger" : "";
};

const getTasks = () => {
    axios
        .get('http://localhost:8080/tasks', {
            params: {
                id: 0,
                title: searchQuery.value,
                description: searchQuery.value,
                dueDate: searchQuery.value,
                isCompleted: searchQuery.value
            },
        })
        .then((res) => {
            tasks.value = res.data.map(task => {

                  if (task.user && task.user.profilePicture) {
                    task.user.profilePicture = `http://localhost:8080/Images/${task.user.profilePicture}`;
                } else {
                    task.user.profilePicture = "";
                }
                return {
                    ...task,
                    isCompleted: task.isCompleted === 1,
                  
                }
            });
            console.log(tasks)
        })
        .catch((error) => {
            console.error('Not able to fetch tasks:', error);
        });
};
const updateCompletionStatus = (task) => {
    axios.put(`http://localhost:8080/tasks/${task.id}/complete`)
        .catch((error) => {
            console.error('Not able to update task:', error);
        });
};
const deleteTask = (id) => {
    axios
        .delete(`http://localhost:8080/tasks/${id}`)
        .then(() => {
            getTasks();
            deleteSuccess.value = true;
            setTimeout(() => {
                deleteSuccess.value = false;
            }, 5000);
        })
        .catch((error) => {
            console.error('Not able to fetch task:', error);
        });
};
const applyFilter = () => {
    filteredTasks.value = tasks.value.filter(task => {
        if (!filterUsername.value.trim() || task.user && task.user.username.toLowerCase().includes(filterUsername.value.toLowerCase())) {
            return true;
        }
        return false;
    });
};
onMounted(() => {
    getTasks();
});
</script>
<template>
    <main>
        <Navbar/>
        <!-- Table-->
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                    <div class="d-flex mt-3 justify-content-center">
                        <h1 style="color: hsl(218, 81%, 75%)">Your Todo List</h1>
                    </div>
                    <!--Add button -->
                    <div class="d-flex justify-content-start" id="newtask">
                        <a href="/addtask" class="btn btn-primary">New Task</a>
                    </div>
                    <div class="input-group mb-3 mt-3">
                        <input type="text" class="form-control" v-model="filterUsername" @keyup.enter="applyFilter"
                            placeholder="Enter username">
                        <button class="btn btn-outline-primary" type="button" @click="applyFilter">Search</button>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                                <tr>
                                    <th scope="col">Title</th>
                                    <th scope="col">Description </th>
                                    <th scope="col">Due Date</th>
                                    <th scope="col">Assigned To</th>
                                    <th scope="col">Is Completed?</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="task in filteredTasks" :key="task.id" :class="reminder(task)">
                                    <th scope="row">{{ task.title }}</th>
                                    <td>{{ task.description }}</td>
                                    <td>{{ task.dueDate }}</td>
                                    <td v-if="task.user">
                                        <div class="d-flex align-items-center">
                                            <img :src="task.user.profilePicture" alt="Profile Picture"
                                                class="profile-picture" />
                                            <span class="mx-2">{{ task.user.username }}</span>
                                        </div>
                                    </td>
                                    <td v-else></td>
                                    <td>
                                        <input type="checkbox" v-model="task.isCompleted"
                                            @change="updateCompletionStatus(task)">
                                    </td>
                                    <td>
                                        <a class="btn btn-primary" :href="`/update/${task.id}`">Edit</a>
                                        <button class="btn btn-danger mx-2" @click="deleteTask(task.id)">Delete</button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </main>
</template>

<style scoped>
.profile-picture {
    width: 40px;
    height: 40px;
    border-radius: 50%;
    object-fit: cover;
    margin-right: 8px;
}
</style>
