import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { APP_BASE_HREF, Location } from '@angular/common';
import { AppComponent } from './app.component';
import { NgxChartsModule } from '../src';
import { NgxUIModule } from '@swimlane/ngx-ui';

@NgModule({
  imports: [
    NgxChartsModule,
    BrowserModule,
    BrowserAnimationsModule,
    FormsModule,
    NgxUIModule
  ],
  declarations: [
    AppComponent
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

