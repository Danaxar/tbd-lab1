<template>
  <div class="container">
    <h1 class="mt-4" style="text-align: center">Registro</h1>
    <div class="row">
      <div class="col">
        <form>
          <div class="row">
            <div class="col-md-5">
              <!-- Campos de entrada -->
              <div class="mb-2">
                <label for="rut" class="form-label">Rut:</label>
                <input
                  v-model="rut"
                  id="rut"
                  class="form-control"
                  value="12345678-9"
                  type="text"
                />
              </div>
              <div class="mb-2">
                <label for="nombres" class="form-label">Nombres:</label>
                <input
                  v-model="nombres"
                  id="nombres"
                  class="form-control"
                  value="Juan"
                  type="text"
                />
              </div>
              <div class="mb-2">
                <label for="apellidos" class="form-label">Apellidos:</label>
                <input
                  v-model="apellidos"
                  id="apellidos"
                  class="form-control"
                  value="Perez"
                  type="text"
                />
              </div>
              <div class="mb-3">
                <label for="fechaNacimiento" class="form-label">Fecha de nacimiento:</label>
                <input
                  v-model="fechaNacimiento"
                  id="fecha_nac"
                  class="form-control"
                  value="2000-01-25"
                  type="date"
                  
                />
              </div>
              <div class="mb-3">
                <label for="disponibilidad" class="form-label">Disponibilidad:</label
                >
                <input
                  v-model="disponibilidad"
                  id="disponibilidad"
                  class="form-control"
                  value="Todos los días"
                  type="text"
                />
              </div>
              <div class="mb-2">
                <label for="telefono" class="form-label">Teléfono: +569</label>
                <input
                  v-model="telefono"
                  id="telefono"
                  class="form-control"
                  value="12345678"
                  type="text"
                />
              </div>
              <div class="mb-2">
                <label for="region" class="form-label">Región:</label>
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
                    {{ objeto}}
                  </option>
                </select>
              </div> 
              <div class="mb-2">
                <label for="password" class="form-label">Contraseña:</label>
                <input
                  v-model="contrasena"
                  id="contrasena"
                  class="form-control"
                  value="password"
                  type="password"
                />
              </div>
              <div class="mb-2">
                <label for="password2" class="form-label">Repita su contraseña:</label>
                <input
                  v-model="contrasena2"
                  id="password2"
                  class="form-control"
                  value="password"
                  type="password"
                />
              </div>
              <!-- Roles -->
              <div class="form-check">
                <input
                  class="form-check-input"
                  v-model="rol"
                  type="radio"
                  id="voluntario"
                  value="voluntario"
                />
                <label class="form-check-label" for="voluntario">Voluntario</label>
              </div>
              <div class="form-check">
                <input
                  v-model="rol"
                  class="form-check-input"
                  type="radio"
                  id="coordinador"
                  value="coordinador"
                />
                <label class="form-check-label" for="coordinador"
                  >Coordinador</label
                >
              </div>
            </div>
            <!-- div relleno -->
            <div class="col-md-2"></div>
            <div class="col-md-5 mb-3">
              <!-- Mapa -->
              <label for="Mapa" class="form-label">Ubicación:</label>
              <MapaRegistro @coordinatesSelected="handleCoordinatesSelected" />
              <div v-if="selectedCoordinates">
                <h2>Coordenadas seleccionadas:</h2>
                <p>Latitud: {{ selectedCoordinates.lat }}</p>
                <p>Longitud: {{ selectedCoordinates.lng }}</p>
              </div>
            </div>
          </div>
        </form>
      </div>
    </div>
    <div class="row mt-4">
      <div class="col text-center">
        <button id="enviarRegister" class="btn btn-primary" @click="enviarRegistro">
          Registrarse
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import MapaRegistro from '@/components/MapaRegistro.vue'
import axios from 'axios'
export default {
  components: {
    Map,
  },
  data() {
    return {
      rut: '',
      nombres: '',
      apellidos: '',
      fechaNacimiento: '',
      disponibilidad: '',
      telefono: '',
      region: '',
      contrasena: '',
      contrasena2: '',
      rol: '',
      selectedCoordinates: null,
      regionesChile: [
        'Arica y Parinacota',
        'Tarapacá',
        'Antofagasta',
        'Atacama',
        'Coquimbo',
        'Valparaíso',
        'Metropolitana de Santiago',
        'Libertador General Bernardo O\'Higgins',
        'Maule',
        'Ñuble',
        'Biobío',
        'La Araucanía',
        'Los Ríos',
        'Los Lagos',
        'Aysén del General Carlos Ibáñez del Campo',
        'Magallanes y de la Antártica Chilena'
      ],
    }
  },
  methods: {
    obtenerValoresInputs() {
      var inputs = document.getElementsByTagName('input')
      var valores = {}
      var roles = document.querySelectorAll('input[type="radio"]:checked')
      if (roles.length == 0) {
        alert('Debe escoger un rol')
        return -1
      }
      var rol = roles[0].value

      for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i]
        var id = input.getAttribute('id')
        var value = input.value
        valores[id] = value
      }
      
      valores.rol = rol
      console.log(valores)
      
      return valores
    },
    
    handleCoordinatesSelected(coordinates) {
      this.selectedCoordinates = coordinates;
      console.log('Coordenadas seleccionadas:', this.selectedCoordinates);
    },

    async register() {
      // Recuperar valores de inputs
      const form = this.obtenerValoresInputs()

      if (form == -1) {
        return
      }
      console.log(form)

      // Enviar al backend
      const response = await axios.post(
        'http://localhost:8080/api/voluntarios',
        form
      )

      if (response.status == 201) {
        alert('Registrado con exito')
        window.location.href = '/'
      }
      console.log(response)
    },

    async enviarRegistro() {
      // Obtener los valores del input
      if (this.contrasena != this.contrasena2) {
        alert('Las contraseñas no coinciden')
        return -1
      }else if (this.rol == '') {
        alert('Debe escoger un rol')
        return -1
      }else if (this.region == '') {
        alert('Debe escoger una región')
        return -1
      }else if (this.selectedCoordinates == null) {
        alert('Debe escoger una ubicación')
        return -1
      }
      const voluntario = {
        rut: this.rut,
        nombres: this.nombres,
        apellidos: this.apellidos,
        fecha_nac: this.fechaNacimiento,
        disponibilidad: this.disponibilidad,
        telefono: this.telefono,
        region: this.region,
        contrasena: this.contrasena,
        rol: this.rol,
        latitud: this.selectedCoordinates.lat,
        longitud: this.selectedCoordinates.lng,
      }
      console.log(voluntario)
      // Enviar al backend
      try {
        const response = await axios.post(
          'http://localhost:8080/api/voluntarios',
          voluntario
        )
        alert('Registrado con exito')
        window.location.href = '/'
        
      } catch (error) {
        alert('Error al registrar')
        console.log(error)
      }

      
    },
  },
}
</script>

<style scoped>
</style>