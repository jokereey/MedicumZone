import {Injectable} from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ExceptionService {

  constructor() {
  }

  manageErrorInfo(err: any): string{
    console.log(err.status);
    if(err.status===404){
      return 'Niestety, nie można znaleźć tego zasobu.';
    } else if(err.status ===401){
     return  'Podane hasło jest niepoprawne.';
    }
    else if(err.status ===500){
      return 'Wystąpił błąd połączenia z serwerem. Proszę spróbować później.';
    }else if(err.status ===0){
      return 'Nie udało się nawiązać połączenia z serwerem - przepraszamy za problemy.'
    }
    else if(err.status === 208){
      return 'Taki użytkownik już istnieje w naszej bazie danych'
    }
    else{
      return 'Przepraszamy, wystąpił nieznany błąd.'
    }
  }
  manageSuccessInfo(res: any){
    return res.message;
  }
}
