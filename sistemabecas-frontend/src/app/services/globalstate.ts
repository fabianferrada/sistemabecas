import { Injectable } from '@angular/core';

export enum State {
	Appeals,
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
}
