<template>
    <footer>
     <div class="main">
        <div class="redesDiv">
            <a href="https://www.instagram.com/sm.monzon/" target="_blank">
                <img  id="imgInsta" src="../assets/InstaBrancoSemFundo.png" alt="" >
            </a>
            <a href="https://www.facebook.com/sublimonzon" target="_blank">
                <img id="imgFacebook" src="../assets/facebook.png" alt="">
            </a>
        </div>
        <div class="contatoDiv">
                <ul>
                    <li><strong>Contato</strong></li>
                    <li>5545999568491</li>
                    <li>45999568491</li>
                    <li>vendas.sublimoon@gmail.com</li>
                    <li>Av. General Meira, 3120</li>
                </ul>
        </div>
     </div>
    </footer>
</template>

<script lang="ts">
  export default {
    name: "Footer",
  };
  </script>

<style>
    footer{
        height: 20vh;
        background-color: rgb(37, 37, 37);
    }
    p{
        color: white;
    }
    li{
        color: white;
        font-size: 95%;
    }
    li:hover{
        color: rgb(105, 105, 105);
    }
    ul{
       list-style: none;
    }
    #imgInsta{
        height: 60px;
        width: auto;
    }
    #imgFacebook{
        width: auto;
        height: 47px;
    }
    img:hover{
        transition: 0.5s;
        scale: 120%;
    }
    .redesDiv{
     width: 30%;
        display: flex;
        gap: 20%;
        align-items: center;
        padding-left: 08%;
    }
    .contatoDiv{
        width: 70%;
        display: flex;
      flex-direction: row-reverse;
      padding-right: 10%;
      padding-top: 1%;
      align-items: center;
    }
    .main{
        display: flex;
        flex-direction: space-between;
    }
</style>