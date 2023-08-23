<script setup>
import Navbar from '../components/Navbar.vue';
import {ref} from 'vue'
import axios from "axios";
import { useRouter } from 'vue-router';

</script>

<template>
    <Navbar />
    <table class="table">
  <thead>
    <tr class="table-primary">
      <th scope="col"></th>
      <th scope="col">Tarea</th>
      <th scope="col">Descripción</th>
      
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      
    </tr>
    <tr class="table-danger">
      <th scope="row"></th>
      <td>Jacob</td>
      <td>Thornton</td>
      
    </tr>
   
  </tbody>
</table>
  
</template>