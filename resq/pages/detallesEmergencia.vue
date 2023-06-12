<template>
  <div class="text-center">
    <NavBar />
    <h1>Detalles de {{ emergencia.nombre }}</h1>
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
            <td>
              <button
                class="btn btn-success"
                @click="cargarVoluntariosProximos"
              >
                Cargar Voluntarios
              </button>
            </td>
          </tr>
        </table>

        <table>
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
      <form @sumbit.prevent="sumbitForm">
        <table>
          <tr>
            <td>Nombre:</td>
            <td><input type="text" v-model="nombre" /></td>
          </tr>
          <tr>
            <td>Descripción:</td>
            <td><input type="text" v-model="descripcion" /></td>
          </tr>
          <tr>
            <td>Region:</td>
            <td>
              <select v-model="regionRegister">
                <option disabled selected hidden>Seleccione una región</option>
                <option v-for="objeto in regionesChile">
                  {{ objeto }}
                </option>
              </select>
            </td>
          </tr>
          <tr>
            <MapaRegistro @coordinatesSelected="handleCoordinatesSelected" />
          </tr>
          <tr></tr>
        </table>
      </form>
      <button class="btn btn-success" @click="enviarTarea">
        Enviar Tarea 🎯
      </button>
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
