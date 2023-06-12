<template>
  <div>
    <NavBar />
    <div class="row">
      <div class="col">
        <h1 class="text-center">Emergencias</h1>
        <!-- Primera fila-->
        <div class="row mb-5">
          <div class="col-md-6">
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
                  <th>Tareas</th>
                  <th>Voluntarios</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(objeto, indice) in emergenciasActivasPaginadas"
                  :key="indice"
                >
                  <td>{{ indice + contadorEmergenciaActivas }}</td>
                  <td>{{ objeto.nombre }}</td>
                  <td>{{ objeto.fecha }}</td>
                  <td>{{ objeto.gravedad }}</td>
                  <td>{{ objeto.estado }}</td>
                  <td>
                    {{ instituciones[objeto.idInstitucion - 1].nombre }}
                  </td>
                  <td>
                    {{
                      tareasEmergenciasActivas[
                        indice + contadorEmergenciaActivas - 1
                      ]
                    }}
                  </td>
                  <td>
                    {{
                      voluntariosEmergenciasActivas[
                        indice + contadorEmergenciaActivas - 1
                      ]
                    }}
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
            <div class="pagination">
              <button
                class="btn btn-primary mr-2"
                @click="paginaAnteriorEmergenciaActiva"
                :disabled="paginasEmergenciasActivas === 0"
              >
                Anterior
              </button>
              <button
                class="btn btn-primary ml-2"
                @click="paginaSiguienteEmergenciaActiva"
                :disabled="
                  (paginasEmergenciasActivas + 1) *
                    numeroEmergenciasPorPagina >=
                  emergenciasActivas.length
                "
              >
                Siguiente
              </button>
            </div>
          </div>
          <!-- <Mapa Emergencias Activas> -->
          <div class="col-md-5">
            <div class="map-container">
              <MapaHome id="mapaActivos" :puntos="markers1" />
            </div>
          </div>
        </div>
        <!-- Fila relleno -->
        <div class="row-mb-2"></div>
        <!-- Segunda fila -->
        <div class="row mb-5">
          <div class="col-md-6">
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
                  <th>Tareas</th>
                  <th>Voluntarios</th>
                  <th></th>
                </tr>
              </thead>
              <tbody>
                <tr
                  v-for="(objeto, indice) in emergenciasFinalizadasPaginadas"
                  :key="indice"
                >
                  <td>{{ indice + contadorEmergenciaFinalizadas }}</td>
                  <td>{{ objeto.nombre }}</td>
                  <td>{{ objeto.fecha }}</td>
                  <td>{{ objeto.gravedad }}</td>
                  <td>{{ objeto.estado }}</td>
                  <td>
                    {{ instituciones[objeto.idInstitucion - 1].nombre }}
                  </td>
                  <td>
                    {{
                      tareasEmergenciasFinalizadas[
                        indice + contadorEmergenciaFinalizadas - 1
                      ]
                    }}
                  </td>
                  <td>
                    {{
                      voluntariosEmergenciasFinalizadas[
                        indice + contadorEmergenciaFinalizadas - 1
                      ]
                    }}
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
            <div class="pagination">
              <button
                class="btn btn-primary mr-2"
                @click="paginaAnteriorEmergenciaFinalizada"
                :disabled="paginasEmergenciasFinalizadas === 0"
              >
                Anterior
              </button>
              <button
                class="btn btn-primary ml-2"
                @click="paginaSiguienteEmergenciaFinalizada"
                :disabled="
                  (paginasEmergenciasFinalizadas + 1) *
                    numeroEmergenciasPorPagina >=
                  emergenciasFinalizadas.length
                "
              >
                Siguiente
              </button>
            </div>
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
      contadorEmergenciaActivas: 1,
      contadorEmergenciaFinalizadas: 1,
      // Paginacion
      paginasEmergenciasActivas: 0,
      paginasEmergenciasFinalizadas: 0,
      numeroEmergenciasPorPagina: 6,
      // Lista de emergencias activas
      emergenciasActivas: [],
      emergenciasFinalizadas: [],
      instituciones: [], // Lista de instituciones
      markers1: [],
      markers2: [],

      // Cantidad de tareas y voluntarios
      tareasEmergenciasActivas: [],
      tareasEmergenciasFinalizadas: [],
      voluntariosEmergenciasActivas: [],
      voluntariosEmergenciasFinalizadas: [],
    }
  },

  computed: {
    emergenciasActivasPaginadas() {
      const inicioIndex =
        this.paginasEmergenciasActivas * this.numeroEmergenciasPorPagina
      const finIndex = inicioIndex + this.numeroEmergenciasPorPagina
      const emergenciaActivasDePagina = this.emergenciasActivas.slice(
        inicioIndex,
        finIndex
      )
      this.contadorEmergenciaActivas = inicioIndex + 1
      return emergenciaActivasDePagina
    },
    emergenciasFinalizadasPaginadas() {
      const inicioIndex =
        this.paginasEmergenciasFinalizadas * this.numeroEmergenciasPorPagina
      const finIndex = inicioIndex + this.numeroEmergenciasPorPagina
      const emergenciaFinalizadasDePagina = this.emergenciasFinalizadas.slice(
        inicioIndex,
        finIndex
      )
      this.contadorEmergenciaFinalizadas = inicioIndex + 1
      return emergenciaFinalizadasDePagina
    },
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
        this.cantidadTareasEmergenciasActivas()
        this.cantidadVoluntariosEmergenciasActivas()
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
        this.cantidadTareasEmergenciasFinalizadas()
        this.cantidadVoluntariosEmergenciasFinalizadas()
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
        console.log('Instituciones cargadas: ', respuesta.data)
      } catch (error) {
        console.log(error)
      }
    },

    async cantidadTareasEmergenciasActivas() {
      try {
        for (let i = 0; i < this.emergenciasActivas.length; i++) {
          var emergencia = this.emergenciasActivas[i]
          var idEmergencia = emergencia.idEmergencia
          const response = await axios.get(
            `http://localhost:8080/api/tareas/emergencia/${idEmergencia}`
          )
          this.tareasEmergenciasActivas.push(response.data.length)
        }
      } catch (error) {
        console.log(error)
      }
    },

    async cantidadVoluntariosEmergenciasActivas() {
      try {
        for (let i = 0; i < this.emergenciasActivas.length; i++) {
          var emergencia = this.emergenciasActivas[i]
          var idEmergencia = emergencia.idEmergencia
          const response = await axios.get(
            `http://localhost:8080/api/voluntarios/emergencia/${idEmergencia}`
          )
          this.voluntariosEmergenciasActivas.push(response.data.length)
        }
      } catch (error) {
        console.log(error)
      }
    },

    async cantidadTareasEmergenciasFinalizadas() {
      try {
        for (let i = 0; i < this.emergenciasFinalizadas.length; i++) {
          var emergencia = this.emergenciasFinalizadas[i]
          var idEmergencia = emergencia.idEmergencia
          const response = await axios.get(
            `http://localhost:8080/api/tareas/emergencia/${idEmergencia}`
          )
          this.tareasEmergenciasFinalizadas.push(response.data.length)
        }
      } catch (error) {
        console.log(error)
      }
    },
    async cantidadVoluntariosEmergenciasFinalizadas() {
      try {
        for (let i = 0; i < this.emergenciasFinalizadas.length; i++) {
          var emergencia = this.emergenciasFinalizadas[i]
          var idEmergencia = emergencia.idEmergencia
          const response = await axios.get(
            `http://localhost:8080/api/voluntarios/emergencia/${idEmergencia}`
          )
          this.voluntariosEmergenciasFinalizadas.push(response.data.length)
        }
      } catch (error) {
        console.log(error)
      }

      try {
        const response = await axios.get(
          `http://localhost:8080/api/voluntarios/emergencia/${idEmergencia}`
        )
        this.voluntarios = response.data
        return this.voluntarios.length
      } catch (error) {
        console.log(error)
      }
    },
    paginaAnteriorEmergenciaActiva() {
      if (this.paginasEmergenciasActivas > 0) {
        this.paginasEmergenciasActivas--
      }
    },
    paginaSiguienteEmergenciaActiva() {
      const paginasTotales = Math.ceil(this.emergenciasActivas.length / 6)
      if (this.paginasEmergenciasActivas < paginasTotales - 1) {
        this.paginasEmergenciasActivas++
      }
    },
    paginaAnteriorEmergenciaFinalizada() {
      if (this.paginasEmergenciasFinalizadas > 0) {
        this.paginasEmergenciasFinalizadas--
      }
    },
    paginaSiguienteEmergenciaFinalizada() {
      const paginasTotales = Math.ceil(this.emergenciasFinalizadas.length / 6)
      if (this.paginasEmergenciasFinalizadas < paginasTotales - 1) {
        this.paginasEmergenciasFinalizadas++
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
  margin-left: 3vw;
  margin-top: 2.5vw;
  height: 25vw; /* Ajusta la altura del contenedor del mapa según tus necesidades */
  width: 34vw;
  margin-bottom: 1px; /* Ajusta el espaciado inferior del contenedor del mapa según tus necesidades */
}
.pagination {
  display: flex;
  justify-content: center;
  align-items: center;
  margin-top: 10px;
}

.map-container > div {
  width: 100%;
  height: 100%;
}

table {
  margin: auto;
  height: 23vw;
  border-collapse: collapse;
  width: 44vw;
  border-radius: 10px;
}

table tbody tr:nth-of-type(even) {
  background-color: #f3f3f3;
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
  background-color: rgba(30, 86, 101, 0.384);
  text-align: center;
}
</style>
