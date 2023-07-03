import axios, { AxiosInstance } from 'axios';

import { Favorito } from '@/model/favorito';

    class FavoritoClient{

        private axiosClient: AxiosInstance

    constructor() {
        this.axiosClient = axios.create({
            baseURL: 'http://localhost:8081/api/favorito',
            headers: {'Content-type' : 'application/json'}
        });
    }

    public async findById(id: number) : Promise<Favorito> {
        try {
            return (await this.axiosClient.get<Favorito>(`/${id}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async listaAll(): Promise<Favorito[]> {
        try {
            return (await this.axiosClient.get<Favorito[]>(`/lista`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async cadastrar(favorito: Favorito): Promise<string> {
        try {
            return (await this.axiosClient.post<string>(``, favorito)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

    public async editar(id: number,favorito: Favorito): Promise<string> {
        try {
            return (await this.axiosClient.put<string>(`/${id}`, favorito)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
    }

   
    public async deletaFavorito(id: number, idProduto: number): Promise<string> {
        try {
            return (await this.axiosClient.delete<string>(`/delete/${id}/${idProduto}`)).data
        } catch (error:any) {
            return Promise.reject(error.response.data)
        }
      }







    }

    export default new FavoritoClient();