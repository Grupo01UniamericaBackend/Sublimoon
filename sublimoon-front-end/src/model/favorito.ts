import { AbstractEntity } from "./abstract-entity";
import { Cliente } from "./cliente";
import { Produto } from "./produto";

export class Favorito extends AbstractEntity{
    
    //produtoId?: number;

    produtos?: Array<Produto>;

    cliente?: Cliente;

}