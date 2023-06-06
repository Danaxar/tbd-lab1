<template>
  <div>
    <NavBar />
    <h1 style="text-align: center; font-size: 50px">Emergencias</h1>
    <div class="contenedor">
      <div id="contenido">
        <section>
          <h2>Crear una emergencia</h2>
          <div class="table-responsive">
            <table class="table">
              <!-- Nombre de la emergencia -->
              <tr>
                <td><label for="nombre">Nombre:</label></td>
                <td>
                  <input
                    v-model="nombre"
                    type="text"
                    id="nombre"
                    class="form-control"
                    value="test"
                  />
                </td>
              </tr>
              <!-- Fecha -->
              <tr>
                <td><label for="fecha">Fecha:</label></td>
                <td>
                  <input
                    v-model="fecha"
                    type="date"
                    id="fecha"
                    class="form-control"
                    value="2023-04-16"
                  />
                </td>
              </tr>
              <tr>
                <td>Institución:</td>
                <td>
                  <select
                    v-model="institucion"
                    class="form-select"
                    id="institucion"
                  >
                    <!-- <option value="">Seleccione una opción</option> -->
                    <option value="" disabled selected hidden>
                      Selecciona una opción
                    </option>
                    <!-- Opciones de institución aquí -->
                    <option
                      v-for="(objeto, indice) in instituciones"
                      :key="indice"
                    >
                      {{ objeto.nombre }}
                    </option>
                  </select>
                </td>
              </tr>
            </table>
          </div>
          <h2 class="text-center">Gravedad</h2>
          <div class="table-responsive">
            <table class="table">
              <tr>
                <td><label for="muyGrave">Muy grave</label></td>
                <td>
                  <input
                    type="radio"
                    id="muyGrave"
                    name="gravedad"
                    value="Muy grave"
                    checked
                    v-model="gravedad"
                  />
                </td>
              </tr>
              <tr>
                <td><label for="grave">Grave</label></td>
                <td>
                  <input
                    type="radio"
                    id="grave"
                    name="gravedad"
                    value="Grave"
                    v-model="gravedad"
                  />
                </td>
              </tr>
              <tr>
                <td><label for="media">Media</label></td>
                <td>
                  <input
                    type="radio"
                    id="media"
                    name="gravedad"
                    value="Media"
                    v-model="gravedad"
                  />
                </td>
              </tr>
            </table>
          </div>
          <!-- Seleccionar habilidades -->
          <h2>Habilidades asociadas</h2>
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
                <!-- <button @click="seleccionarHabilidad">✅</button> -->
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
                <!-- <button class="buttonTrash" @click="quitarHabilidad(indice)">
                  🗑️
                </button> -->
              </td>
              <td>
                {{ elemento }}
              </td>
            </tr>
          </table>

          <div id="enviarEmergencia">
            <!-- <button class="btn-completed" @click="enviarEmergencia">
              Completar
            </button> -->
          </div>
        </section>

        <section>
          <h2>Emergencias activas</h2>
          <table bgcolor:black>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Fecha</th>
              <th>Gravedad</th>
              <th>Institucion</th>
            </tr>
            <tr v-for="(objeto, indice) in emergencias" :key="indice">
              <td>{{ indice }}</td>
              <td>{{ objeto.nombre }}</td>
              <td>{{ objeto.fecha }}</td>
              <td>{{ objeto.gravedad }}</td>
              <td>
                {{
                  objeto.id_institucion &&
                  instituciones[objeto.id_institucion - 1]?.nombre_institucion
                }}
              </td>
            </tr>
          </table>
        </section>
      </div>
      <button @click="test">Test</button>
    </div>
  </div>
</template>
<script>
import NavBar from '../components/NavBar.vue'
import axios from 'axios'

export default {
  name: 'EmergenciasView',
  components: { NavBar },
  data() {
    return {
      // Form
      nombre: '',
      fecha: '',
      institucion: '', //! Pendiente
      gravedad: '',
      //

      emergencias: [],
      habilidades: [],
      habilidadesSeleccionadas: [],
      instituciones: [], // Lista de instituciones
    }
  },
  methods: {
    async cargarInstituciones() {
      console.log('Cargando instituciones: ')
      try {
        const respuesta = await axios.get(
          'http://localhost:8080/api/instituciones'
        )
        this.instituciones = respuesta.data
      } catch (error) {
        console.log(error)
      }
    },
    async test() {
      console.log(this.nombre)
      console.log(this.fecha)
      console.log(this.instituciones)
      console.log(this.institucion)
    },
  },
  created() {
    this.cargarInstituciones()
  },
}
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
