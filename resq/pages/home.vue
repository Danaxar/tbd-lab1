<template>
  <div>
    <NavBar />
    <div class="container">
      <!-- Contenido de la página principal -->
      <!-- <h1>Pagina principal</h1> -->
      <div class="contenido">
        <div>
          <h2>Emergencias activas</h2>
          <table bgcolor:black>
            <tr>
              <th>Id</th>
              <th>Nombre</th>
              <th>Fecha</th>
              <th>Gravedad</th>
              <th>Estado</th>
              <th>Institucion</th>
              <th></th>
            </tr>
            <tr v-for="(objeto, indice) in emergencias" :key="indice">
              <td>{{ indice }}</td>
              <td>{{ objeto.nombre }}</td>
              <td>{{ objeto.fecha }}</td>
              <td>{{ objeto.gravedad }}</td>
              <td>{{ objeto.estado }}</td>
              <td>
                <!-- {{ instituciones[objeto.idInstitucion - 1].nombre }} -->
              </td>
              <td>
                <button
                  class="btn btn-info"
                  @click="detallesEmergencia(objeto)"
                >
                  Ver detalles 🔍
                </button>
              </td>
            </tr>
          </table>
        </div>
        <Mapa :puntos="markers" />
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import Mapa from '~/components/Mapa.vue'
import NavBar from '../components/NavBar.vue'

export default {
  components: {
    NavBar,
    Mapa,
  },
  data() {
    return {
      // Lista de emergencias activas
      emergencias: [],
      instituciones: [], // Lista de instituciones
      markers: [],
    }
  },
  methods: {
    async cargarEmergencias() {
      try {
        const response = await axios.get(
          'http://localhost:8080/api/emergencias'
        )
        this.emergencias = response.data
        console.log('Emergencias: ', this.emergencias)

        // Cargar markers
        for (let i = 0; i < this.emergencias.length; i++) {
          var emergencia = this.emergencias[i]
          console.log(`emergencia[${i}]`, emergencia[i])
          var mark = {
            latLng: [emergencia.latitud, emergencia.longitud],
            name: emergencia.nombre,
          }
          this.markers.push(mark)
        }
      } catch (error) {
        console.log(error)
      }
    },
    detallesEmergencia(objeto) {
      console.log(objeto)
      localStorage.setItem('emergencia', JSON.stringify(objeto))
      window.location.href = '/detallesEmergencia'
    },
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
  },
  created() {
    this.cargarInstituciones()
    this.cargarEmergencias()
  },
}
</script>

<style scoped>
.contenido {
  display: flex;
  margin-top: 50px;
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
