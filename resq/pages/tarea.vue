<template>
  <div>
    <NavBar />
    <h1>Tareas</h1>
    <section>
      <h2>Crear una tarea</h2>
      <form>
        <table>
          <tr>
            <td>Nombre:</td>
            <td><input type="text" /></td>
          </tr>
          <tr>
            <td>Descripción:</td>
            <td><input type="text" /></td>
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
          <tr>
            <button class="btn btn-success" @click="enviarTarea">
              Enviar Tarea 🎯
            </button>
          </tr>
        </table>
      </form>
    </section>
    <section>
      <h2>Filtrar tareas por region</h2>
      <select v-model="regionFiltrar">
        <option disabled selected hidden>Seleccione una región</option>
        <option v-for="objeto in regionesChile">
          {{ objeto }}
        </option>
      </select>
    </section>
  </div>
</template>
<script>
import axios from 'axios'
import NavBar from '../components/NavBar.vue'
import MapaRegistro from '~/components/MapaRegistro.vue'
export default {
  components: { NavBar, MapaRegistro, MapaRegistro },
  data() {
    return {
      // Enviar tarea
      nombre: '',
      descripcion: '',
      regionRegister: '',
      selectedCoordinates: null,

      // Filtrar tareas por region
      regionFiltrar: '',

      // Select de regiones
      regionesChile: [
        'Arica y Parinacota',
        'Tarapacá',
        'Antofagasta',
        'Atacama',
        'Coquimbo',
        'Valparaíso',
        'Metropolitana de Santiago',
        "Libertador General Bernardo O'Higgins",
        'Maule',
        'Ñuble',
        'Biobío',
        'La Araucanía',
        'Los Ríos',
        'Los Lagos',
        'Aysén del General Carlos Ibáñez del Campo',
        'Magallanes y de la Antártica Chilena',
      ],
    }
  },
  methods: {
    handleCoordinatesSelected(coordinates) {
      this.selectedCoordinates = coordinates
      console.log(
        'Coordenadas seleccionadas:',
        this.selectedCoordinates.lng,
        this.selectedCoordinates.lat
      )
    },
    async enviarTarea() {
      const tarea = {
        nombre: this.nombre,
        descripcion: this.descripcion,
        region: this.regionRegister,
        longitud: this.selectedCoordinates.lng,
        latitud: this.selectedCoordinates.lat,
        estado: 'Activa',
      }

      // Enviar al backend
      try {
        const response = await axios.post(
          'http://localhost:8080/api/tareas',
          tarea
        )
        console.log('Enviando tarea: ', response)
      } catch (error) {}
    },
  },
}
</script>
<style></style>
