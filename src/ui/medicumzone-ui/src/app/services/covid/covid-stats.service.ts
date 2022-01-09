import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {CovidStats} from "../../model/model";
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CovidStatsService {
  URL = 'http://localhost:8080/covid/stats'
  constructor(private http: HttpClient) { }

  fetchBasicCovidStats() : Observable<CovidStats>{
    return this.http.get<CovidStats>(this.URL);
  }
}
