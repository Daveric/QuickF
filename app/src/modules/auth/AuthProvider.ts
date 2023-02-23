import {
  type Configuration,
  LogLevel,
  PublicClientApplication,
} from '@azure/msal-browser';

const logger = (
  level: LogLevel,
  message: string,
  containsPii: boolean
): void => {
  if (containsPii) {
    return;
  }

  // eslint-disable-next-line default-case
  switch (level) {
    // TODO: Add AppInsights Logging
    case LogLevel.Error:
      console.error(`${LogLevel[LogLevel.Error]}: ${message}`);
      return;
    case LogLevel.Info:
      console.info(`${LogLevel[LogLevel.Info]}: ${message}`);
      return;
    case LogLevel.Verbose:
      console.debug(`${LogLevel[LogLevel.Verbose]}: ${message}`);
      return;
    case LogLevel.Warning:
      console.warn(`${LogLevel[LogLevel.Warning]}: ${message}`);
  }
};

const configuration: Configuration = {
  auth: {
    clientId: '4fd5c444-e45e-44f6-8faf-b29cda3be7b7',
    authority:
      'https://quickbilling.b2clogin.com/quickbilling.onmicrosoft.com/B2C_1_QuickF_SigninSignup',
    knownAuthorities: ['https://quickbilling.b2clogin.com'],
    redirectUri: '/',
    postLogoutRedirectUri: '/',
  },
  cache: { cacheLocation: 'localStorage' },
  system: {
    loggerOptions: {
      loggerCallback: logger,
      piiLoggingEnabled: false,
    },
  },
};

const AuthProvider = new PublicClientApplication(configuration);

export default AuthProvider;
