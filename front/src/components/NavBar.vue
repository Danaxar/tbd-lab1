<template>
  <div id="nav">
    <a id="logoLink" href="/">
      <img id="logo" src="../assets/logo.png" />
      <span id="namepage">esQ</span>
    </a>
    <button @click="logout" v-if="sesion">Cerrar sesión</button>
    <!-- <button @click="test">test</button> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      titulo: "NavBar",
      sesion: null,
    };
  },
  methods: {
    logout() {
      const login = JSON.parse(localStorage.getItem("login"));
      if (login) {
        // Cerrar sesión
        localStorage.setItem("login", String(false));
        localStorage.setItem("client", JSON.stringify({}));
        this.sesion = false;
        alert("Sesión cerrada.");
        console.log("Sesión cerrada.");
        window.location.href = "/";
      }
    },
    test() {
      console.log(JSON.parse(localStorage.getItem("login")));
    },
    cargarStatus() {
      console.log("Cargando status...", this.status);
      this.sesion = JSON.parse(localStorage.getItem("login"));
    },
  },

  mounted() {
    this.cargarStatus();
  },
};
</script>

<style scoped>
#nav {
  background-color: rgba(0, 0, 0, 0.4);
  display: flex;
  justify-content: center;
}

#logo {
  width: 50px;
  margin-top: 1em;
  margin-left: 1em;
  margin-bottom: 2em;
}

#namepage {
  color: white;
  font-size: 30px;
  letter-spacing: 1px;
}

#logoLink {
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
