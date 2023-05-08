<template>
  <div id="loginContent">
    <h1 style="text-align: center">Iniciar sesión</h1>
    <div class="flex">
      <div id="loginForm">
        <table>
          <tr>
            <td><label>Rut:</label></td>
            <td><input value="admin" type="text" /></td>
          </tr>
          <tr>
            <td><label>Contraseña: </label></td>
            <td><input value="admin" type="password" name="password" /></td>
          </tr>
          <tr>
            <button class="btn-completed" @click="login">Entrar</button>
          </tr>
        </table>
      </div>
      <img
        src="https://www.encancha.cl/resizer/NzUMCjlD6iyqLHUM3Vh9i-6d27c=/980x640/smart/cloudfront-us-east-1.images.arcpublishing.com/palco/CMJ6YNIQJJCBXCBL3CLHH2EGYQ.jpg"
      />
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
            console.log(response.data);
            // Guardar en persistencia la sesión activa
            localStorage.setItem("login", true);

            // Guardar datos en persistencia
            localStorage.setItem(
              "client",
              // JSON.stringify({
              //   rut: form.rut_voluntario,
              //   pass: form.contrasena_voluntario,
              // })
              JSON.stringify(response.data)
            );
            this.$router.push("/dashboard"); // Redireccionar
          } else {
            alert("El usuario no se encuentra registrado en la plataforma");
            console.log("El usuario no existe");
          }
        })
        .catch((error) => console.log(error));
    },
    checkLogin() {
      JSON.parse(localStorage.getItem("login")) === true
        ? window.location.replace("http://localhost:8080/#/dashboard")
        : null;
    },
  },
  created() {
    this.checkLogin();
  },
};
</script>

<style scoped>
#loginForm {
  width: 25%;
  /* margin: auto; */
  margin-top: 24px;
  border-color: white;
  border-style: solid;
  border-radius: 15px;
  border-width: 1px;
  padding: 25px;
  background-color: rgba(30, 86, 101, 0.5);
}

#loginForm input {
  margin: 10px;
}

.btn-completed {
  background-color: #4caf50;
  border: none;
  color: white;
  padding: 10px 20px;
  display: inline-block;
  text-align: center;
  font-size: 16px;
  margin: 10px;
  border-radius: 7px;
  cursor: pointer; /* Cambia el cursor cuando se pasa sobre el botón */
}

.btn-completed:hover {
  background-color: #3e8e41;
}

.flex {
  margin-top: 20px;
  display: flex;
  justify-content: space-evenly;
  flex-wrap: nowrap;
}

img {
  border-radius: 15px;
  background-color: black;
  width: 40%;
}
</style>
