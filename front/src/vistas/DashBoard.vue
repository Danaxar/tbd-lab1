<template>
  <div>
    <h1 style="text-align: left; margin-left: 40px">Dashboard</h1>
    <MenuBar></MenuBar>
  </div>
</template>
<script>
import MenuBar from "@/components/MenuBar.vue";
export default {
  name: "DashBoard",
  components: {
    MenuBar,
  },
  methods: {
    checkLogin() {
      JSON.parse(localStorage.getItem("login")) === true
        ? window.location.replace("http://localhost:8080/#/dashboard")
        : window.location.replace("http://localhost:8080/");
    },
  },
  created() {
    this.checkLogin();
  },
};
</script>
<style scoped></style>
