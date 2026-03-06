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
	
	public goLogin() {
		// TODO
		this.globalState.currentState = State.Login;
	}
	
	public goProfile() {
		// TODO
		this.globalState.currentState = State.User;
	}
	
	public goApplications() {
		// TODO
		this.globalState.currentState = State.Applications;
	}
	
	public goScholarships() {
		// TODO
		this.globalState.currentState = State.Scholarships;
	}
	
	public goAppeals() {
		// TODO
		this.globalState.currentState = State.Appeals;
	}
}
