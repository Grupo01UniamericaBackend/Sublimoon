<template>

<NavBar/>
<Footer/>

</template>

<script lang="ts">

import NavBar from "../src/components/NavBar.vue" 
import Footer from "../src/components/Footer.vue"
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap'

export default{

components: {

NavBar,
Footer

}

}
</script>

<style lang="scss">

#logo{
  width: 5vw;
  height: auto;
}
#logo:hover{
  transition: 1s;
  scale: 120%;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  //padding: 30px;
  display: flex;
  height: 13vh;
  margin: auto;
  justify-content: space-around;
  align-items: center;


    &.router-link-exact-active {
      color: #5e17eb;
      font-size: 2vw;
      font-weight: 600;
      text-decoration: none;
      font-family: system-ui, 'Segoe UI', Roboto, Oxygen, 'Open Sans', 'Helvetica Neue', sans-serif;
    }
  
}
*{

margin: 0;
padding: 0;
box-sizing: border-box;
}

</style>



