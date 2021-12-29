import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  facebookLink: string ='https://facebook.com/medicum-zone';
  instagramLink: string ='https://instagram.com/medicum-zone';
  twitterLink: string ='https://twitter.com/medicum-zone';
  headerText : string = "Zadbaj o swoje zdrowie już dziś!"
  phoneNumber: string = '+12 630 80 00';
  constructor() { }

  ngOnInit(): void {
  }
  onLoginClick(){
  console.log('not implemented yet');
  }
  onRegistryClick(){
    console.log('not implemented yet');
  }

}
