import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Tour of Heroes';
  isAllRowsSelected = false;

  switch() {
      console.log(this.isAllRowsSelected);
      this.isAllRowsSelected = !this.isAllRowsSelected;
  }
}
