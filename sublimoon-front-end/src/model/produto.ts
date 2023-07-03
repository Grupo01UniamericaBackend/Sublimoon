import { AbstractEntity } from "./abstract-entity";
import { Avaliacao } from "./avaliacao";
import { Carrinho } from "./carrinho";
import { Categoria } from "./categoria";
import { Cor } from "./cor";
import { Favorito } from "./favorito";

export class Produto extends AbstractEntity{

    nome!: String;

    categoria!: Categoria;

    cor!: Cor;
    descricao!: String;
    imagem!: String;
    preco!: Float32Array;
    quantidade!: Int16Array;

    avaliacao?: Avaliacao;

    
    mediaAvaliacao?: Float32Array;

   // favoritos?: Favorito;

    carrinhos?: Carrinho;

    tamanho!: String;

    quantidadeProCarrinho?: Float32Array; //float????
    
}