<template>
  <div class="container">
    <div id="carousel" class="carousel slide">
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img
            src="../assets/carrosel-Frete-Gratis.png"
            class="d-block w-100"
            alt="..."
          />
        </div>
        <div class="carousel-item">
          <img
            src="../assets/banner-subli-certo.png"
            class="d-block w-100"
            alt="..."
          />
        </div>
      </div>
      <button
        class="carousel-control-prev"
        type="button"
        data-bs-target="#carousel"
        data-bs-slide="prev"
      >
        <span class="carousel-control-prev-icon" aria-hidden="false"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button
        class="carousel-control-next"
        type="button"
        data-bs-target="#carousel"
        data-bs-slide="next"
      >
        <span class="carousel-control-next-icon" aria-hidden="false"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    <div class="destaque">
      <h1 id="h1dest">Nossos destaques:</h1>
    </div>

    <div class="col-md-12 text-start" id="produtooo">
      <div
        v-for="item in ProdutosList"
        :key="item.id"
        class="card"
        style="width: 18rem"
      >
        <img :src="item.imagem" class="card-img-top" alt="..." />
        <div class="card-body">
          <h5 class="card-title">{{ item.nome }}</h5>
          <p class="card-text">R$ {{ item.preco }}</p>
          <router-link
            type="button"
            class="btn btn-sm btn-primary"
            :to="{ name: 'produto', query: { id: item.id } }"
          >
            Visualizar produto
          </router-link>
          <img  class="fav"  @click="Favoritar(item)" v-if="item.ativo == false" src="../assets/contorno-em-forma-de-coracao.png" />
          <img class="fav" @click="Desfavoritar(item)" v-if="item.ativo == true" src="../assets/silhueta-em-forma-de-coracao.png" />
        </div>
      </div>
    </div>
  </div>
</template>

<script lang="ts">
import { defineComponent } from "vue";

import ProdutoClient from "@/client/produtoclient";
import { Produto } from "@/model/produto";
import FavoritoClient from "@/client/favoritoclient";
import { Favorito } from "@/model/favorito";

export default defineComponent({
  name: "ProdutoLista",
  data() {
    return {
      ProdutosList: new Array<Produto>(),
      produto: new Produto(),
      favorito: new Favorito()
    };
  },
  mounted() {
    this.findAll();
  },
  methods: {
    findAll() {
      ProdutoClient.listaAll()
        .then((sucess) => {
          this.ProdutosList = sucess;

          console.log(this.ProdutosList);
        })
        .catch((error) => {
          console.log(error);
        });
    },
    Favoritar(item: Produto) {

this.favorito.produtos = [item]
FavoritoClient.editar(1, this.favorito)
  .then((sucess) => {
    this.favorito = new Favorito();

   console.log(sucess)
  })
  .catch((error) => {
    console.log(error)
  });
},
Desfavoritar(item: Produto) {

FavoritoClient.deletaFavorito(3, item.id)
.then((sucess) => {
    this.favorito = new Favorito();

   console.log(sucess)
  })
  .catch((error) => {
    console.log(error)
  });

},
},
});
</script>

<style lang="scss">
.container {
  //background-color: red;
  min-height: 100vh;
  width: 100%;
}
#carousel {
  width: 100%;
}

.card-text {
  color: black;
}

#produtooo {
  display: flex;
  flex-direction: row;
  flex-wrap: wrap;
  gap: 3vw;
  margin-bottom: 8vh;
}

.fav{
width: 2rem;
}
.destaque{
  height: 10vh;
 // background-color: rgb(234, 123, 234);
  color: #153b75;
  display: flex;
  align-items: center;
  margin-top: 4vh;
  margin-bottom: 2vh;
}
h1{
  font-weight: 800;
  font-family:sans-serif;
}
</style>
