<template>
  <div id="app">
    <div id="center_home">
      <div id="frase">
        <span>Un click para ayudar 🖱️</span>
        <br />
        <span>Una vida para salvar 💖</span>
        <div>
          <!-- Botones de registro e inicio de sesión -->
          <a href="#/register"><button id="register">Registrate</button></a>
          <a href="#/login"><button id="login">Inicia sesión</button></a>
        </div>
      </div>
      <div>
        <!-- Aqui va la foto de portada -->
        <img id="home_image" src="../assets/voluntarios.png" />
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "HomePage",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap");

* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#app {
  color: white;
  background-color: #101728;
  font-family: "Inter", sans-serif;
  width: 100%;
  height: 100vh;
}

#home_image {
  border-radius: 30px 30px;
  width: 500px;
}

#frase {
  font-size: 3vw;
  align-items: center;
  justify-content: center;
  margin: 10%;
}

#center_home {
  display: flex;
  align-items: center;
}

/* Botones */
#register {
  background: linear-gradient(90deg, #ff3131, #ffbd59);
}

#login {
  background: linear-gradient(90deg, #ffde59, #38b6ff);
}

#register,
#login {
  width: 10rem;
  height: 4rem;
  color: black;
  border-radius: 30px 30px;
  font-size: 20px;
  font-weight: bold;
  font-family: "Gill Sans", "Gill Sans MT", Calibri, "Trebuchet MS", sans-serif;
  margin-left: 10%;
  letter-spacing: 1px;
  margin-top: 7em;
  border: none;
  transition: 0.1s;
}

#register:hover,
#login:hover {
  transform: scale(110%);
  transition: 0.3s;
}
</style>
