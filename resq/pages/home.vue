<template>
  <div>
    <NavBar />
    <div class="container">
      <!-- Contenido de la página principal -->
      <h1>Pagina principal</h1>
      <Mapa></Mapa>
    </div>
  </div>
</template>

<script>
import Mapa from '~/components/Mapa.vue'
import NavBar from '../components/NavBar.vue'
export default {
  components: {
    NavBar,
    Mapa,
  },
}
</script>
