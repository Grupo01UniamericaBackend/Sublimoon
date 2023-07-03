import axios, { AxiosInstance } from 'axios';

import { Avaliacao } from '@/model/avaliacao';

    class AvaliacaoClient{

        private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8081/api/avaliacao',
            headers: {'Content-type' : 'application/json'}
        });
    }

    public async findById(id: number) : Promise<Avaliacao> {
        try {
            return (await this.axiosClient.get<Avaliacao>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Avaliacao[]> {
        try {
            return (await this.axiosClient.get<Avaliacao[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(avaliacao: Avaliacao): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, avaliacao)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async editar(id: number,avaliacao: Avaliacao): Promise<string> {
        try {
            return (await this.axiosClient.put<string>(`/${avaliacao.id}`, avaliacao)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async deletaAvaliacao(id: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }

    }

    
    export default new AvaliacaoClient();