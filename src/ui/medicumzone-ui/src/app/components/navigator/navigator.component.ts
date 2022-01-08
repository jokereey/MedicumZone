import {Component, OnInit} from '@angular/core';
import {NavigatorItem} from "../../model/model";

@Component({
  selector: 'app-navigator',
  templateUrl: './navigator.component.html',
  styleUrls: ['./navigator.component.css'],
})
export class NavigatorComponent implements OnInit {

  navigatorContent: Array<NavigatorItem>;

  constructor() {
    this.initNavigatorData();
  }

  ngOnInit(): void {
    this.initNavigatorData();
  }

  click() {
    console.log('click');
  }

  initNavigatorData() {
    this.navigatorContent = [
      {header: "Lekarze", description: "Poznaj najlepszych lekarzyc w Polsce", order: 1},
      {header: "Placówki", description: "Sprawdź gdzie znajdują się przychodnie Medicum-Zone", order: 2},
      {header: "Szczepienia", description: "Zapisy na szczepienia i szczegółowe statystyki", order: 3},
      {header: "Strefa studenta", description: "Benefity oraz oferty dla studentów", order: 4},
      {header: "Strefa wiedzy", description: "Sprawdź ciekawe artykuły i publikacje naukowe", order: 5},
      {header: "Kontakt", description: "Wszystkie możliwe sposoby kontaktu z nami", order: 6}
    ];
  }


}
