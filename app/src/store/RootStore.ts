import { makeAutoObservable } from 'mobx';
import { ToastStore } from './ToastStore';

export class RootStore {
  public toast: ToastStore;

  constructor() {
    this.toast = new ToastStore();
    makeAutoObservable(this);
  }

  public successToast(message: string): void {
    this.toast.message = message;
    this.toast.severity = 'success';
    this.toast.isOpen = true;
  }

  public errorToast(message: string): void {
    this.toast.message = message;
    this.toast.severity = 'error';
    this.toast.isOpen = true;
  }
}
