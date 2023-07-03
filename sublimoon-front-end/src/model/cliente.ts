import { AbstractEntity } from "./abstract-entity";
import { Avaliacao } from "./avaliacao";
import { Carrinho } from "./carrinho";
import { Favorito } from "./favorito";

export class Cliente extends AbstractEntity{

    telefone!: String;
    email!: String;

   // favorito?: Favorito;

    //carrinho?: Carrinho;

    nome!: String;
    senha!: String;
    cpf!: String;
    alterarNome?: String;
    alterarDescricao?: String;
    alterarPreco?: String;
    alterarQnt?: String

    avaliacoes?: Avaliacao;
}