<template>
  <div>
    <h1 style="text-align: center">Emergencias</h1>
    <div class="contenedor">
      <MenuBar></MenuBar>
      <div id="contenido">
        <section>
          <h2>Crear una emergencia</h2>
          <div id="formEmergencia">
            <label
              >Nombre:
              <input type="text" value="" />
            </label>
            <div id="gravedad">
              <h3 style="margin-top: 20px">Gravedad</h3>
              <label>
                Muy grave
                <input type="radio" name="gravedad" value="Muy grave" />
              </label>
              <label>
                Grave
                <input type="radio" name="gravedad" value="Grave" />
              </label>
              <label>
                Media
                <input type="radio" name="gravedad" value="Media" />
              </label>
            </div>
            <label>
              Fecha:
              <input type="date" />
            </label>
          </div>
          <button @click="enviarEmergencia">Crear emergencia</button>
        </section>

        <section>
          <h2>Emergencias activas</h2>
          <table bgcolor:black>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Fecha</th>
              <th>Gravedad</th>
            </tr>
            <tr v-for="(objeto, indice) in emergencias" :key="indice">
              <td>{{ indice }}</td>
              <td>{{ objeto.nombre }}</td>
              <td>{{ objeto.fecha }}</td>
              <td>{{ objeto.gravedad }}</td>
            </tr>
          </table>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import MenuBar from "@/components/MenuBar.vue";
import axios from "axios";
export default {
  name: "EmergenciasView",
  components: { MenuBar },
  data() {
    return {
      emergencias: [],
    };
  },
  methods: {
    enviarEmergencia() {
      const inputs = document.getElementsByTagName("input"); // Botones del DOM

      // Sintetizar valores en un objecto
      const respuestas = {
        nombre_emergencia: inputs[0].value,
        gravedad_emergencia: Array.from(inputs).find(
          (elemento) => elemento.checked === true
        ).value,
        fecha_emergencia: inputs[4].value,
      };
      console.log("respuestas: ", respuestas);

      // Enviar a backend
      axios.post(
        "http://localhost:8081/emergencia",
        JSON.stringify(respuestas),
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );

      window.location.reload();
    },
    async cargarEmergencias() {
      try {
        console.log("Cargando emergencias");
        const response = await axios.get("http://localhost:8081/emergencia");
        this.emergencias = response.data;
        console.log(this.emergencias);
      } catch (error) {
        console.error(error);
      }
    },
  },
  created() {
    this.cargarEmergencias();
  },
};
</script>
<style scoped>
.contenedor {
  display: flex;
}

#contenido {
  width: 100%;
  display: flex;
}

#contenido section {
  width: 50%;
  border-style: solid;
  padding: 30px;
}

#contenido section h2 {
  text-align: center;
}

#gravedad {
  display: flex;
  flex-direction: column;
}

button {
  background-color: rgb(40, 218, 40);
}

table {
  margin: auto;
  margin-top: 25px;
  border: 1px solid white;
  border-collapse: collapse;
  width: 100%;
}

table th,
table td {
  border: 1px solid white;
  padding: 5px;
}
</style>
