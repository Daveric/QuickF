import { object, string, number } from 'yup';
import { YupValidation } from 'common/TextConstants';

export interface Business {
  ruc: string;
  title: string;
  commercialName: string;
  address: string;
  establishmentCode: number;
  emissionCode: number;
  resolution: string;
  obligatedAccountability: boolean;
  email: string;
  phone: string;
  pathFileP12: string;
  adminPassword: string;
}

export const validationSchema = () => {
  const { requiredField, numericTypeError, emailValidation } = YupValidation;
  return object({
    ruc: string()
      .length(13, 'Debe ingresar 13 numeros')
      .required(requiredField),
    title: string().required(requiredField),
    commercialName: string(),
    address: string().required(requiredField),
    establishmentCode: number()
      .typeError(numericTypeError)
      .required(requiredField),
    emissionCode: number().typeError(numericTypeError).required(requiredField),
    resolution: string(),
    obligatedAccountability: string().required(requiredField),
    email: string().email(emailValidation).required(requiredField),
    phone: string(),
    pathFileP12: string().required(requiredField),
    adminPassword: string().required(requiredField),
  });
};
