import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Profile {
	userData = {
		nombres: "Fabián Eduardo",
		apellidos: "Ferrada Merino",
		rut: 20629178,
		email: "fabianferrada406@gmail.com",
		contrasena: "87399443"
	};
	
	public getUserNombres() {
		return this.userData.nombres;
	}
	
	public getUserApellidos() {
		return this.userData.apellidos;
	}
	
	public getUserRut() {
		return this.userData.rut;
	}
	
	public getUserEmail() {
		return this.userData.email;
	}
	
	public getUserContrasena() {
		return this.userData.contrasena;
	}
	
	public setUserData(data: any) {
		this.userData = data;
	}
}
