<template>
  <div
    id="index"
    class="d-flex flex-column justify-content-center align-items-center vh-100"
  >
    <h1 class="text-center">ResQ to rescue</h1>
    <div class="mt-4">
      <a href="/login" class="btn btn-primary">Iniciar sesión</a>
      <a href="/register" class="btn btn-success">Registrarte</a>
    </div>
  </div>
</template>

<script>
export default {}
</script>
<style scooped>
#index {
  color: white;
  background: rgb(2, 0, 36);
  background: linear-gradient(
    0deg,
    rgba(2, 0, 36, 1) 0%,
    rgba(8, 7, 104, 1) 5%,
    rgba(9, 9, 121, 1) 10%,
    rgba(9, 9, 121, 1) 17%,
    rgba(8, 26, 132, 1) 24%,
    rgba(0, 212, 255, 1) 100%
  );
}
</style>
