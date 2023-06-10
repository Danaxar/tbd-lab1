<template>
  <div class="text-center">
    <NavBar />
    <h1>Detalles de {{ emergencia.nombre }}</h1>
    <div class="container">
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
  </div>
</template>

<script>
import axios from 'axios'
import NavBar from '../components/NavBar.vue'
export default {
  components: { NavBar },
  data() {
    return {
      emergencia: null,
      institucion: null,
      registrados: 0,
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
  },
  created() {
    this.emergencia = this.obtenerEmergencia()
    this.obtenerInstitucion()
    this.obtenerRegistrados()
  },
}
</script>
