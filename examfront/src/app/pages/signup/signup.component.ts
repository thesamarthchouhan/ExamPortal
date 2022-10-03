import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  constructor() { }

  public user={
    userName : '',
    password : '',
    firstName : '',
    lastName : '',
    email : '',
    phone : ''

  }

  ngOnInit(): void {
  }

  formSubmit(){
    console.log(this.user);
    if(this.user.userName == '' || this.user.userName == null){
      alert('username is required');
    }
  }

}
