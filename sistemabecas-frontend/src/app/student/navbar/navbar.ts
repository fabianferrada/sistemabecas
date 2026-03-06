import { Component } from '@angular/core';
import { State, Globalstate } from '../../services/globalstate';

@Component({
  selector: 'student-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class StudentNavbar {
	State = State;
	
	constructor(public globalState: Globalstate) {}
}
