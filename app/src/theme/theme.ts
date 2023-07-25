import { createTheme } from '@mui/material';

const themeColors = {
  brandPrimary: '#31B4A5',
  brandPrimaryDark: '#072328',
  brandPrimaryExtraLight: '#52BCBA',
  brandSecondary: '#ee8131',
};

const themeLight = createTheme({
  palette: {
    mode: 'light',
    primary: {
      main: themeColors.brandPrimary,
      dark: themeColors.brandPrimaryDark,
      light: themeColors.brandPrimaryExtraLight,
    },
    secondary: {
      main: themeColors.brandSecondary,
    },
  },
  typography: {
    fontFamily: '"Poppins"',
  },
});

export default themeLight;
