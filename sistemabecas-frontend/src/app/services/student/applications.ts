import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class Applications {
	public hasApplications(): boolean {
		return true;
	}
}
