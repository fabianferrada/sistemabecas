import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Applications {
	availableApplications = [
		{
			id: 0,
			estado: "pendiente",
			comentario: "",
			beca: {
				nombre: "Beca de Alimentación",
				descripcion: "Beca de Alimentación para estudiantes de la educación superior"
			}
		},
		{
			id: 1,
			estado: "aprobada",
			comentario: "Sin comentarios",
			beca: {
				nombre: "Beca Municipal",
				descripcion: "Pago único de 200.000 pesos"
			}
		},
		{
			id: 2,
			estado: "rechazada",
			comentario: "",
			beca: {
				nombre: "Beca de Transporte",
				descripcion: "Pago de pasajes para traslado con fines estudiantiles"
			}
		}
	]
	
	public hasApplications(): boolean {
		return true;
	}
	
	public getApplications() {
		return this.availableApplications;
	}
}
