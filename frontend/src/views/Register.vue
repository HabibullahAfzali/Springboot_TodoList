<script setup>
import Navbar from '../components/Navbar.vue';
import { ref, computed } from 'vue'
import axios from "axios";
import { useRouter } from 'vue-router';

const user = ref({
    username: '',
    email: '',
    password: ''
});
const route = useRouter();
const profilePicture = ref(null);
const handleProfilePictureUpload = (event) => {
    profilePicture.value = event.target.files[0];
}
const signUp = () => {
    const formData = new FormData();
    for (const key in user.value) {
        formData.append(key, user.value[key]);
    }
    if (profilePicture.value) {
        formData.append('image', profilePicture.value);
    }
    axios.post('http://localhost:8080/users', formData).then(() => {
        alert("User successfully added!")
        route.push('/Viewusers');
    }).catch(error => {
        console.error('not able to add!', error);
    });
}
const isFormComplete = computed(() => {
    return (
        user.value.username.trim() !== '' &&
        user.value.email.trim() !== '' &&
        user.value.password.trim() !== ''
    );
});
</script>
<template>
    <main>
    <Navbar/>
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
                        <h1 class="mt-3 display-5 fw-bold ls-tight text-center" style="color: hsl(218, 81%, 75%)">{{ $t("SignUp") }}
                        </h1>
                        <div class="card-body px-4 py-5 px-md-5">
                            <form @submit.prevent="signUp">
                                <!-- Profile Picture input -->
                                <div class="form-outline mb-4">
                                    <label class="profile-picture-label cursor-pointer" for="profilePictureInput">
                                        <input type="file" @change="handleProfilePictureUpload($event)"
                                            class="form-control d-none" id="profilePictureInput" ref="fileInput" />
                                        <i class="bi bi-camera-fill"></i>
                                        <span class="overlay-text">Upload Photo</span>
                                    </label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="text" class="form-control center" v-model="user.username" />
                                    <label class="form-label" for="form3Example1">{{ $t("username") }}</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="email" class="form-control" v-model="user.email" />
                                    <label class="form-label" for="form3Example2">{{ $t("email") }}</label>
                                </div>
                                <div class="form-outline mb-4">
                                    <input type="password" class="form-control" v-model="user.password" />
                                    <label class="form-label" for="form3Example4">{{ $t("password") }}</label>
                                </div>
                                <button type="submit" :disabled="!isFormComplete" class="btn btn-primary btn-block mb-4 form-control">
                                    {{ $t("submit") }}
                                </button>
                                <div class="text-center">
                                    <p> {{ $t("message") }} </p>
                                    <a href="/Welcome">{{ $t("login") }}</a>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </main>
</template>

<style scoped>
.profile-picture-label {
    display: inline-block;
    width: 120px;
    height: 120px;
    border-radius: 50%;
    background-color: #e2e2df;
    text-align: center;
    line-height: 120px;
    cursor: pointer;
    transition: background-color 0.3s ease;
}

.profile-picture-label i {
    font-size: 36px;
}

.profile-picture-label:hover {
    background-color: #0a6fea;
}
</style>
