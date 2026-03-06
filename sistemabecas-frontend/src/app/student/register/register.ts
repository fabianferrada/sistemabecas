import { Component } from '@angular/core';

import { State, Globalstate } from '../../services/globalstate';

@Component({
  selector: 'student-register',
  imports: [],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class StudentRegister {
	constructor(public globalState: Globalstate) {}
	
	public goLogin() {
		this.globalState.currentState = State.Login;
	}
}
