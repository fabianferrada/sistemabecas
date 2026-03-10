import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { State, Globalstate } from '../globalstate';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
	constructor(public globalState: Globalstate, private httpClient: HttpClient) {}
	
	public login(email: string, password: string) {
		this.httpClient.post<string>('/auth/estudiante/login', {
			email: email,
			password: password
		}).subscribe(token => this.setToken(token)); // Hacer que esta cosa haga toda la pega
		
		if (localStorage.getItem('jwt')!.length > 0) {
			this.globalState.currentState = State.Applications;
		}
	}
	
	public setToken(jwtToken: string) {
		localStorage.setItem('jwt', jwtToken);
	}
}
