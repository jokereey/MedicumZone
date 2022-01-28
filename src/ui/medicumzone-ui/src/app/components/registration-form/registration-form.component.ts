import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-registration-form',
  templateUrl: './registration-form.component.html',
  styleUrls: ['./registration-form.component.css']
})
export class RegistrationFormComponent implements OnInit {

  formGroup: FormGroup;

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
        validators: Validators.required
      }),
      password: this.formBuilder.control('',{
        validators: Validators.compose([
          Validators.required,
          Validators.minLength(8)
        ])
      }),
      newsletter:this.formBuilder.control('',{
      }),
      privacy:this.formBuilder.control('',{
        validators: Validators.requiredTrue
      }),
      }
    )
  }
  show(){
    console.log(this.formGroup.value);
  }

}
