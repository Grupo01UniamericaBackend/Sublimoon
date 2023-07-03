import { AbstractEntity } from "./abstract-entity";

export class Envio extends AbstractEntity{

    formaEnvio!: String;
    
    valorFrete!: Float32Array
}