import type { AppProps } from 'next/app';
import { MsalProvider } from '@azure/msal-react';
import 'styles/globals.css';
import StoreProvider from 'store/StoreProvider';
import authProvider from 'modules/auth/AuthProvider';

export default function App({ Component, pageProps }: AppProps) {
  return (
    <StoreProvider>
      <MsalProvider instance={authProvider}>
        <Component {...pageProps} />
      </MsalProvider>
    </StoreProvider>
  );
}
