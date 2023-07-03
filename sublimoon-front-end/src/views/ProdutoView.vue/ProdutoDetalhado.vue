<template>
  <div class="mainprod">
    <div class="containerr" >
      <div class="imagemproduto">
        <img
          style="width: 23rem"
          src="https://images.tcdn.com.br/img/img_prod/978182/travesseiro_hotelaria_19_1_deca24665c6d836bf11ae1e704bc6032_20230228103400.jpg"
        />
      </div>

      <div class="tituloprod">
        <h2><strong>    {{ produto.nome }}</strong></h2>

        <h3>R${{ produto.preco }}</h3>

        <div>
          <button type="button" class="btn btn-success">
            Adicionar ao carrinho
          </button>
        </div>
      </div>
    </div>

    <div class="descricaoo">
    <h2>Descrição</h2>
    <h4>{{ produto.descricao }}</h4>
</div>

  </div>
</template>

<script lang="ts">
import ProdutoClient from "@/client/produtoclient";
import { Produto } from "@/model/produto";
import { defineComponent } from "vue";
import { Cor } from "@/model/cor";
import { Categoria } from "@/model/categoria";

export default defineComponent({
  name: "ProdutoFormulario",
  data() {
    return {
      produto: new Produto(),
    };
  },
  computed: {
    id() {
      return this.$route.query.id;
    },
    form() {
      return this.$route.query.form;
    },
  },
  mounted() {
    if (this.id !== undefined) {
      this.findById(Number(this.id));
    }
  },
  methods: {
    findById(id: number) {
      ProdutoClient.findById(id)
      
        .then((sucess) => {
          this.produto = sucess;
        })
        .catch((error) => {
          console.log(error);
        });
    },
  },
});
</script>

<style lang="scss">
.containerr {

  
  width: 120%;
  

  display: flex;
  
  
}

.imagemproduto {
  margin-top: 40px;
  width: 50vw;
  height: 50vh;
 
  display: flex;
  align-items: center;
  justify-content: center;
 
}
.tituloprod {
  
  width: 60vw;
  height: 50vh;
  margin-top: 40px;
  display: flex;
  flex-direction: column;
    justify-content: space-between;
  
}

.tituloprod h2{

font-size: 60px;

}

.mainprod {
 
  min-height: 80vh;
}

.card-text {
  color: black;
}

#produtooo {
  display: flex;
  flex-direction: row;
}
.descricaoo{

min-height: 20vh;
display: flex;
flex-direction: column;
align-items: flex-start;
justify-content: center;


}
</style>
