import { Injectable } from '@angular/core';

export enum State {
	Appeals,
	Appeal,
	Applications,
	Login,
	Register,
	Scholarships,
	User
}

@Injectable({
  providedIn: 'root',
})
export class Globalstate {
	currentState: State = State.Login;

	public goLogin() {
		// TODO
		this.currentState = State.Login;
	}
	
	public goAppeal() {
		// TODO
		this.currentState = State.Appeal;
	}
	
	public goProfile() {
		// TODO
		this.currentState = State.User;
	}
	
	public goApplications() {
		// TODO
		this.currentState = State.Applications;
	}
	
	public goRegister() {
		this.currentState = State.Register;
	}
	
	public goScholarships() {
		// TODO
		this.currentState = State.Scholarships;
	}
	
	public goAppeals() {
		// TODO
		this.currentState = State.Appeals;
	}
}
