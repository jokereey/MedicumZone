import { Injectable } from '@angular/core';
import {BehaviorSubject, catchError, Observable, tap, throwError} from "rxjs";
import {LoginRequest, SignUpRequest, User} from "../../model/user/user";
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {Router} from "@angular/router";
import {AuthResponseData} from "../../model/response/AuthResponseData";

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  // @ts-ignore
  user = new BehaviorSubject<User>(null);
  private tokenExpirationTimer: any;
  loginURL = 'http://localhost:8080/api/auth/login'
  signUpURL = 'http://localhost:8080/api/users/add'
  userInfoURL = 'http://localhost:8080/api/auth/userinfo'

  constructor(private http: HttpClient, private router: Router) {}

  signup(request: SignUpRequest) {
    return this.http
      .post(this.signUpURL, request)
      .pipe(
        catchError(this.handleError),
      );
  }
  login(request: LoginRequest) {
    return this.http
      .post<AuthResponseData>(
        this.loginURL,
        request
      )
      .pipe(
        catchError(this.handleError),
        tap(resData => {
          this.handleAuthentication(
            resData.token,
            +resData.expiresIn,
            resData.id,
            resData.name
          );
        })
      );
  }

  autoLogin() {
    const userData: {
      _token: string;
      _expiresIn: string;
      id: string,
      name: string;
    } = JSON.parse(<string>localStorage.getItem('userCredits'));
    if (!userData) {
      console.log('auto login is off.')
      return;
    }
    console.log(userData);
    console.log(userData._token);
    const loadedUser = new User(
      userData._token,
      new Date(userData._expiresIn),
      userData.id,
      userData.name
    );
    console.log(loadedUser);

    if (loadedUser.token) {
      this.user.next(loadedUser);
      const expirationDuration =
        new Date(userData._expiresIn).getTime() -
        new Date().getTime();
      this.autoLogout(expirationDuration);
      console.log('autologin completed ')
    }
  }

  logout() {
    // @ts-ignore
    this.user.next(null);
    this.router.navigate(['/login']);
    console.log('deleting user from local storage');
    localStorage.removeItem('userCredits');
    localStorage.clear();
    if (this.tokenExpirationTimer) {
      clearTimeout(this.tokenExpirationTimer);
    }
    this.tokenExpirationTimer = null;
  }

  autoLogout(expirationDuration: number) {
   console.log('auto-logout is set for',expirationDuration/60000 +'minutes');
    this.tokenExpirationTimer = setTimeout(() => {
      console.log('@@@@@@@@@@@@@@@@@ auto logout')
      this.logout();
    }, expirationDuration);
  }

  private handleAuthentication(
    token: string,
    expiresIn: number,
    id: string,
    name: string,
  ) {
    const expirationDate = new Date(new Date().getTime() + expiresIn * 1000);
    const user = new User(token, expirationDate, id, name);
    this.user.next(user);
    this.autoLogout(expiresIn * 1000);
    console.log(user.expiresIn);
    console.log('setting time: ',new Date(expirationDate));
    localStorage.setItem('userCredits', JSON.stringify(user));
  }

  private handleError(errorRes: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    if (!errorRes.error || !errorRes.error.error) {
      return throwError(errorMessage);
    }
    switch (errorRes.error.error.message) {
      case 'EMAIL_EXISTS':
        errorMessage = 'This email exists already';
        break;
      case 'EMAIL_NOT_FOUND':
        errorMessage = 'This email does not exist.';
        break;
      case 'INVALID_PASSWORD':
        errorMessage = 'This password is not correct.';
        break;
    }
    return throwError(errorMessage);
  }
  userInfo(): Observable<any>{
    return this.http
      .get(this.userInfoURL)
      .pipe(
        catchError(this.handleError),
      );

  }
}
