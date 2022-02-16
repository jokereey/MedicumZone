import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {UserHeaderComponent} from "./user-header/user-header.component";
import {RouterModule, Routes} from "@angular/router";
import {UserMainPanelComponent} from "./user-main-panel/user-main-panel.component";
import { AppointmentsComponent } from './appointments/appointments.component';
import { VaccineComponent } from './vaccine/vaccine.component';
import { PrescriptionsComponent } from './prescriptions/prescriptions.component';
import { AccountDetailsComponent } from './account-details/account-details.component';
import { PasswordEditComponent } from './edit/password/password-edit/password-edit.component';


const userRoutes: Routes = [
  {
    path: 'user',
    component: UserMainPanelComponent,
  },
  {
    path:'details',
    component:AccountDetailsComponent,
  children: [
    {
      path: 'password',
      component: PasswordEditComponent,
    }
  ]
  }
]


@NgModule({
  declarations: [
    UserHeaderComponent,
    UserMainPanelComponent,
    AppointmentsComponent,
    VaccineComponent,
    PrescriptionsComponent,
    AccountDetailsComponent,
    PasswordEditComponent,

  ],
  imports: [
    CommonModule,
    RouterModule.forChild(userRoutes),

  ]
})
export class UserModule { }
