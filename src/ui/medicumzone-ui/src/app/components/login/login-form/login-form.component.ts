import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {LoginRequest} from "../../../model/user/user";
import {LoginService} from "../../../services/login/login.service";
import {ExceptionService} from "../../../services/exception/exception.service";

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

  @ViewChild('email',{static:false}) email:ElementRef;
  @ViewChild('password',{static:false}) password:ElementRef;


  constructor(private loginService: LoginService, private exceptionService: ExceptionService) { }

  ngOnInit(): void {
  }

  sendLoginRequest(){
    this.pending = true;
    this.loginService.login(this.getCredentials()).subscribe({
      next: (res) => {
        console.log(res.token);
        this.pending = false
        this.loginError = false;
      },
      error: err => {
       this.errorMessage = this.exceptionService.manageErrorInfo(err);
        this.loginError = true;
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
