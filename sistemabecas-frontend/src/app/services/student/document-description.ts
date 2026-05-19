import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class DocumentDescription {
  documents = [
    {
      id: 0,
      nombre: "Certificado de residencia",
      descripcion: "Documento de certificado de residencia firmado por la junta de vecinos correspondiente",
      idBeca: 0
    },
    {
      id: 1,
      nombre: "Certificado de residencia",
      descripcion: "Documento de certificado de residencia firmado por la junta de vecinos correspondiente",
      idBeca: 1
    }, 
    {
      id: 2,
      nombre: "Resumen de notas",
      descripcion: "Listado de asignaturas cursadas por el estudiante durante el semestre anterior",
      idBeca: 0
    }
  ]

  public getCurrentScholarshipDocuments() {
    var scholarshipDocs = []

    for (let i = 0; i < this.documents.length; i++) {
      scholarshipDocs.push(this.documents[i]);
    }

    return scholarshipDocs;
  }
}
