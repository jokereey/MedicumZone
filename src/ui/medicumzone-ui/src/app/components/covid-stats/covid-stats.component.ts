import {Component, OnInit} from '@angular/core';
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {CovidStatsService} from "../../services/covid/covid-stats.service";
import {CovidStats} from "../../model/model";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-covid-stats',
  templateUrl: './covid-stats.component.html',
  styleUrls: ['./covid-stats.component.css'],
  providers: [HttpClient]
})
export class CovidStatsComponent implements OnInit {
  closeResult = '';
  preloaderMessage: string = 'Proszę czekać...';
  todaysDate: any = this.getCurrentTime();
  covidSimpleStats: CovidStats;
  isModalReady = false;

  constructor(private modalService: NgbModal, private covidService: CovidStatsService) {
  }

  ngOnInit(): void {
    this.fetchCovidBasicData();
  }

  open(content: any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason: any) => {
      this.closeResult = `Dismissed ${CovidStatsComponent.getDismissReason(reason)}`;
    });
  }

  private static getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  openWindowCustomClass(content: any) {
    this.modalService.open(content, {windowClass: 'dark-modal'});
  }

  getCurrentTime(): string {
    let today = new Date();
    return today.getFullYear() + '-' + (today.getMonth() + 1) + '-' + today.getDate();
  }

  fetchCovidBasicData() {
    this.covidService.fetchBasicCovidStats().subscribe(data => {
      this.covidSimpleStats = data;
      this.isModalReady = true;
    });

  }

}
