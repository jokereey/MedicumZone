import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormControl,
  FormGroup,
  ValidationErrors,
  ValidatorFn,
  Validators
} from "@angular/forms";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  formGroup: FormGroup;
  @ViewChild('passwordConfirm') passwordConfirm: ElementRef;

  constructor(private formBuilder:FormBuilder) { }

  ngOnInit(): void {
    this.initForm();

  }
  initForm(){
    this.formGroup = this.formBuilder.group({
      name: this.formBuilder.control('',{
        validators: Validators.required
      }),
      surname:this.formBuilder.control('',{
        validators: Validators.required
      }),
      PESEL: this.formBuilder.control('',{
        validators: Validators.compose([
          Validators.required,
          Validators.minLength(11),
          Validators.maxLength(11),
          Validators.pattern(new RegExp('^[0-9]+$'))
        ])
      }),
      phoneNumber: this.formBuilder.control('',{
        validators: Validators.compose([
          Validators.required,
          Validators.minLength(9),
          Validators.maxLength(9)
        ])
      }),
      email: this.formBuilder.control('',{
        validators: Validators.compose([
          Validators.required,
          Validators.email
        ])
      }),
      dob: this.formBuilder.control('',{
        validators: Validators.compose([
          Validators.required,
          this.isAdult.bind(this),
        ])
      }),
     passwords: this.formBuilder.group({
       password: ['', [Validators.required,Validators.pattern(new RegExp('^(?=.*[A-Z])(?=.*[!@#$%^&*()_+=`]).{8,}$'))]],
       confirmPassword: ['',[Validators.required]]
     }, { validators: this.checkPasswords.bind(this)}),

      newsletter:this.formBuilder.control('',{
      }),
      privacy:this.formBuilder.control('',{
        validators: Validators.requiredTrue
      }),
      }
    )
  }
  show(){
    console.log(this.formGroup);
  }
  isAdult(control: FormControl): {[s:string]: boolean} | null{
   let year = control.value.substring(0,4);
   let month = control.value.substring(5,7);
   let day = control.value.substring(8,10);
   const currentYear = new Date().getFullYear();
   const currentMonth = new Date().getMonth() +1;
   const currentDay = new Date().getDate();
   if(currentYear - year > 18){
     return null;
   }else if(currentYear - year === 0){
     if(month > currentMonth ){
       return null;
     } else if(month === currentMonth){
       if(day>= currentDay){
         return null;
       } else if (day<currentDay){
         return {isAdult: false}
       }
     }
   }
    return {isAdult: false};
  }
  checkPasswords: ValidatorFn = (group: AbstractControl):  ValidationErrors | null => {
    let pass = group.get('password')!.value;
    let confirmPass = group.get('confirmPassword')!.value
    return pass === confirmPass ? null : { notSame: true }
  }


}
