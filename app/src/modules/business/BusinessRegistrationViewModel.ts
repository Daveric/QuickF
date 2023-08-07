import { makeAutoObservable } from 'mobx';
import { type Business } from 'model/Business';
import { poster } from 'utils/AxiosHelper';
import { type AxiosError } from 'axios';

export default class BusinessRegistrationViewModel {
  constructor() {
    makeAutoObservable(this);
  }

  public async save(business: Business) {
    try {
      await poster('/register/business', business);
    } catch (e) {
      const error = e as AxiosError;
      console.error('Error saving business: ', error.response?.data);
    }
  }
}
