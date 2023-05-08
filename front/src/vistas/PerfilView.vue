<template>
  <div id="contenido">
    <h1 style="text-align: center; font-size: 50px">Mi perfil 👤</h1>
    <div class="flex">
      <MenuBar></MenuBar>
      <div id="datos" v-if="status">
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
        <table>
          <tr>
            <td colspan="2">Ingrese sus habilidades</td>
          </tr>

          <tr>
            <td>
              <select>
                <option
                  id="habilidades"
                  name="habilidades"
                  v-for="(habilidad, indice) in habilidades"
                  :key="indice"
                >
                  {{ habilidad.nombre_habilidad }}
                </option>
              </select>
            </td>
            <td>
              <button @click="seleccionarHabilidad">✅</button>
            </td>
          </tr>
          <tr
            v-for="(elemento, indice) in habilidadesSeleccionadas"
            :key="indice"
          >
            <td>
              <button class="buttonTrash" @click="quitarHabilidad(indice)">
                🗑️
              </button>
            </td>
            <td>
              {{ elemento }}
            </td>
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
      status: null,
      habilidades: [],
      habilidadesSeleccionadas: [],
    };
  },
  methods: {
    async cargarDatos() {
      console.log("Cargando información de perfil...");
      const rut = JSON.parse(localStorage.getItem("client")).rut;
      const datos = await axios.get(
        `http://localhost:8081/voluntario/rut/${rut}`
      );
      console.log("Sus datos son: ", datos.data);
      this.perfil = datos.data;
      // console.log("perfil: ", this.perfil);
      this.status = true;
      return datos;
    },
    checkLogin() {
      const iniciado = JSON.parse(localStorage.getItem("login"));
      if (iniciado === false) {
        window.location.replace("http://localhost:8080/");
      }
    },
    async cargarHabilidades() {
      try {
        const respuesta = await axios.get("http://localhost:8081/habilidad");
        this.habilidades = respuesta.data;
      } catch (error) {
        console.log(error);
      }
    },
    seleccionarHabilidad() {
      const selected = document.getElementsByTagName("option");
      const habilidad = Array.from(selected).find(
        (e) => e.selected == true
      ).value;
      if (!this.habilidadesSeleccionadas.find((e) => e === habilidad)) {
        this.habilidadesSeleccionadas.push(habilidad);
      }
    },
    quitarHabilidad(indice) {
      this.habilidadesSeleccionadas.splice(indice, 1);
    },
  },
  mounted() {
    this.checkLogin();
    this.cargarDatos();
    this.cargarHabilidades();
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
  justify-content: space-evenly;
  align-items: center;
}

#datos table {
  font-size: 20px;
  border-collapse: collapse;
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

#datos table td {
  text-align: left;
}
</style>
