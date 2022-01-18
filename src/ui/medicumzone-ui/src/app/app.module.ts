import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {HeaderComponent} from './components/header/header.component';
import {CovidStatsComponent} from './components/covid-stats/covid-stats.component';
import {NavigatorComponent} from './components/navigator/navigator.component';
import {AboutUsComponent} from './components/about-us/about-us.component';
import {FooterComponent} from './components/footer/footer.component';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {ToastsContainer} from "./components/shared/toast/toasts-container.component";
import {FormsModule} from "@angular/forms";
import {HttpClient, HttpClientModule, HttpHandler} from "@angular/common/http";
import {PreloaderComponent} from './components/shared/preloader/preloader.component';
import {LoginFormComponent} from './components/login/login-form/login-form.component';
import {RouterModule, Routes} from "@angular/router";
import { HomeComponent } from './components/home/home.component';

const appRoutes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    redirectTo: 'home'
  },
  {
    path: 'login',
    component: LoginFormComponent
  },
  {
    path: 'home',
    component: HomeComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    CovidStatsComponent,
    NavigatorComponent,
    AboutUsComponent,
    FooterComponent,
    ToastsContainer,
    PreloaderComponent,
    LoginFormComponent,
    HomeComponent,

  ],
  imports: [
    BrowserModule,
    NgbModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes)
  ],
  exports:[RouterModule],
  providers: [HttpClient],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {
}
