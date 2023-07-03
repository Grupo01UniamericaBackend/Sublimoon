import { AbstractEntity } from "./abstract-entity";
import { Cliente } from "./cliente";
import { Produto } from "./produto";

export class Avaliacao extends AbstractEntity{
    nota!: Float32Array;
    comentario?: String;

    cliente?: Cliente;
 
    produto?: Produto;
}