import React from 'react';
import { Box, Grid, type SxProps, Typography } from '@mui/material';
import { styled } from '@mui/material/styles';

const GridHeader = styled(Grid)(({ theme }) => ({
  backgroundColor: theme.palette.primary.main,
  borderTopLeftRadius: 13,
  borderTopRightRadius: 13,
  padding: 10,
}));

const Title = styled(Typography)(({ theme }) => ({
  color: theme.palette.background.default,
  paddingLeft: 10,
}));

interface CustomPanelProps {
  title: string;
  children: React.ReactNode;
  sx?: SxProps;
}

export default function CustomPanel({ title, children, sx }: CustomPanelProps) {
  return (
    <Box
      display="flex"
      border={1}
      borderColor="primary.main"
      bgcolor="background.paper"
      borderRadius={4}
      margin={2}
      sx={{ ...sx }}
    >
      <Grid container item xs={12} direction="column">
        <GridHeader container direction="row">
          <Title variant="h6">{title}</Title>
        </GridHeader>
        <Grid container direction="column" sx={{ padding: 1 }}>
          {children}
        </Grid>
      </Grid>
    </Box>
  );
}
