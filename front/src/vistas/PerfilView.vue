<template>
  <div id="contenido">
    <h1 style="text-align: center; font-size: 50px">Mi perfil 👤</h1>
    <div class="flex">
      <MenuBar></MenuBar>
      <div id="datos">
        <table>
          <tr>
            <td>Id:</td>
            <td>{{ perfil.id }}</td>
          </tr>
          <tr>
            <td>Nombres:</td>
            <td>{{ perfil.nombre }}</td>
          </tr>
          <tr>
            <td>Apellidos:</td>
            <td>{{ perfil.apellido }}</td>
          </tr>
          <tr>
            <td>Fecha de nacimiento:</td>
            <td>{{ perfil.fechaNacimiento }}</td>
          </tr>
          <tr>
            <td>Disponibilidad:</td>
            <td>{{ perfil.disponibilidad }}</td>
          </tr>
          <tr>
            <td>Rut:</td>
            <td>{{ perfil.rut }}</td>
          </tr>
          <tr>
            <td>Telefono:</td>
            <td>{{ perfil.telefono }}</td>
          </tr>
          <tr>
            <td>Rol:</td>
            <td>{{ perfil.rol_voluntario }}</td>
          </tr>
        </table>
      </div>
    </div>
  </div>
</template>

<script>
import MenuBar from "@/components/MenuBar.vue";
import axios from "axios";
export default {
  name: "PerfilView",
  components: {
    MenuBar,
  },
  data() {
    return {
      perfil: null,
    };
  },
  methods: {
    async cargarDatos() {
      const rut = JSON.parse(localStorage.getItem("client")).rut;
      const datos = await axios.get(
        `http://localhost:8081/voluntario/rut/${rut}`
      );
      console.log("Sus datos son: ", datos.data);
      this.perfil = datos.data;
    },
    checkLogin() {
      JSON.parse(localStorage.getItem("login")) === true
        ? window.location.replace("http://localhost:8080/#/dashboard")
        : window.location.replace("http://localhost:8080/");
    },
  },
  mounted() {
    this.cargarDatos();
  },
  created() {
    this.checkLogin();
  },
};
</script>
<style scoped>
#contenido {
  /* background-color: purple; */
  height: 100%;
}
.flex {
  /* background-color: black; */
  display: flex;
}

#datos {
  width: 100%;
  /* background-color: red; */
  display: flex;
  justify-content: center;
  align-items: center;
}

#datos table {
  font-size: 25px;
  margin: auto;
  border-collapse: collapse;
  width: 50%;
  border-radius: 10px;
  overflow: hidden;
}

#datos table th,
#datos table td {
  /* border: 1px solid; */
  padding: 5px;
  background-color: rgba(30, 86, 101, 0.5);
  text-align: center;
}
</style>
