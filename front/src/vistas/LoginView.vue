<template>
  <div id="loginContent">
    <h1 style="text-align: center">Iniciar sesión</h1>
    <div id="loginForm">
      <label>
        Rut:
        <input value="20675871-6" type="text" />
      </label>
      <br />
      <label
        >Contraseña: <input value="rucio025" type="password" name="password"
      /></label>
      <br />
      <button id="loginButton" @click="login">Entrar</button>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "LoginView",
  components: {},
  methods: {
    login() {
      // Obtener los valores de los inputs del dom y guardarlos en un objeto
      const botones = document.getElementsByTagName("input");
      var respuestas = [];
      for (let i = 0; i < botones.length; i++) {
        respuestas.push(botones[i].value);
      }
      const form = {
        rut_voluntario: respuestas[0],
        contrasena_voluntario: respuestas[1],
      };

      // Enviar los datos al backend
      axios
        .get(
          `http://localhost:8081/voluntario/${form.rut_voluntario}/${form.contrasena_voluntario}`,
          JSON.stringify(form),
          {
            headers: {
              "Content-Type": "application/json",
            },
          }
        )
        .then((response) => {
          if (response.data) {
            console.log("El usuario existe");
            // Guardar en persistencia la sesión activa
            localStorage.setItem("login", true);
            localStorage.setItem(
              "client",
              JSON.stringify({
                rut: form.rut_voluntario,
                pass: form.contrasena_voluntario,
              })
            );
            this.$router.push("/dashboard"); // Redireccionar
          } else {
            alert("El usuario no se encuentra registrado en la plataforma");
            console.log("El usuario no existe");
          }
        })
        .catch((error) => console.log(error));
    },
  },
};
</script>

<style>
#loginContent {
  height: 50vh;
}
#loginForm {
  width: 50vw;
  margin: auto;
  margin-top: 24px;
  border-color: white;
  border-style: solid;
  border-radius: 30px 30px;
  padding: 25px;
}

#loginButton {
  margin: 25px;
  background-color: green;
  border-radius: 30px 30px;
  font-size: 20px;
  color: white;
  width: 15%;
}

#loginForm input {
  margin: 10px;
}
</style>
