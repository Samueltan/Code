import { Component, OnInit, Input } from '@angular/core';
import { ReqresService } from '../../public_api';
import { Users } from '../model/users';

@Component({
    selector: 'rr-users',
    templateUrl: './users.component.html',
    styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {
    users: Users;
    @Input()
    pageNumber: number;

    constructor(private reqresService: ReqresService) { }

    ngOnInit() {
        this.getUsers();
    }

    getUsers(): void {
        this.reqresService.getUsers(this.pageNumber).subscribe(
            arg => this.users = arg
        );
    }
}
