import { AbstractEntity } from "./abstract-entity";


export class Config extends AbstractEntity{

    alteraNome?: String;
    alteraDescricao?: String;
    alteraPreco?: Float32Array;
    alteraQnt?: Int16Array;
}