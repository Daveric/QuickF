import {
  Box,
  Button,
  FormControlLabel,
  Grid,
  Switch,
  TextField,
  Typography,
} from '@mui/material';
import FileUploadIcon from '@mui/icons-material/FileUpload';
import CustomPanel from '../../common/components/CustomPanel';
import React, { useEffect } from 'react';
import { useForm } from 'react-hook-form';
import { type Business, validationSchema } from '../../model/Business';
import { yupResolver } from '@hookform/resolvers/yup';

export default function BusinessRegistration() {
  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    watch,
    clearErrors,
  } = useForm<Business>({ resolver: yupResolver(validationSchema()) });

  useEffect(() => {
    register('pathFileP12');
  }, [register]);

  function handleSubmitP12File(e: React.ChangeEvent<HTMLInputElement>) {
    if (e.target.files?.[0]?.name != null) {
      clearErrors('pathFileP12');
      setValue('pathFileP12', e.target.files[0].name);
    }
  }

  const onSubmit = (data: Business) => {
    // console.log(data);
  };

  console.log('errors: ', errors);

  return (
    <Grid container spacing={2}>
      <CustomPanel
        title="Formulario de Registro de Empresa"
        sx={{ width: 1, margin: 5 }}
      >
        <form onSubmit={handleSubmit(onSubmit)}>
          <Grid container spacing={4}>
            <Grid item xs={12}>
              <Grid item xs={6}>
                <TextField
                  fullWidth
                  id="ruc-id"
                  label="RUC"
                  variant="outlined"
                  {...register('ruc')}
                  helperText={errors?.ruc?.message}
                  error={Boolean(errors?.ruc?.message)}
                />
              </Grid>
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="razon-id"
                label="RAZÓN SOCIAL"
                variant="outlined"
                {...register('title')}
                helperText={errors?.title?.message}
                error={Boolean(errors?.title?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="nombre-comercial-id"
                label="NOMBRE COMERCIAL"
                variant="outlined"
                {...register('commercialName')}
                helperText={errors?.commercialName?.message}
                error={Boolean(errors?.commercialName?.message)}
              />
            </Grid>
            <Grid item xs={12}>
              <TextField
                fullWidth
                id="direccion-id"
                label="DIRECCIÓN ESTABLECIMIENTO"
                variant="outlined"
                {...register('address')}
                helperText={errors?.address?.message}
                error={Boolean(errors?.address?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="codigo-establecimiento-id"
                label="CODIGO ESTABLECIMIENTO"
                variant="outlined"
                {...register('establishmentCode')}
                helperText={errors?.establishmentCode?.message}
                error={Boolean(errors?.establishmentCode?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="codigo-punto-emision-id"
                label="CODIGO PUNTO EMISION"
                variant="outlined"
                {...register('emissionCode')}
                helperText={errors?.emissionCode?.message}
                error={Boolean(errors?.emissionCode?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="resolucion-id"
                label="RESOLUCIÓN"
                variant="outlined"
                {...register('resolution')}
                helperText={errors?.resolution?.message}
                error={Boolean(errors?.resolution?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <FormControlLabel
                value="start"
                control={<Switch color="primary" />}
                label="Obligado a llevar contabilidad?"
                sx={{ color: 'text.secondary' }}
                labelPlacement="start"
                {...register('obligatedAccountability')}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="email-id"
                label="EMAIL"
                variant="outlined"
                {...register('email')}
                helperText={errors?.email?.message}
                error={Boolean(errors?.email?.message)}
              />
            </Grid>
            <Grid item xs={6}>
              <TextField
                fullWidth
                id="telefonos-id"
                label="TELEFONOS"
                variant="outlined"
                {...register('phone')}
                helperText={errors?.phone?.message}
                error={Boolean(errors?.phone?.message)}
              />
            </Grid>
          </Grid>
          <CustomPanel title="SUBIR ARCHIVO .P12">
            <Grid container spacing={2}>
              <Grid item xs={3}>
                <input
                  id="p12-file-button"
                  accept=".p12"
                  style={{ display: 'none' }}
                  type="file"
                  onChange={handleSubmitP12File}
                />
                <label htmlFor="p12-file-button">
                  <Button
                    color="primary"
                    aria-label="upload picture"
                    component="span"
                    variant="outlined"
                    endIcon={<FileUploadIcon />}
                  >
                    Seleccionar el archivo .p12
                  </Button>
                </label>
              </Grid>
              <Grid item xs={6}>
                <Typography variant="h6" color="text.primary">
                  {errors?.pathFileP12?.message ?? watch('pathFileP12')}
                </Typography>
              </Grid>
            </Grid>
          </CustomPanel>
          <Box
            sx={{ display: 'flex', justifyContent: 'flex-end', mr: 2, my: 1 }}
          >
            <Button type="submit" variant="contained">
              Guardar y Continuar
            </Button>
          </Box>
        </form>
      </CustomPanel>
    </Grid>
  );
}
