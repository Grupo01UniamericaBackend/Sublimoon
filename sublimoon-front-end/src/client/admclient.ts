import axios, { AxiosInstance } from 'axios';
import { Adm } from '@/model/adm';

    class AdmClient{

        private axiosClient: AxiosInstance

        constructor() {
            this.axiosClient = axios.create({
                baseURL: 'http://localhost:8081/api/adm',
                headers: {'Content-type' : 'application/json'}
            });
        }

        public async findById(id: number) : Promise<Adm> {
            try {
                return (await this.axiosClient.get<Adm>(`/${id}`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }

        public async listaAll(): Promise<Adm[]> {
            try {
                return (await this.axiosClient.get<Adm[]>(`/lista`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }

        public async cadastrar(adm: Adm): Promise<string> {
            try {
                return (await this.axiosClient.post<string>(``, adm)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }
    
        public async editar(id: number,adm: Adm): Promise<string> {
            try {
                return (await this.axiosClient.put<string>(`/${adm.id}`, adm)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
        }

        public async deletaAdm(id: number): Promise<string> {
            try {
                return (await this.axiosClient.delete<string>(`/${id}`)).data
            } catch (error:any) {
                return Promise.reject(error.response.data)
            }
          }


    }

    export default new AdmClient();