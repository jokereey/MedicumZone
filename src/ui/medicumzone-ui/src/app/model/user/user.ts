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
