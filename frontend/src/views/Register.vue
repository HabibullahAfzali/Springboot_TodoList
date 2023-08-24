<script setup>
import Navbar from '../components/Navbar.vue';
import {ref} from 'vue'
import axios from "axios";
import { useRouter } from 'vue-router';

const user = ref({
    username:'',
    email:'',
    password: ''
});
const route = useRouter();
const signUp = () => {
    const newUser = {...user.value}

    axios.post('http://localhost:8080/users', newUser).then(() => {
        
        alert("User successfully added!")
        route.push('/');
    }).catch(error => {

        console.error('not able to add!',error)
      
        
    })
}
</script>
<template>
    <main>
        <Navbar />
        <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
            <div class="row gx-lg-5 align-items-center mb-5">
                <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                    <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                        Bienvenidos a <br />
                        <span style="color: hsl(218, 81%, 75%)">la ToDoList</span>
                    </h1>
                    <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                        Para ver tus avances en el desarrollo de software
                    </p>
                </div>

                <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                    <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                    <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                    <div class="card bg-glass">
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">Sign Up
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="signUp">
                                 <!-- Profile Picture input -->
                <!-- <div class="form-outline mb-4">
                  <input type="file" @change="ProfilePictureUpload" class="form-control" />
                </div> -->
                                <div class="form-outline mb-4">
                                    <input type="text" class="form-control center" v-model="user.username" />
                                    <label class="form-label" for="form3Example1">User name</label>
                                </div>

                                <!-- Password input -->
                                <div class="form-outline mb-4">
                                    <input type="email"  class="form-control" v-model="user.email" />
                                    <label class="form-label" for="form3Example2">Email</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" class="form-control" v-model="user.password" />
                                    <label class="form-label" for="form3Example4">Password</label>
                                </div>

                                <!-- Submit button -->
                                <button type="submit" class="btn btn-primary btn-block mb-4 form-control" >
                                    Submit
                                </button>

                                <!-- Register buttons -->
                                <div class="text-center">
                                    <p> Alreday have an account </p>
                                    <a href="/">Login</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>


