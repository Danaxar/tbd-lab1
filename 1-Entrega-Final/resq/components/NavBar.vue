<template>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="/home">
        <img id="logo" src="@/static/logo.png" />
        esQ</a
      >
      <a class="navbar-brand" href="/home">home</a>
      <button
        class="navbar-toggler"
        type="button"
        data-toggle="collapse"
        data-target="#navbarNav"
        aria-controls="navbarNav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link" href="/perfil">Perfil</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/emergencia">Crear emergencia</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/tarea">Tareas</a>
          </li>
          <li class="nav-item">
            <button @click="logout" class="btn btn-danger">
              Cerrar sesión
            </button>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>
<script>
export default {
  methods: {
    logout() {
      localStorage.clear()
      window.location.href = '/'
    },
  },
}
</script>
<style scoped>
nav {
  background-color: aqua;
}

#logo {
  width: 25px;
  padding-bottom: 10%;
}
</style>
