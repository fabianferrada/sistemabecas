import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Globalstate } from '../../services/globalstate';
import { LoginService } from '../../services/student/login';

@Component({
  selector: 'student-login',
  imports: [ FormsModule ],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class StudentLogin {
	public correo: string = "";
	public contrasena: string = "";
	
	constructor(public globalState: Globalstate, private loginService: LoginService) {}
	
	public goRegister() {
		// Nada por ahora
		this.globalState.goRegister();
	}
	
	public makeLogin() {
		// this.loginService.login(this.correo, this.contrasena);
		this.globalState.goApplications();
		
		// TODO
		// Emitir algún mensaje o algo
	}
}
