<template>
  <div id="centerRegisterContainer">
    <h1>Registro</h1>
    <div id="centerRegister">
      <div id="form">
        <label>
          Rut:
          <input value="111" type="text" />
        </label>

        <label>
          Nombres:
          <input value="222" type="text" name="nombres" />
        </label>

        <label>
          Apellidos:
          <input value="333" type="text" name="apellidos" />
        </label>

        <label
          >Fecha de nacimiento:
          <input value="2001-01-25" type="date" name="fecha de nacimiento" />
        </label>

        <label
          >Disponibilidad:
          <input value="555" type="text" name="disponibilidad" />
        </label>

        <label
          >Telefono:
          <input value="666" type="number" name="telefono" />
        </label>

        <label>Contraseña: </label>
        <input value="777" type="password" name="password" />

        <label>Repita su contraseña: </label>
        <input value="888" type="password" name="password2" />
        <br />
        <button id="enviarRegister" @click="enviar">Registrarse</button>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "RegisterForm",
  components: {},
  methods: {
    enviar() {
      const botones = document.getElementsByTagName("input");
      var respuestas = [];
      for (let i = 0; i < botones.length; i++) {
        respuestas.push(botones[i].value);
      }
      const form = {
        rut_voluntario: respuestas[0],
        nombres_voluntario: respuestas[1],
        apellidos_voluntario: respuestas[2],
        fecha_nac_voluntario: respuestas[3],
        disponibilidad_voluntario: respuestas[4],
        telefono_voluntario: respuestas[5],
        contrasena_voluntario: respuestas[6],
      };
      console.log(form);
      // Y enviar el contenido por axios
      axios
        .post("http://localhost:8081/voluntario", JSON.stringify(form), {
          headers: {
            "Content-Type": "application/json",
          },
        })
        .then((response) => {
          console.log(response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
};
</script>

<style>
#centerRegisterContainer h1 {
  text-align: center;
  margin: 2%;
}

#centerRegister {
  margin-left: auto;
  margin-right: auto;
  width: 60rem;
  display: flex;
  align-items: center;
  justify-content: center;
  border-style: solid;
  border-radius: 30px 30px;
  border-width: 1px;
  border-color: aliceblue;
}

#form {
  width: 65rem;
  display: flex;
  flex-direction: column;
  border-radius: 1px;
  padding: 5%;
  font-size: 25px;
}

/* Redondear inputs y botón de enviar */
#enviarRegister,
input {
  border-radius: 30px 30px;
}

#enviarRegister {
  height: 25px;
  width: 25%;
  font-size: 0.7em;
  background-color: green;
  color: white;
  border: none;
  transition: 0.1s;
  margin-left: auto;
  margin-right: auto;
}

#enviarRegister:hover {
  transform: scale(110%);
  transition: 0.3s;
}

input {
  height: 2em;
  width: 50%;
}
</style>
