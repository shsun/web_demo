package com.youdo.util.mail;

import javax.mail.*;

/**
 * 
 * @author shsun
 *
 */
public class CustomizedAuthenticator extends Authenticator {
    String userName = null;
    String password = null;

    public CustomizedAuthenticator() {
        this(null, null);
    }

    public CustomizedAuthenticator(String username, String password) {
        this.userName = username;
        this.password = password;
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(userName, password);
    }
}