package com.creapption.xades.keyStore;

import es.mityc.javasign.pkstore.IPassStoreKS;

import java.security.cert.X509Certificate;

public class PassStoreKS implements IPassStoreKS {

    /** Contraseña de acceso al almacén. */
    private transient String password;

    /**
     * Crea una instancia con la contraseña que se utilizará con el almacén relacionado.
     * @param pass Contraseña del almacén
     */
    public PassStoreKS(final String pass) {
        this.password = new String(pass);
    }

    /**
     * Devuelve la contraseña configurada para este almacén.
     * @param certificate X509Certificate
     * @param alias String
     * @return char[]
     * @see IPassStoreKS#getPassword(X509Certificate, String)
     */
    public char[] getPassword(final X509Certificate certificate, final String alias) {
        return password.toCharArray();
    }

}