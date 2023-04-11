<template>
  <div>
    <h1 style="text-align: center">Emergencias</h1>
    <div class="contenedor">
      <MenuBar></MenuBar>
      <div id="contenido">
        <section>
          <h2>Crear una emergencia</h2>
          <div id="formEmergencia">
            <label
              >Nombre:
              <input type="text" value="emergencia1" />
            </label>
            <div id="gravedad">
              <h3 style="margin-top: 20px">Gravedad</h3>
              <label>
                Muy grave
                <input type="radio" name="gravedad" value="Muy grave" />
              </label>
              <label>
                Grave
                <input type="radio" name="gravedad" value="Grave" />
              </label>
              <label>
                Media
                <input type="radio" name="gravedad" value="Media" />
              </label>
            </div>
            <label>
              Fecha:
              <input type="date" />
            </label>
          </div>
          <button @click="enviarEmergencia">Crear emergencia</button>
        </section>

        <section>
          <h2>Emergencias activas</h2>
        </section>
      </div>
    </div>
  </div>
</template>
<script>
import MenuBar from "@/components/MenuBar.vue";
import axios from "axios";
export default {
  name: "EmergenciasView",
  components: { MenuBar },
  methods: {
    enviarEmergencia() {
      const inputs = document.getElementsByTagName("input"); // Botones del DOM

      // Sintetizar valores en un objecto
      const respuestas = {
        nombre_emergencia: inputs[0].value,
        gravedad_emergencia: Array.from(inputs).find(
          (elemento) => elemento.checked === true
        ).value,
        fecha_emergencia: inputs[4].value,
      };
      console.log("respuestas: ", respuestas);

      // Enviar a backend
      axios.post(
        "http://localhost:8081/emergencia",
        JSON.stringify(respuestas),
        {
          headers: {
            "Content-Type": "application/json",
          },
        }
      );
    },
  },
};
</script>
<style scoped>
.contenedor {
  display: flex;
}

#contenido {
  width: 100%;
  display: flex;
}

#contenido section {
  width: 50%;
  border-style: solid;
  padding: 30px;
}

#contenido section h2 {
  text-align: center;
}

#gravedad {
  display: flex;
  flex-direction: column;
}

button {
  background-color: rgb(40, 218, 40);
}
</style>
