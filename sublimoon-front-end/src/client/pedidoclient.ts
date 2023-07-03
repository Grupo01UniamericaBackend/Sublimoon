import axios, { AxiosInstance } from 'axios';

import { Pedido } from '@/model/pedido';

    class PedidoClient{


        private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8080/api/pedido',
            headers: {'Content-type' : 'application/json'}
        });
    }

    public async findById(id: number) : Promise<Pedido> {
        try {
            return (await this.axiosClient.get<Pedido>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Pedido[]> {
        try {
            return (await this.axiosClient.get<Pedido[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(pedido: Pedido): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, pedido)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }


    public async deletaPedido(id: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }






    }

    export default new PedidoClient();