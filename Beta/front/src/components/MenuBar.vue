<template>
  <div id="content">
    <div id="profilePhoto">
      <!-- <img
        src="https://p-bio.org/wp-content/uploads/2020/09/profile-picture-template.png"
      /> -->
      <img
        src="https://preview.redd.it/mbud6h6b7od81.png?width=1440&format=png&auto=webp&s=49f9aeea394f3a2b5c1fee6a83a124f80ab9f652"
      />
      <div id="profileData">
        <table>
          <tr>
            <h4 v-if="client">{{ client.nombre + " " + client.apellido }}</h4>
          </tr>
          <tr>
            <h6 v-if="client">{{ client.telefono }}</h6>
          </tr>
        </table>
      </div>
    </div>
    <table>
      <tr>
        <td>👤</td>
        <td><a href="#/perfil">Perfil </a></td>
      </tr>
      <tr>
        <td>🆘</td>
        <td><a href="#/emergencias">Emergencias </a></td>
      </tr>
      <tr>
        <td>🏛️</td>
        <td><a href="#/instituciones">Instituciones </a></td>
      </tr>
      <tr>
        <td>📚</td>
        <td><a href="#/tareas">Tareas </a></td>
      </tr>
    </table>
    <button class="logout-button" @click="logout" v-if="sesion">
      Cerrar sesión
    </button>
  </div>
</template>

<script>
export default {
  name: "MenuBar",
  data() {
    return {
      sesion: null,
      client: null,
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
    cargarStatus() {
      this.sesion = JSON.parse(localStorage.getItem("login"));
      console.log("Login: ", this.sesion);
      this.client = JSON.parse(localStorage.getItem("client"));
      console.log("Cliente: ", this.client);
    },
  },
  mounted() {
    this.cargarStatus();
  },
};
</script>
<style scoped>
#content {
  width: 250px;
  height: 100%;
  /* border-width: 1px; */
  padding: 10px;
  background-color: #0a0e18;
  border-radius: 15px 15px 15px 15px;
}

#content table {
  list-style: none;
  font-size: 25px;
  text-align: left;
}

#content table tr td a {
  text-decoration: none;
  color: white;
  transition: 0.4s;
}

#content table tr a:hover {
  /* color: #db2b39; */
  color: #099d35;
  transition: 0.2s;
}

#profilePhoto img {
  width: 100%;
}

/* Botton logout */
button.logout-button {
  background-color: #ff0000;
  color: #fff;
  border: none;
  border-radius: 5px;
  padding: 10px 20px;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

button.logout-button:hover {
  background-color: #7b0000;
}
</style>
