import { AppBar, Box, Toolbar, Typography } from '@mui/material';
import Image from 'next/image';

export default function TopBarNavigation() {
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <Image
            src="/images/svg/quickf-transparent.svg"
            alt="quickf-logo"
            width={50}
            height={50}
          />
          <Typography
            variant="h6"
            component="div"
            color="white"
            sx={{ flexGrow: 1, px: 3 }}
          >
            Facturación Electronica
          </Typography>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
