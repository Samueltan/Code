import { NgModule } from '@angular/core';
import { ReqresComponent } from './reqres.component';
import { UsersComponent } from './users/users.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [ReqresComponent, UsersComponent],
  imports: [CommonModule, HttpClientModule
  ],
  exports: [ReqresComponent]
})
export class ReqresModule { }
