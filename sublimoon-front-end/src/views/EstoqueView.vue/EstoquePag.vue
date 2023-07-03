<template>
    <div class="container_estoque">
        <router-link type="button" class="btn btn-primary" to="/CadastrarProduto">Cadastrar Produto </router-link>

        <table class="table">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Nome</th>
      <th scope="col">Preço</th>
      <th scope="col">Categoria</th>
      <th scope="col">Opções</th>
    </tr>
  </thead>
  <tbody>
    <tr v-for="item in ProdutosList" :key="item.id">
      <th class="col-md-1">{{ item.id }}</th>
      <td>{{ item.nome }}</td>
      <td>{{ item.preco }}</td>
      <td>{{ item.categoria }}</td>
      <th class="col-md-2">
              <div class="btn-group" role="group" aria-label="Basic mixed styles example">
                <router-link type="button" class="btn btn-sm btn-info" 
                    :to="{ name: 'produto-formulario-editar-view', query: { id: item.id, form: 'editar' } } "> 
                  Editar 
                </router-link>
                <router-link type="button" class="btn btn-sm btn-secondary" 
                    :to="{ name: 'produto-formulario-excluir-view', query: { id: item.id, form: 'deletaProduto' } } ">
                  Excluir
                </router-link>
              </div>
            </th>
    </tr>

  </tbody>
</table>



    </div>

</template>




<script lang="ts">
import { defineComponent } from "vue";

import ProdutoClient from "@/client/produtoclient";
import { Produto } from "@/model/produto";


export default defineComponent({
  name: "ProdutoLista",
  data() {
    return {
      ProdutosList: new Array<Produto>()
      
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
  },
});
</script>




<style lang="scss">
    .container_estoque{
        min-height: 80vh;
        margin-top: 4vh;
    }

</style>