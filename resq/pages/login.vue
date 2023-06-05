<template>
  <div>
    <h1 style="text-align: center">Iniciar sesión</h1>
    <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <form @submit.prevent="sumbit">
            <div class="mb-3">
              <label for="rut" class="form-label">Rut:</label>
              <input
                v-model="rut"
                id="rut"
                class="form-control"
                type="text"
                placeholder="12345678-9"
              />
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña:</label>
              <input
                v-model="password"
                id="password"
                class="form-control"
                type="password"
                name="password"
                placeholder="Contraseña"
              />
            </div>
            <button class="btn btn-primary" type="submit">Entrar</button>
          </form>
        </div>
      </div>
    </div>
    <!-- <button @click="obtenerValoresInputs">test</button> -->
  </div>
</template>
<script>
import axios from 'axios'
export default {
  data() {
    return {
      rut: '',
      password: '',
    }
  },
  methods: {
    async sumbit() {
      if (this.rut.length < 10) {
        alert('Escriba un rut válido')
        return
      }

      if (!this.password) {
        alert('Escriba su contraseña')
        return
      }

      try {
        const response = await axios.post(
          'http://localhost:8080/api/voluntarios/login',
          {
            rut: this.rut,
            contrasena: this.password,
          },
          {
            headers: {
              'Content-Type': 'application/json',
            },
            credentials: 'include',
          }
        )
        console.log('respuesta: ', response)
        if (response.status === 200) {
          console.log('Sesión iniciada con éxito')
          // Guardar en memoria local la sesión
          localStorage.setItem('client', JSON.stringify(response.data))
          window.location.href = '/home'
        }
      } catch (error) {
        alert('Datos incorrectos')
      }
    },
  },
}
</script>
