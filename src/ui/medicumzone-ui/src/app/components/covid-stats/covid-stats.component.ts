import { Component, OnInit } from '@angular/core';
import {ModalDismissReasons, NgbModal} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'app-covid-stats',
  templateUrl: './covid-stats.component.html',
  styleUrls: ['./covid-stats.component.css']
})
export class CovidStatsComponent implements OnInit {
  closeResult = '';
  todaysDate:any= this.getCurrentTime();
  constructor(private modalService: NgbModal) { }

  ngOnInit(): void {

  }
  open(content : any) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.closeResult = `Closed with: ${result}`;
    }, (reason) => {
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
    this.modalService.open(content, { windowClass: 'dark-modal' });
  }
  getCurrentTime(): string{
    let today = new Date();
    return  today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
  }

}
