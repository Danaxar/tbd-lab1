<template>
  <div class="text-center">
    <NavBar />
    <h1>Detalles de '{{ emergencia.nombre }}'</h1>
    <div class="container">
      <div>
        <table class="table table-bordered mx-auto">
          <tr>
            <td>Nombre:</td>
            <td>{{ emergencia.nombre }}</td>
          </tr>
          <tr>
            <td>Fecha:</td>
            <td>{{ emergencia.fecha }}</td>
          </tr>
          <tr>
            <td>Gravedad:</td>
            <td>{{ emergencia.gravedad }}</td>
          </tr>
          <tr>
            <td>Institucion:</td>
            <td>{{ institucion }}</td>
          </tr>
          <tr>
            <td>Estado:</td>
            <td>{{ emergencia.estado }}</td>
          </tr>
          <tr>
            <td>Voluntarios registrados:</td>
            <td>{{ registrados }}</td>
          </tr>
        </table>
        <button class="btn btn-success" @click="registrarse">
          Registrarse 🫱🏻‍🫲🏻
        </button>
      </div>

      <div>
        <h1>Voluntarios registrados</h1>
        <table></table>

        <table>
          <tr>
            <td>
              <label for="exampleInputNumber">Número</label>
            </td>
            <td>
              <input
                v-model="numeroVoluntarios"
                type="number"
                class="form-control col-6"
                id="exampleInputNumber"
                value="0"
              />
            </td>
            <td colspan="6">
              <button
                class="btn btn-success"
                @click="cargarVoluntariosProximos"
              >
                Cargar Voluntarios
              </button>
            </td>
          </tr>
          <tr>
            <td>Id</td>
            <td>Rut</td>
            <td>Nombres</td>
            <td>Apellidos</td>
            <td>Fecha Nac</td>
            <td>Disponibilidad</td>
            <td>Telefono</td>
            <td>Region</td>
          </tr>
          <tr v-for="(objeto, indice) in voluntarios">
            <td>{{ objeto.id }}</td>
            <td>{{ objeto.rut }}</td>
            <td>{{ objeto.nombres }}</td>
            <td>{{ objeto.apellidos }}</td>
            <td>{{ objeto.fecha_nac.slice(0, 10) }}</td>
            <td>{{ objeto.disponibilidad }}</td>
            <td>{{ objeto.telefono }}</td>
            <td>{{ objeto.region }}</td>
          </tr>
        </table>
      </div>
    </div>
    <div>
      <h2>Crear una tarea</h2>
      <form>
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <div class="form-group">
                <label for="nombre">Nombre:</label>
                <input
                  type="text"
                  class="form-control"
                  id="nombre"
                  v-model="nombre"
                />
              </div>
            </div>
            <div class="col-md-6">
              <div class="form-group">
                <label for="descripcion">Descripción:</label>
                <input
                  type="text"
                  class="form-control"
                  id="descripcion"
                  v-model="descripcion"
                />
              </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
              <!-- Modificado el ancho de la columna a col-md-12 -->
              <div class="form-group">
                <label for="region">Región:</label>
                <select
                  class="form-control"
                  id="region"
                  v-model="regionRegister"
                >
                  <option disabled selected hidden>
                    Seleccione una región
                  </option>
                  <option v-for="objeto in regionesChile" :key="objeto">
                    {{ objeto }}
                  </option>
                </select>
              </div>
            </div>
          </div>
          <div class="row justify-content-center">
            <div class="col-md-6">
              <div class="form-group">
                <MapaRegistro
                  @coordinatesSelected="handleCoordinatesSelected"
                />
              </div>
            </div>
          </div>
          <!-- <div class="row">
            <div class="col-md-12">
              <button type="submit" class="btn btn-primary">Enviar</button>
            </div>
          </div> -->
        </div>
        <button class="btn btn-success" @click="enviarTarea">
          Enviar Tarea 🎯
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
import NavBar from '../components/NavBar.vue'
export default {
  components: { NavBar },
  data() {
    return {
      // Enviar tarea
      nombre: '',
      descripcion: '',
      regionRegister: '',
      selectedCoordinates: null,
      //

      emergencia: null,
      institucion: null,
      registrados: 0,
      voluntarios: [],
      numeroVoluntarios: 0,

      // Select de regiones
      regionesChile: [
        'Arica y Parinacota',
        'Tarapacá',
        'Antofagasta',
        'Atacama',
        'Coquimbo',
        'Valparaíso',
        'Metropolitana',
        "O'Higgins",
        'Maule',
        'Ñuble',
        'Biobío',
        'La Araucanía',
        'Los Ríos',
        'Los Lagos',
        'Aysén',
        'Magallanes',
      ],
    }
  },
  methods: {
    obtenerEmergencia() {
      return JSON.parse(localStorage.getItem('emergencia'))
    },
    async obtenerInstitucion() {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/instituciones/${this.emergencia.idInstitucion}`
        )
        this.institucion = response.data.nombre
        console.log('Institucion: ', this.institucion)
      } catch (error) {
        console.log(error)
      }
    },
    async obtenerRegistrados() {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/voluntario-emergencias/emergencia/${this.emergencia.idEmergencia}`
        )
        console.log(
          '🚀 ~ file: detallesEmergencia.vue:70 ~ obtenerRegistrados ~ response:',
          response
        )
        this.registrados = response.data
      } catch (error) {}
    },
    async registrarse() {
      // Verificar que no esté registrado
      try {
        const idUsuario = JSON.parse(localStorage.getItem('client')).id
        const respuestaRegistrado = await axios.get(
          `http://localhost:8080/api/voluntario-emergencias/emergencia/${this.emergencia.idEmergencia}/voluntario/${idUsuario}`
        )
        const registrado = respuestaRegistrado.data
        if (registrado) {
          alert('Usted ya se encuentra registrado en la emergencia')
          return
        }
      } catch (error) {
        console.log(error)
      }

      const voluntario_emergencia = {
        idVoluntario: JSON.parse(localStorage.getItem('client')).id,
        idEmergencia: this.emergencia.idEmergencia,
      }
      console.log(
        '🚀 ~ file: detallesEmergencia.vue:69 ~ registrarse ~ voluntario_emergencia:',
        voluntario_emergencia
      )

      // Enviar a backend
      try {
        const response = await axios.post(
          'http://localhost:8080/api/voluntario-emergencias',
          voluntario_emergencia
        )
        console.log(
          '🚀 ~ file: detallesEmergencia.vue:80 ~ registrarse ~ response:',
          response
        )
        // window.location.reload()
      } catch (error) {
        console.log(error)
      }
    },
    async cargarVoluntariosProximos() {
      try {
        const response = await axios.get(
          `http://localhost:8080/api/voluntarios/${this.emergencia.idEmergencia}/${this.numeroVoluntarios}`
        )
        console.log('Numero volunarios: ', response.data)
        this.voluntarios = response.data
      } catch (error) {
        console.log(error)
      }
    },
    handleCoordinatesSelected(coordinates) {
      this.selectedCoordinates = coordinates
      console.log(
        'Coordenadas seleccionadas:',
        this.selectedCoordinates.lng,
        this.selectedCoordinates.lat
      )
    },
    async enviarTarea() {
      try {
        if (this.selectedCoordinates.lng && this.selectedCoordinates.lat) {
        }
      } catch (error) {
        alert('Seleccione un punto en el mapa')
        return
      }

      const tarea = {
        nombre: this.nombre,
        descripcion: this.descripcion,
        region: this.regionRegister,
        longitud: this.selectedCoordinates.lng,
        latitud: this.selectedCoordinates.lat,
        estado: 'Activa',
        idEmergencia: this.emergencia.idEmergencia,
      }

      console.log('Enviando tarea: ', tarea)

      // Enviar al backend
      try {
        const response = await axios.post(
          'http://localhost:8080/api/tareas',
          tarea
        )
        console.log('Tarea enviada: ', response)
      } catch (error) {
        console.log(error)
      }
    },
  },
  created() {
    this.emergencia = this.obtenerEmergencia()
    this.obtenerInstitucion()
    this.obtenerRegistrados()
    this.cargarVoluntariosProximos()
  },
}
</script>

<style scoped>
table {
  margin: auto;
  border-collapse: collapse;
  width: 75%;
  overflow: hidden;
  border-radius: 10px;
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

form .container {
  background-color: rgba(30, 86, 101, 0.5);
  border-radius: 30px 30px;
}

form .container #mapaRegistro {
  margin: auto;
}
</style>
