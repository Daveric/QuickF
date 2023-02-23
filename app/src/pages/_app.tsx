import type { AppProps } from 'next/app';
import { MsalProvider } from '@azure/msal-react';
import authProvider from '../modules/auth/AuthProvider';
import '../../styles/globals.css';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <MsalProvider instance={authProvider}>
      <Component {...pageProps} />
    </MsalProvider>
  );
}
