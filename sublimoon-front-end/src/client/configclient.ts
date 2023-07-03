import axios, { AxiosInstance } from 'axios';
import { Config } from '@/model/configuracao';

class ConfigClient{

    private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8081/api/configuracao',
            headers: {'Content-type' : 'application/json'}
        });
    }

    public async findById(id: number) : Promise<Config> {
        try {
            return (await this.axiosClient.get<Config>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Config[]> {
        try {
            return (await this.axiosClient.get<Config[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(configuracao: Config): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, configuracao)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async editar(id: number,configuracao: Config): Promise<string> {
        try {
            return (await this.axiosClient.put<string>(`/${configuracao.id}`, configuracao)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async deletaConfig(id: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }


}

export default new ConfigClient();