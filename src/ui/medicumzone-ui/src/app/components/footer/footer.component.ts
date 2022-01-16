import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {ToastService} from "../shared/toast/toast-service";

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.css']
})
export class FooterComponent implements OnInit {

  // @ts-ignore
  @ViewChild('email', {static: true}) emailValue: ElementRef;

  buttonState = false;
  buttonValue = '';

  constructor(private toastService: ToastService) {
  }

  ngOnInit(): void {
  }

  onNewsletter() {
    console.log(this.emailValue.nativeElement.value);
    this.showDanger("error");
  }

  showSuccess() {
    this.toastService.show('Email został pomyślnie dodany do newslettera!', {
      classname: 'bg-primary text-light',
      delay: 10000
    });
  }

  showDanger(dangerTpl: any) {
    this.toastService.show("Brak implementacji", {classname: 'bg-danger text-light', delay: 5000});
  }

}
