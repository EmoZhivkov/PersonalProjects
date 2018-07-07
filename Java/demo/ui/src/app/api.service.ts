import { Injectable } from '@angular/core';
import { HttpClient} from  '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor( private httpClient: HttpClient) {}

  postEcho(input: string) {
    return this.httpClient.post('http://localhost:8080/api/echo', input);
  }

  getHealth(){
    return  this.httpClient.get(`http://localhost:8080/api/health`);
  }
}
