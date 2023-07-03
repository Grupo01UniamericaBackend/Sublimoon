import { AbstractEntity } from "./abstract-entity";
import { Cliente } from "./cliente";
import { Produto } from "./produto";

export class Carrinho extends AbstractEntity{

    produtos?: Produto;

   // produtoId?: number;
    quantidade?: Int16Array;
    desconto?: Float32Array;
    subTotal?:Float32Array;
    cliente?: Cliente;
    
}