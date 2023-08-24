<template>
    <main> 
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">DevList</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
             <router-link to="/" exact class="nav-link" exact-active-class="active">Home</router-link>
             <router-link to="/register" exact class="nav-link" exact-active-class="active">Sign Up</router-link>
           
             <router-link to="/addtask" exact class="nav-link" exact-active-class="active">New Todolist</router-link>
           
             <router-link to="/tasklist" exact class="nav-link" exact-active-class="active">TodoLists</router-link>
          </ul>
        </div>
      </div>
    </nav>
    </main>
</template>