import { Injectable } from '@angular/core';

export enum State {
	Login,
	Register,
	Applications
}

@Injectable({
  providedIn: 'root',
})
export class Globalstate {
  currentState: State = State.Login;
}
