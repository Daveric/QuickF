import { makeAutoObservable } from 'mobx';

export class ToastStore {
  public isOpen: boolean;
  public message: string;
  public severity: 'success' | 'error';

  constructor() {
    this.isOpen = false;
    this.message = '';
    this.severity = 'success';
    makeAutoObservable(this);
  }

  public close(): void {
    this.isOpen = false;
  }
}
