package com.lcwd.test;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData() {
        return api.getData();
    }

    public String fetchUserData(String username) {
        return api.getUserData(username);
    }

    public void processEvent(String event) {
        api.logEvent(event);
    }

    public void processSequence() {
        api.authenticate();
        api.getData();
        api.logout();
    }
}