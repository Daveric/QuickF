import Head from 'next/head';
import Image from 'next/image';
import styles from 'styles/Home.module.css';
import {
  AuthenticatedTemplate,
  UnauthenticatedTemplate,
  useIsAuthenticated,
  useMsal,
  useMsalAuthentication,
} from '@azure/msal-react';
import {
  InteractionRequiredAuthError,
  InteractionType,
} from '@azure/msal-browser';
import { useEffect } from 'react';
import { useRouter } from 'next/router';

export default function Home(): JSX.Element {
  const { login, error } = useMsalAuthentication(InteractionType.Redirect);
  const { accounts, instance } = useMsal();
  const isAuthenticated = useIsAuthenticated();
  const router = useRouter();

  const handleLogout = (): void => {
    void instance.logoutRedirect();
  };

  useEffect(() => {
    if (error instanceof InteractionRequiredAuthError) {
      void login(InteractionType.Redirect);
    }
  }, [error]);

  useEffect(() => {
    if (isAuthenticated) {
      void router.push('/business/registration');
    }
  }, [isAuthenticated]);

  return (
    <div className={styles.container}>
      <Head>
        <title>QuickF</title>
        <meta name="description" content="Generated by create next app" />
        <link rel="icon" href="/app/public/favicon.ico" />
      </Head>

      <main className={styles.main}>
        <h1 className={styles.title}>
          Welcome to <a href="https://nextjs.org">QuickF!</a>
        </h1>
        <UnauthenticatedTemplate>
          <p>Loading loging</p>
        </UnauthenticatedTemplate>
        <AuthenticatedTemplate>
          <p>
            Signed in as: <>{accounts[0]?.idTokenClaims?.given_name}</>
          </p>
          <button onClick={handleLogout}>Logout</button>
        </AuthenticatedTemplate>
      </main>

      <footer className={styles.footer}>
        <a
          href="https://vercel.com?utm_source=create-next-app&utm_medium=default-template&utm_campaign=create-next-app"
          target="_blank"
          rel="noopener noreferrer"
        >
          Powered by{' '}
          <span className={styles.logo}>
            <Image src="/vercel.svg" alt="Vercel Logo" width={72} height={16} />
          </span>
        </a>
      </footer>
    </div>
  );
}
