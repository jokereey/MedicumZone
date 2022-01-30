import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {AuthService} from "../../../services/auth/auth.service";
import {AuthResponseData} from "../../../model/response/AuthResponseData";
import {Observable} from "rxjs";

@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  forgetPasswordText ="Zapomniałeś hasła?";
  registerText ="Nie masz konta?";
  preloaderMessage ='Proszę czekać...';
  errorMessage = '';
  loginError =false;
  pending = false;
  redirect = '';
  authObs: Observable<AuthResponseData>;

  @ViewChild('email',{static:false}) email:ElementRef;
  @ViewChild('password',{static:false}) password:ElementRef;


  constructor(private authService: AuthService) { }

  ngOnInit(): void {
  }

  sendLoginRequest(){
    this.loginError= false;
    this.pending = true;
    this.authObs =this.authService.login(this.getCredentials());
    this.authObs.subscribe({
      next: (res) => {
        this.pending = false
        this.loginError = false;
      },
      error: err => {
        this.errorMessage =err;
        this.loginError = true;
        this.pending= false;
      }
    })

  }
  getCredentials(){
    return {
      username: this.email.nativeElement.value,
      password:this.password.nativeElement.value
    }
  }


}
