<template>
  <div>
    <NavBar />
    <h1>Tareas</h1>
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
}
</script>
<style></style>
