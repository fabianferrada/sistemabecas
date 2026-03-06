import { Injectable } from '@angular/core';

export enum State {
	Login,
	Register
}

@Injectable({
  providedIn: 'root',
})
export class Globalstate {
  currentState: State = State.Login;
}
