import axios, { AxiosInstance } from 'axios';

import { Envio } from '@/model/envio';

    class EnvioClient{


        private axiosClient: AxiosInstance

        constructor() {
            this.axiosClient = axios.create({
                baseURL: 'http://localhost:8081/api/envio',
                headers: {'Content-type' : 'application/json'}
            });
        }
    
        public async findById(id: number) : Promise<Envio> {
            try {
                return (await this.axiosClient.get<Envio>(`/${id}`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }
    
        public async listaAll(): Promise<Envio[]> {
            try {
                return (await this.axiosClient.get<Envio[]>(`/lista`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }
    
        public async cadastrar(envio: Envio): Promise<string> {
            try {
                return (await this.axiosClient.post<string>(``, envio)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }
    
    
        public async deletaEnvio(id: number): Promise<string> {
            try {
                return (await this.axiosClient.delete<string>(`/${id}`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
          }
    




    }

    export default new EnvioClient();