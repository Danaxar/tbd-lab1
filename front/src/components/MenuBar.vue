<template>
  <div id="content">
    <div id="profilePhoto">
      <!-- <img
        src="https://p-bio.org/wp-content/uploads/2020/09/profile-picture-template.png"
      /> -->
      <img
        src="https://preview.redd.it/mbud6h6b7od81.png?width=1440&format=png&auto=webp&s=49f9aeea394f3a2b5c1fee6a83a124f80ab9f652"
      />
      <div id="profileData">
        <table>
          <tr>
            <h4>Admin</h4>
          </tr>
          <tr>
            <h6>Admin</h6>
          </tr>
        </table>
      </div>
    </div>
    <table>
      <tr>
        <td>👤</td>
        <td><a href="#/perfil">Perfil </a></td>
      </tr>
      <tr>
        <td>🆘</td>
        <td><a href="#/emergencias">Emergencias </a></td>
      </tr>
      <tr>
        <td>🏛️</td>
        <td><a href="#/instituciones">Instituciones </a></td>
      </tr>
      <tr>
        <td>📚</td>
        <td><a href="#/tareas">Tareas </a></td>
      </tr>
    </table>
    <ul>
      <li></li>
      <li></li>
      <li></li>
      <li></li>
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
  width: 250px;
  height: 100%;
  /* border-width: 1px; */
  padding: 10px;
  background-color: #0a0e18;
  border-radius: 15px 15px 15px 15px;
}

#content table {
  list-style: none;
  font-size: 25px;
  text-align: left;
}

#content table tr td a {
  text-decoration: none;
  color: white;
  transition: 0.4s;
}

#content table tr a:hover {
  color: #db2b39;
  transition: 0.2s;
}

#profilePhoto img {
  width: 100%;
}
</style>
