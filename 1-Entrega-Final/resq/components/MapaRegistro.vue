<template>
  <div id="map">
    <l-map :zoom="zoom" :center="center" @click="handleMapClick">
      <l-tile-layer :url="url"></l-tile-layer>
      <l-marker v-if="selectedCoordinates" :lat-lng="selectedCoordinates">
      </l-marker>
    </l-map>
  </div>
</template>

<script>
import { LMap, LTileLayer, LMarker } from 'vue2-leaflet'

export default {
  components: {
    LMap,
    LTileLayer,
    LMarker,
  },
  data() {
    return {
      zoom: 5,
      center: [-33.447487, -70.673676],
      url: 'https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png',
      markers: [],
      selectedCoordinates: null,
    }
  },
  methods: {
    handleMapClick(event) {
      this.selectedCoordinates = event.latlng
      this.$emit('coordinatesSelected', this.selectedCoordinates)
    },
  },
}
</script>

<style scoped>
#map {
  width: 600px;
  height: 600px;
}
</style>
