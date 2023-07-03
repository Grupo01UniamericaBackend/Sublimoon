import { AbstractEntity } from "./abstract-entity";
import { Carrinho } from "./carrinho";
import { Envio } from "./envio";

export class Pedido extends AbstractEntity{

    total!: Float32Array;
    pagamento!: String;
    endereco!: String;
    cep!: String;

    carrinho?: Carrinho;

    envio?: Envio;

    
}