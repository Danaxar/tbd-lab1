<template>
  <div>
    <h1 style="text-align: center">Iniciar sesión</h1>
    <div class="container">
      <div class="row">
        <div class="col-md-6 offset-md-3">
          <form>
            <div class="mb-3">
              <label for="rut" class="form-label">Rut:</label>
              <input id="rut" class="form-control" value="admin" type="text" />
            </div>
            <div class="mb-3">
              <label for="password" class="form-label">Contraseña:</label>
              <input
                id="password"
                class="form-control"
                value="admin"
                type="password"
                name="password"
              />
            </div>
            <button class="btn btn-primary" @click="login">Entrar</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>
<script></script>
<style></style>
