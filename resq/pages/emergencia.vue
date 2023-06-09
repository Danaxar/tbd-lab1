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
                    class="form-select custom-select"
                    id="institucion"
                  >
                    <option value="" disabled selected hidden>
                      Selecciona una opción
                    </option>
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
              <tr v-for="(objeto, indice) in gravedades" :key="indice">
                <td>
                  <label>{{ objeto }}</label>
                </td>
                <td>
                  <input type="radio" :value="objeto" v-model="gravedad" />
                </td>
              </tr>
            </table>
          </div>
          <!-- Seleccionar habilidades -->
          <h2>Habilidades asociadas</h2>
          <table>
            <tr v-for="(objeto, indice) in habilidades" :key="indice">
              <td>{{ objeto.nombre }}</td>
              <td>
                <input
                  type="checkbox"
                  :value="objeto.nombre"
                  v-model="habilidadesSeleccionadas"
                />
              </td>
            </tr>
          </table>
          <button class="btn btn-success" @click="enviar">Completar</button>
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
      // Form crear una emergencia
      nombre: '',
      fecha: '',
      institucion: '',
      gravedad: '',
      habilidadesSeleccionadas: [],

      // Datos traidos desde el backend
      habilidades: [],
      instituciones: [], // Lista de instituciones
      gravedades: ['Muy grave', 'Grave', 'Media'],

      // Lista de emergencias activas
      emergencias: [],
    }
  },
  methods: {
    async cargarInstituciones() {
      try {
        const respuesta = await axios.get(
          'http://localhost:8080/api/instituciones'
        )
        this.instituciones = respuesta.data
      } catch (error) {
        console.log(error)
      }
    },
    async cargarHabilidades() {
      try {
        const respuesta = await axios.get(
          'http://localhost:8080/api/habilidades'
        )
        this.habilidades = respuesta.data
      } catch (error) {
        console.log(error)
      }
    },
    async enviar() {
      // Enviar emergencia
      const emergencia = {
        nombre: this.nombre,
        gravedad: this.gravedad,
        fecha: this.fecha,
        institucion: this.institucion,
        habilidades: this.habilidadesSeleccionadas
      }

      try{
        const response = await axios.post(
          "http://localhost:8080/api/emergencias",
            emergencia,
        )
        console.log(response)
      }catch(error){
        console.log(error)
      }
    },
    async test() {
      console.log(this.nombre)
      console.log(this.fecha)
      console.log(this.institucion)   
      console.log(this.gravedad)
      console.log(this.habilidades)
      console.log(this.habilidadesSeleccionadas)

      this.enviar();
    },
  },
  created() {
    this.cargarInstituciones()
    this.cargarHabilidades()
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
  padding: 5px;
  background-color: rgba(30, 86, 101, 0.5);
  text-align: center;
}
</style>
