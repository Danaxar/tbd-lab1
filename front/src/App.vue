<template>
  <div id="app">
    <div id="nav">
      <img id="logo" src="./assets/logo.png">
      <span id="namepage">ResQ</span>
    </div>
    <div id="center_home">
      <div id="frase">
        <span>Un click para ayudar 🖱️</span>
        <br>
        <span>Una vida para salvar 💖</span>
        <div>
        <!-- Botones de registro e inicio de sesión -->
        <button id="register">Registrate</button>
        <button id="login">Inicia sesión</button>
      </div>
      </div>
      <div>
        <!-- Aqui va la foto de portada -->
        <img id="home_image" src="./assets/voluntarios.png">
      </div>
      
    </div>
  </div>
</template>

<script>
export default {
  name: 'App',
  components: {
  }
}
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Inter:wght@500&display=swap');

*{
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}

#app{
  color: white;
  background-color: #101728;
  font-family: 'Inter', sans-serif;
  width: 100%;
  height: 100vh;
}

#nav{
  background-color: rgba(0,0,0,0.4);
  display: flex;
  align-items: center;
}

#logo{
  width: 50px;
  margin: 1em;
}

#namepage{
  color: white;
  font-size: xx-large;
  letter-spacing: 1px;
}

#home_image{
  border-radius: 30px 30px;
  width: 500px;
}

#frase{
  font-size: 3vw;
  align-items: center;
  justify-content: center;
  margin: 10%;
}

#center_home{
  display: flex;
  align-items: center;
}

/* Botones */
#register{
  background: linear-gradient(90deg,#ff3131, #ffbd59);
}

#login{
  background: linear-gradient(90deg, #ffde59,#38b6ff);
}

#register, #login{
  width: 10rem;
  height: 4rem;
  color: black;
  border-radius: 30px 30px;
  font-size: 20px;
  font-weight: bold;
  font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
  margin-left: 10%;
  letter-spacing: 1px;
  margin-top: 7em;
  border: none;
}
</style>
