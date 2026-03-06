import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class ScholarshipService {
	scholarships = [
		{
			id: 0,
			nombre: "Beca de Mantención",
			descripcion: "Pago único de 200.000 pesos",
			fechaminimapostulacion: "20/12/2025",
			fechamaximapostulacion: "20/06/2026"
		},
		{
			id: 1,
			nombre: "Beca de Transporte",
			descripcion: "Boletos para transporte con fines de estudio",
			fechaminimapostulacion: "20/11/2025",
			fechamaximapostulacion: "20/07/2026"
		}
	]
	
	public hasScholarships() {
		return true;
	}
	
	public getScholarships() {
		return this.scholarships;
	}
}
