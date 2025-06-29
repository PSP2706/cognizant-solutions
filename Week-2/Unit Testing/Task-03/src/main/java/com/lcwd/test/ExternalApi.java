package com.lcwd.test;

public interface ExternalApi {
    String getData();
    String getUserData(String username);
    void logEvent(String event);
    void authenticate();
    void logout();
}
