<template>
  <div>
    <h1 style="text-align: center; font-size: 50px">Emergencias</h1>
    <div class="contenedor">
      <MenuBar></MenuBar>

      <div id="contenido">
        <section>
          <h2>Crear una emergencia 🚨</h2>
          <table>
            <!-- Nombre de la emergencia -->
            <tr>
              <td><label>Nombre:</label></td>
              <td><input type="text" value="test" /></td>
            </tr>
            <!-- Fecha -->
            <tr>
              <td>
                <label>Fecha:</label>
              </td>
              <td>
                <input type="date" value="2023-04-16" />
              </td>
            </tr>
          </table>
          <h2 style="text-align: center">Gravedad 🌡️</h2>
          <table>
            <tr>
              <td><label>Muy grave</label></td>
              <td>
                <input
                  type="radio"
                  name="gravedad"
                  value="Muy grave"
                  checked="true"
                />
              </td>
            </tr>
            <tr>
              <td><label>Grave</label></td>
              <td>
                <input type="radio" name="gravedad" value="Grave" />
              </td>
            </tr>
            <tr>
              <td><label>Media</label></td>
              <td>
                <input type="radio" name="gravedad" value="Media" />
              </td>
            </tr>
          </table>
          <!-- Seleccionar habilidades -->
          <h2>Habilidades asociadas 🛠️</h2>
          <table>
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
          </table>
          <!-- Mostrar habilidades seleccionadas -->
          <table>
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

          <div id="enviarEmergencia">
            <button class="btn-completed" @click="enviarEmergencia">
              Completar
            </button>
          </div>
        </section>

        <section>
          <h2>☢️ Emergencias activas ☢️</h2>
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
      habilidades: [],
      habilidadesSeleccionadas: [],
    };
  },
  methods: {
    async enviarEmergencia() {
      if (this.habilidadesSeleccionadas.length == 0) {
        alert("Debe seleccionar al menos una habilidad");
        return;
      }
      const inputs = document.getElementsByTagName("input");

      // Construir objeto Emergencia
      const respuestas = {
        nombre_emergencia: inputs[0].value,
        gravedad_emergencia: Array.from(inputs).find(
          (elemento) => elemento.checked === true
        ).value,
        fecha_emergencia: inputs[1].value,
      };

      //!! Enviar a backend
      const respuestaEmergencia = await axios.post(
        "http://localhost:8081/emergencia",
        JSON.stringify(respuestas),
        { headers: { "Content-Type": "application/json" } }
      );
      const id = respuestaEmergencia.data.id;
      console.log("Id obtenido:", id);

      // Enviar emergencia_habilidad
      //! No se agrega el último elemento
      this.habilidadesSeleccionadas.forEach((element, index) => {
        axios.post("http://localhost:8081/emehabilidad", {
          id_emergencia: id,
          id_habilidad: index + 1,
        });
      });

      window.location.reload();
    },
    async cargarEmergencias() {
      try {
        const response = await axios.get("http://localhost:8081/emergencia");
        this.emergencias = response.data;
      } catch (error) {
        console.error(error);
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
  created() {
    this.cargarEmergencias();
    this.cargarHabilidades();
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

/* Secciones general */
#contenido section {
  width: 50%;
  /* border-style: solid; */
  padding: 30px;
  /* background-color: black; */
}

#contenido section h2 {
  text-align: center;
}

table {
  margin: auto;
  border-collapse: collapse;
  width: 75%;
  border-radius: 10px;
  overflow: hidden;
}

table + h2 {
  margin-top: 15px;
}

h2 + table {
  margin-top: 5px;
}

table th,
table td {
  /* border: 1px solid; */
  padding: 5px;
  background-color: rgba(30, 86, 101, 0.5);
  text-align: center;
}

.buttonTrash {
  background-color: red;
}

.btn-completed {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 10px 20px;
  display: inline-block;
  text-align: center;
  font-size: 16px;
  margin: 10px;
  border-radius: 7px;
  cursor: pointer; /* Cambia el cursor cuando se pasa sobre el botón */
}

.btn-completed:hover {
  background-color: #3e8e41;
}

#enviarEmergencia button {
  margin-left: 40%;
}
</style>
