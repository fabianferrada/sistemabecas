import { Component } from '@angular/core';
import { State, Globalstate } from '../../services/globalstate';

@Component({
  selector: 'student-navbar',
  imports: [],
  templateUrl: './navbar.html',
  styleUrl: './navbar.css',
})
export class StudentNavbar {
	constructor(public globalstate: Globalstate) {}
	
	public goLogin() {
		// Nada por ahora
		this.globalstate.currentState = State.Login;
	}
}
