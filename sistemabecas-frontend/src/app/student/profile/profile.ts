import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { Profile } from '../../services/student/profile';

@Component({
  selector: 'student-profile',
  imports: [ FormsModule ],
  templateUrl: './profile.html',
  styleUrl: './profile.css',
})
export class StudentProfile {
	nombres: String;
	apellidos: String;
	rut: number;
	email: String;
	contrasena: String;
	
	constructor(public profileService: Profile) {
		this.nombres = profileService.getUserNombres();
		this.apellidos = profileService.getUserApellidos()
		this.rut = profileService.getUserRut();
		this.email = profileService.getUserEmail();
		this.contrasena = profileService.getUserContrasena();
	}
	
	public editUser() {
		this.profileService.setUserData(
			{
				nombres: this.nombres,
				apellidos: this.apellidos,
				rut: this.rut,
				email: this.email,
				contrasena: this.contrasena
			}
		);
	}
}
