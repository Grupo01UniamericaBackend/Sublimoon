import axios, { AxiosInstance } from 'axios';

import { Cliente } from '@/model/cliente';

    class ClienteClient{

        private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8081/api/cliente',
            headers: {'Content-type' : 'application/json'}
        });
    }


    public async findById(id: number) : Promise<Cliente> {
        try {
            return (await this.axiosClient.get<Cliente>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Cliente[]> {
        try {
            return (await this.axiosClient.get<Cliente[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(cliente: Cliente): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, cliente)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async editar(id: number,cliente: Cliente): Promise<string> {
        try {
            return (await this.axiosClient.put<string>(`/${cliente.id}`, cliente)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async deletaCliente(id: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }





    }

    export default new ClienteClient();