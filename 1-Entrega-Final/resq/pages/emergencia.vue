<template>
  <div>
    <NavBar />
    <h1 style="text-align: center; font-size: 50px">Emergencias</h1>
    <div class="row">
      <div class="col">
        <div class="row">
          <div class="col-md-5">
            <section>
              <h2 class="text-center">Crear una emergencia</h2>
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
                  <tr>
                    <td>Región:</td>
                    <td>
                      <select
                        v-model="region"
                        class="form-select custom-select"
                        id="region"
                      >
                        <option value="" disabled selected hidden>
                          Selecciona una opción
                        </option>
                        <option
                          v-for="(objeto, indice) in regionesChile"
                          :key="indice"
                        >
                          {{ objeto }}
                        </option>
                      </select>
                    </td>
                  </tr>
                </table>
              </div>
              <h2 class="text-center">Gravedad</h2>
              <div class="table-responsive mb-3">
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
              <h2 class="text-center">Habilidades asociadas</h2>
              <table class="mb-3">
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
            </section>
          </div>
          <div class="col-md-2"></div>
          <div class="col-md-5 mb-3" id="mapa">
            <MapaRegistro
            @coordinatesSelected="handleCoordinatesSelected"
            ></MapaRegistro>
          </div>
        </div>
        
      </div>
    </div>
    <div class="row mt-4">
      <div class="col text-center">
        <button class="btn btn-success" @click="enviar">Completar</button>
      </div>
    </div>
  </div>
</template>
<script>
import MapaRegistro from '../components/MapaRegistro.vue'
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
      selectedCoordinates: null,
      region: '',
      regionesChile: [
        'Arica y Parinacota',
        'Tarapacá',
        'Antofagasta',
        'Atacama',
        'Coquimbo',
        'Valparaíso',
        'Metropolitana',
        'O\'Higgins',
        'Maule',
        'Ñuble',
        'Biobío',
        'La Araucanía',
        'Los Ríos',
        'Los Lagos',
        'Aysén',
        'Magallanes'
      ],

      // Datos traidos desde el backend
      habilidades: [],
      instituciones: [], // Lista de instituciones
      gravedades: ['Muy grave', 'Grave', 'Media'],
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
    handleCoordinatesSelected(coordinates) {
      this.selectedCoordinates = coordinates;
      console.log('Coordenadas seleccionadas:', this.selectedCoordinates);
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
      // Verificar que todos los campos estén completos
      if (
        this.nombre == '' ||
        this.fecha == '' ||
        this.institucion == '' ||
        this.gravedad == '' ||
        this.habilidadesSeleccionadas.length == 0 ||
        this.selectedCoordinates == null ||
        this.region == ''
      ) {
        alert('Por favor, complete todos los campos')
        return
      }

      // Crear objeto emergencia
      const emergencia = {
        nombre: this.nombre,
        gravedad: this.gravedad,
        fecha: this.fecha,
        institucion: this.institucion,
        habilidades: this.habilidadesSeleccionadas,
        estado: 'Activa',
        latitud: this.selectedCoordinates.lat,
        longitud: this.selectedCoordinates.lng,
        region: this.region
      }
      // Enviar emergencia
      try {
        const response = await axios.post(
          'http://localhost:8080/api/emergencias',
          emergencia
        )
        console.log(response)
        var idEmergencia = resonse.data.id
      } catch (error) {
        console.log(error)
      }

      // Enviar habilidades
      for (let i = 0; i < this.habilidadesSeleccionadas.length; i++) {
        // Buscar el id de la habilidad seleccionada
        const idHabilidad = this.habilidades.find(
          (e) => e.nombre == this.habilidadesSeleccionadas[i]
        ).idHabilidad
        console.log('idHabilidad: ', idHabilidad)

        // Hacer petición a backend
        const responseHabilidad = await axios.post(
          'http://localhost:8080/api/emergencia-habilidades',
          {
            idHabilidad: idHabilidad,
            idEmergencia: idEmergencia,
          }
        )
        console.log(responseHabilidad)
        alert('Emergencia creada con éxito')
        window.location.reload()
      }
    },
  },
  created() {
    this.cargarInstituciones()
    this.cargarHabilidades()
  },
}
</script>
<style scoped>



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
