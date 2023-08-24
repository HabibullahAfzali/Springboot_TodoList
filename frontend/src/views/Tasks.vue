<script setup>
import { ref, onMounted } from 'vue';
import Navbar from '../components/Navbar.vue';
import axios from 'axios';

const tasks = ref([]);
const searchQuery = ref('');

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
            tasks.value = res.data;
        })
        .catch((error) => {
            console.error('Not able to fetch tasks:', error);
        });
};
const updateCompletionStatus = (task) => {
    axios.put(`http://localhost:8080/tasks/${task.id}`, { ...task })
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
onMounted(() => {
    getTasks();
});
</script>
<template>
    <main>
        <Navbar />
        <!-- Table-->
        <div class="container">
            <div class="row ">
                <div class="col-md-12">
                   <div class="d-flex mt-3 justify-content-center"> 
                    <h1 style="color: hsl(218, 81%, 75%)">Your Todo List</h1>
                    </div>
                    <!--Add button -->
                    <div class="d-flex justify-content-end" id="newtask">
                        <a href="/addtask" class="btn btn-primary">New Task</a>
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
                                <tr v-for="task in tasks" :key="task.id">
                                    <th scope="row">{{ task.title }}</th>
                                    <td>{{ task.description }}</td>
                                    <td>{{ task.dueDate }}</td>
                                    <td v-if="task.user">{{ task.user.username }}</td>
                                    <td v-else></td>
                                     <td>
                                        <input type="checkbox" v-model="task.isCompleted" @change="updateCompletionStatus(task)">
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

