<template>
  <div id="nav">
    <a id="logoLink" href="/">
      <img id="logo" src="../assets/logo.png" />
      <span id="namepage">esQ</span>
    </a>

    <!-- <button @click="test">test</button> -->
  </div>
</template>

<script>
export default {
  data() {
    return {
      titulo: "NavBar",
    };
  },
};
</script>

<style scoped>
#nav {
  background-color: rgba(0, 0, 0, 0.4);
  display: flex;
  justify-content: center;
}

#logo {
  width: 50px;
  margin-top: 1em;
  margin-left: 1em;
  margin-bottom: 2em;
}

#namepage {
  color: white;
  font-size: 30px;
  letter-spacing: 1px;
}

#logoLink {
  text-decoration: none;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
