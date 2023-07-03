import axios, { AxiosInstance } from 'axios';

import { Carrinho } from '@/model/carrinho';

    class CarrinhoClient{

        private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8081/api/carrinho',
            headers: {'Content-type' : 'application/json'}
        });
    }


    public async findById(id: number) : Promise<Carrinho> {
        try {
            return (await this.axiosClient.get<Carrinho>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Carrinho[]> {
        try {
            return (await this.axiosClient.get<Carrinho[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(carrinho: Carrinho): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, carrinho)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async editar(id: number,carrinho: Carrinho): Promise<string> {
        try {
            return (await this.axiosClient.put<string>(`/${carrinho.id}`, carrinho)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async deletaCarrinho(id: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }


    }
    
    export default new CarrinhoClient();