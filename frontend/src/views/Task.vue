<script setup>
import Navbar from '../components/Navbar.vue';
import {ref} from 'vue'
import axios from "axios";
import { useRouter } from 'vue-router';

</script>

<template>
    <Navbar />

    <div class="container my-5 py-5 card bg-glass col-md-6 custom-card">
        <h1 class="text-center mb-5">DevList</h1>
            <table class="table custom-table">
                <thead>
                    <tr class="table-secondary custom-row">           
                        <th scope="col" class="col-4">Tarea</th>
                        <th scope="col" class="">Descripción</th>         
                    </tr>
                </thead>
            </table>
        <h2>Pendientes</h2>
            <table class="table custom-table">
                <tbody>
                    <tr class="custom-row">
                        <td class="col-md-4">Mark</td>
                        <td>Otto</td>       
                    </tr>
                </tbody>
            </table>
            <table class="table custom-table">
        <h2>Finalizadas</h2>
                <tbody>
                    <tr class="table-danger custom-row"> 
                        <td class="col-md-4">Jacob</td>
                        <td>Thornton</td>     
                    </tr>         
                </tbody>
            </table>   

      
    </div>
  
  
</template>

<style scope>
  .custom-table {
    border-collapse: collapse;
    width: 100%;
    
  }

  .custom-table th,
  .custom-table td {
    border: 3px solid #000000;
    padding: 8px;
    text-align: center;
   
  }
  
  .custom-table .custom-row {
    height: 50px; 
  }

  .custom-card {
    background-image: url('../images/imagen_fondo.png');
    background-size: cover; 
    background-position: center; 
  }
  h1, h2 {
    color: white;
  }
 
</style>