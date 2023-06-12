<template>
  <div>
    <NavBar />
    <div id="tareasContent">
      <div>
        <h1 class="text-center">Tareas</h1>
        <section>
          <h2 class="text-center">Filtrar tareas por region</h2>
          <div class="d-flex justify-content-center mb-3">
            <select class="form-select" v-model="regionFiltrar">
              <option disabled selected hidden>Seleccione una región</option>
              <option v-for="objeto in regionesChile" :key="objeto">
                {{ objeto }}
              </option>
            </select>
            <button class="btn btn-primary ml-3" @click="cargarTareasFiltradas">
              Filtrar 🔍
            </button>
          </div>
          <MapaHome :puntos="puntos" />
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import axios from 'axios'
import NavBar from '../components/NavBar.vue'
import MapaHome from '~/components/MapaHome.vue'
export default {
  components: { NavBar, MapaHome },
  data() {
    return {
      // Filtrar tareas por region
      regionFiltrar: '',

      tareasFiltradas: null,
      puntos: [],

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
    async cargarTareasFiltradas() {
      if (this.regionFiltrar == undefined) {
        alert('Debe escoger una región')
      }
      try {
        this.puntos = []
        const response = await axios.get(
          `http://localhost:8080/api/tareas/region`,
          {
            params: {
              region: this.regionFiltrar,
            },
          }
        )
        console.log('Tareas filtradas pedidas: ', response)
        this.tareasFiltradas = response.data
        for (let i = 0; i < this.tareasFiltradas.length; i++) {
          const tarea = this.tareasFiltradas[i]
          const punto = {
            latLng: [tarea.latitud, tarea.longitud],
            name: tarea.nombre,
          }
          this.puntos.push(punto)
        }
      } catch (error) {}
    },
  },
}
</script>
<style scoped>
#tareasContent {
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
