<template>
  <div id="content">
    <ul>
      <li><a href="#/perfil">Perfil 👤</a></li>
      <li><a href="#/emergencias">Emergencias 🆘</a></li>
      <li><a href="#/instituciones">Instituciones 🏛️</a></li>
      <li><a href="#/tareas">Tareas 📚</a></li>
    </ul>
  </div>
</template>
<script>
export default {
  name: "MenuBar",
};
</script>
<style scoped>
#content {
  border-style: solid;
  width: 250px;
  height: 80vh;
  border-width: 1px;
  padding: 10px;
}

#content ul {
  list-style: none;
  font-size: 25px;
  text-align: left;
}

#content ul li a {
  text-decoration: none;
  color: white;
  transition: 0.4s;
}

#content ul li a:hover {
  color: #db2b39;
  transition: 0.2s;
}
</style>
