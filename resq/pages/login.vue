<template>
  <div>
    <h1 style="text-align: center">Iniciar sesión</h1>
    <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <form>
            <div class="mb-3">
              <label for="rut" class="form-label">Rut:</label>
              <input
                id="rut"
                class="form-control"
                value="12345678-9"
                type="text"
              />
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña:</label>
              <input
                id="password"
                class="form-control"
                value="password"
                type="password"
                name="password"
              />
            </div>
          </form>
          <button class="btn btn-primary" @click="login">Entrar</button>
        </div>
      </div>
    </div>
    <!-- <button @click="obtenerValoresInputs">test</button> -->
  </div>
</template>
<script>
import axios from 'axios'
export default {
  methods: {
    obtenerValoresInputs() {
      var inputs = document.getElementsByTagName('input')
      var valores = {}

      for (var i = 0; i < inputs.length; i++) {
        var input = inputs[i]
        var id = input.getAttribute('id')
        var value = input.value
        valores[id] = value
      }

      return valores
    },

    async login() {
      const form = this.obtenerValoresInputs()
      console.log(form)
      // Ver si el usuario existe en la base de datos
      const response = await axios.get(
        'http://localhost:8080/api/voluntarios/rut/' + form.rut
      )

      const info = response.data
      console.log(info)

      if (form.password === info.contrasena) {
        console.log('Autentificado')
        localStorage.setItem('client', JSON.stringify(info))

        // Redirect
        window.location.href = 'http://localhost:3000/home'
      } else {
        alert('Credenciales erroneas')
      }
    },
  },
}
</script>
