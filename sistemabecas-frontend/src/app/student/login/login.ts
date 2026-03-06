import { Component } from '@angular/core';

import { State, Globalstate } from '../../services/globalstate';

@Component({
  selector: 'student-login',
  imports: [],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class StudentLogin {
	constructor(public globalState: Globalstate) {}
	
	public goRegister() {
		// Nada por ahora
		this.globalState.currentState = State.Register;
	}
}
