package com.creapption.quickf.util;

import java.security.cert.X509Certificate;

import xades4j.providers.impl.KeyStoreKeyingDataProvider;

/**
 * Defines a DirectPassword provider class for using it in the sign Xades sign
 * doc
 */
public class DirectPasswordProvider implements KeyStoreKeyingDataProvider.KeyStorePasswordProvider,
        KeyStoreKeyingDataProvider.KeyEntryPasswordProvider {
    private char[] password;

    public DirectPasswordProvider(String password) {
        this.password = password.toCharArray();
    }

    @Override
    public char[] getPassword() {
        return password;
    }

    @Override
    public char[] getPassword(String alias, X509Certificate certificate) {
        return password;
    }
}