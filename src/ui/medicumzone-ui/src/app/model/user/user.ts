export class  User{
   constructor(private _token: string,
               private _expiresIn:Date,
               public id: string,
               public name: string) {
   }
  get token() {
    if (!this._expiresIn || new Date() > this._expiresIn) {
      return null;
    }
    return this._token;
  }
  get expiresIn(){
     return this._expiresIn;
  }
}

export interface LoginRequest{
  username: string;
  password: string;
}
export interface SignUpRequest{
  name: string;
  surname: string;
  PESEL: string,
  dob: Date,
  phoneNumber: string,
  email: string,
  password: string,
  newsletter: boolean
}

