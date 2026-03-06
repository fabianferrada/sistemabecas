import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class AppealService {
	appeals = [
		{
			id: 0,
			titulo: "Certificado de residencia válido",
			descripcion: "El certificado de residencia de mi postulación es válido",
			postulacion: {
				id: 0,
				beca: {
					id: 0,
					nombre: "Beca de Transporte"
				}
			}
		}
	]
	
	public hasAppeals() {
		return true; // TODO
	}
	
	public getAppeals() {
		return this.appeals;
	}
}
