<template>
  <div id="app">
    <NavBar></NavBar>
    <router-view></router-view>
  </div>
</template>

<script>
import NavBar from './components/NavBar.vue'

export default {
  name: 'App',
  components: { 
    NavBar
  }
}
</script>

<style>
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
</style>
