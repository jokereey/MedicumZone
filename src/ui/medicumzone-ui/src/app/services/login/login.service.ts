import { Injectable } from '@angular/core';
import {LoginRequest} from "../../model/user/user";
import {HttpClient, HttpClientModule, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {catchError, Observable, pipe, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  URL = 'http://localhost:8080/api/auth/login'

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json'
    })
  };

  constructor(private http: HttpClient) { }

  login(loginRequest:LoginRequest ): Observable<any>{
    console.log('login method triggered');
    let body = JSON.stringify(loginRequest);
    return this.http.post<LoginRequest>(this.URL,body,this.httpOptions);
  }

}
