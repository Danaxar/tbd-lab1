<template>
  <div class="container">
    <h1 class="mt-4" style="text-align: center">Registro</h1>
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
            <label for="nombres" class="form-label">Nombres:</label>
            <input
              id="nombres"
              class="form-control"
              value="Juan"
              type="text"
              name="nombres"
            />
          </div>
          <div class="mb-3">
            <label for="apellidos" class="form-label">Apellidos:</label>
            <input
              id="apellidos"
              class="form-control"
              value="Perez"
              type="text"
              name="apellidos"
            />
          </div>
          <div class="mb-3">
            <label for="fechaNacimiento" class="form-label"
              >Fecha de nacimiento:</label
            >
            <input
              id="fecha_nac"
              class="form-control"
              value="2000-01-25"
              type="date"
              name="fecha_de_nacimiento"
            />
          </div>
          <div class="mb-3">
            <label for="disponibilidad" class="form-label"
              >Disponibilidad:</label
            >
            <input
              id="disponibilidad"
              class="form-control"
              value="Todos los días"
              type="text"
              name="disponibilidad"
            />
          </div>
          <div class="mb-3">
            <label for="telefono" class="form-label">Teléfono: +569</label>
            <input
              id="telefono"
              class="form-control"
              value="12345678"
              type="number"
              name="telefono"
            />
          </div>
          <div class="mb-3">
            <label for="password" class="form-label">Contraseña:</label>
            <input
              id="contrasena"
              class="form-control"
              value="password"
              type="password"
              name="password"
            />
          </div>
          <div class="mb-3">
            <label for="password2" class="form-label"
              >Repita su contraseña:</label
            >
            <input
              id="password2"
              class="form-control"
              value="password"
              type="password"
              name="password2"
            />
          </div>
          <div class="form-check">
            <input
              class="form-check-input"
              type="radio"
              id="voluntario"
              name="rol"
              value="voluntario"
            />
            <label class="form-check-label" for="voluntario">Voluntario</label>
          </div>

          <div class="form-check">
            <input
              class="form-check-input"
              type="radio"
              id="coordinador"
              name="rol"
              value="coordinador"
            />
            <label class="form-check-label" for="coordinador"
              >Coordinador</label
            >
          </div>
        </form>
        <div class="mb-3">
          <button id="enviarRegister" class="btn btn-primary" @click="register">
            Registrarse
          </button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  methods: {
    obtenerValoresInputs() {
      var inputs = document.getElementsByTagName('input')
      var valores = {}
      var rol = document.querySelectorAll('input[type="radio"]:checked')[0]
        .value

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
    async register() {
      // Recuperar valores de inputs
      const form = this.obtenerValoresInputs()
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
  },
}
</script>
