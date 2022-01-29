import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {SignUpRequest} from "../../model/user/user";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SignUpService {
  URL = 'http://localhost:8080/api/users/add'
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
      'Access-Control-Allow-Origin': '*'
    })
  };
  constructor(private http: HttpClient) { }

  signUp(signUpRequest: SignUpRequest): Observable<any>{
    let body = JSON.stringify(signUpRequest);
    return this.http.post(this.URL,body,this.httpOptions);
  }
}
