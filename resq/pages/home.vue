<template>
  <div>
    <NavBar />
    <div class="row">
      <div class="col">
        <h1 class="text-center">Emergencias</h1>
        <!-- Primera fila-->
        <div class="row mb-5">
          
          <div class="col-md-5">
            <!-- <Emergencias Activas> -->
            <h3 class="text-center">Emergencias Activas</h3>
            <table id="EmergenciasActivas" bgcolor:black>
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Nombre</th>
                  <th>Fecha</th>
                  <th>Gravedad</th>
                  <th>Estado</th>
                  <th>Institucion</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(objeto, indice) in emergenciasActivas" :key="indice">
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
              </tbody>
            </table>
          </div>
          <!-- div relleno -->
          <div class="col-md-2">
          </div>
          <!-- <Mapa Emergencias Activas> -->
          <div class="col-md-5">
            <div class="map-container">
              <MapaHome id="mapaActivos" :puntos="markers1" />
            </div>
          </div>
        </div>
        <!-- Fila relleno -->
        <div class="row-mb-2">
        </div>
        <!-- Segunda fila -->
        <div class="row mb-5">
          <div class="col-md-5">
            <!-- <Emergencias Finalizadas> -->
            <h3 class="text-center">Emergencias Finalizadas</h3>
            <table id="EmergenciasFinalizadas" bgcolor:black>
              <thead>
                <tr>
                  <th>Id</th>
                  <th>Nombre</th>
                  <th>Fecha</th>
                  <th>Gravedad</th>
                  <th>Estado</th>
                  <th>Institucion</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(objeto, indice) in emergenciasFinalizadas" :key="indice">
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
              </tbody>
            </table>
          </div>
          <!-- div relleno -->
          <div class="col-md-2">
          </div>
          <!-- <Mapa Emergencias Finalizadas> -->
          <div class="col-md-5">
            <div class="map-container">
              <MapaHome id="Mapa Finalizados" :puntos="markers2" />
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import MapaHome from '~/components/MapaHome.vue'
import NavBar from '../components/NavBar.vue'

export default {
  components: {
    NavBar,
    MapaHome,
  },
  data() {
    return {
      // Lista de emergencias activas
      emergenciasActivas: [],
      emergenciasFinalizadas: [],
      instituciones: [], // Lista de instituciones
      markers1: [],
      markers2: [],
    }
  },
  methods: {
    async cargarEmergenciasActivas() {
      try {
        const response = await axios.get(
          'http://localhost:8080/api/emergencias/estado/Activa'
        )
        this.emergenciasActivas = response.data
        console.log('Emergencias Activas: ', this.emergenciasActivas)

        // Cargar markers
        for (let i = 0; i < this.emergenciasActivas.length; i++) {
          var emergencia = this.emergenciasActivas[i]
          // console.log(`emergencia[${i}]`, emergencia[i])
          var mark = {
            latLng: [emergencia.latitud, emergencia.longitud],
            name: emergencia.nombre,
          }
          this.markers1.push(mark)
        }
      } catch (error) {
        console.log(error)
      }
    },
    async cargarEmergenciasFinalizadas() {
      try {
        const response = await axios.get(
          'http://localhost:8080/api/emergencias/estado/Finalizada'
        )
        this.emergenciasFinalizadas = response.data
        console.log('Emergencias Finalizadas: ', this.emergenciasFinalizadas)

        // Cargar markers
        for (let i = 0; i < this.emergenciasFinalizadas.length; i++) {
          var emergencia = this.emergenciasFinalizadas[i]
          // console.log(`emergencia[${i}]`, emergencia[i])
          var mark = {
            latLng: [emergencia.latitud, emergencia.longitud],
            name: emergencia.nombre,
          }
          this.markers2.push(mark)
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
    this.cargarEmergenciasActivas()
    this.cargarEmergenciasFinalizadas()
  },
}
</script>

<style scoped>
.contenido {
  display: flex;
  margin-top: 50px;
}

.map-container {
  height: 200px; /* Ajusta la altura del contenedor del mapa según tus necesidades */
  margin-bottom: 10px; /* Ajusta el espaciado inferior del contenedor del mapa según tus necesidades */
}

.map-container > div {
  width: 100%;
  height: 100%;
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
