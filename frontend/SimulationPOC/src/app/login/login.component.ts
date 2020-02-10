import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../shared/authentication.service';
import { Router } from "@angular/router";
import {Location} from "@angular/common"

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username:string='';
  password:string='';
  invalidLogin:boolean=false;

  constructor(private authenticationService:AuthenticationService, private router:Router,private location:Location) { }

  ngOnInit() {
  }

  checkLogin(){
    this.authenticationService.authenticate(this.username, this.password)
        .subscribe(
           data => {
        
        this.invalidLogin = false
        this.location.back();
      },
      error => {
        this.invalidLogin = true
      }
        );
  }
}
