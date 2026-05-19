import { Injectable } from '@angular/core';

import { ScholarshipService } from './student/scholarship';

export enum State {
	Appeals,
	Applications,
	Application,
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

	constructor(public scholarshipService: ScholarshipService) {}

	public goLogin() {
		// TODO
		this.currentState = State.Login;
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

	public goApplication(id: number) {
		this.scholarshipService.setCurrentScholarship(id);
		this.currentState = State.Application;
	}
}
