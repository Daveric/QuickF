import { Head, Html, Main, NextScript } from 'next/document';

export default function Document() {
  return (
    <Html>
      <Head>
        <meta name="application-name" content="QuickF Facturacion" />
        <meta name="description" content="Electronic Billing" />
        <meta name="apple-mobile-web-app-capable" content="yes" />
        <meta name="apple-mobile-web-app-status-bar-style" content="default" />
        <meta name="apple-mobile-web-app-title" content="QuickF" />
        <meta name="format-detection" content="telephone=no" />
        <meta name="mobile-web-app-capable" content="yes" />
        <meta name="msapplication-config" content="/icons/browserconfig.xml" />
        <meta name="msapplication-TileColor" content="#2B5797" />
        <meta name="msapplication-tap-highlight" content="no" />
        <meta name="theme-color" content="#ffffff" />

        {/* For some reason this path should be relative instead of absolute */}
        <link rel="apple-touch-icon" href="/images/pwa/apple-touch-icon.png" />
        <link
          rel="apple-touch-icon"
          sizes="192x192"
          href="/app/public/images/pwa/apple-icon-192.png"
        />
        <link
          rel="apple-touch-icon"
          sizes="152x152"
          href="/app/public/images/pwa/apple-icon-152.png"
        />
        <link
          rel="apple-touch-icon"
          sizes="180x180"
          href="/app/public/images/pwa/apple-icon-180.png"
        />
        <link
          rel="apple-touch-icon"
          sizes="167x167"
          href="/app/public/images/pwa/apple-icon-167.png"
        />

        <link
          rel="icon"
          type="image/png"
          sizes="32x32"
          href="/app/public/images/pwa/favicon-32.png"
        />
        <link
          rel="icon"
          type="image/png"
          sizes="16x16"
          href="/app/public/images/pwa/favicon-16.png"
        />
        <link rel="manifest" href="/app/public/manifest.json" />
        <link
          href="https://fonts.googleapis.com/css2?family=Poppins:wght@300&display=swap"
          rel="stylesheet"
        />
      </Head>
      <body>
        <Main />
        <NextScript />
      </body>
    </Html>
  );
}
