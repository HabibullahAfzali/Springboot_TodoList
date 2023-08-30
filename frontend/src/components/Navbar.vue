<script>
</script>
<template>
    <main> 
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary" :dir="$i18n.locale =='fa'?'rtl':'ltr'">
      <div class="container-fluid">
        <a class="navbar-brand" href="/">DevList</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
          <ul class="navbar-nav me-auto mb-2 mb-lg-0">
             <router-link to="/Viewusers" exact class="nav-link" exact-active-class="active">{{$t('Users')}}</router-link>
             <router-link to="/" exact class="nav-link" exact-active-class="active">{{ $t('SignUp') }}</router-link>
           
             <router-link to="/addtask" exact class="nav-link" exact-active-class="active">{{ $t('Newlist') }}</router-link>
           
             <router-link to="/tasklist" exact class="nav-link" exact-active-class="active">{{ $t('Todolist') }}</router-link>
          </ul>
    <div>
      <select v-model="$i18n.locale">
        <option
          v-for="locale in $i18n.availableLocales"
          :key="`locale-${locale}`"
          :value="locale"
        >
          {{ locale }}
        </option>
      </select>
    </div>

        </div>
      </div>
    </nav>
    </main>
</template>