package it.unibo.exceptions.fakenetwork;

import java.io.IOException;

public class NetworkException extends IOException {
    public NetworkException() {
        super("Network Error: no response");
    }

    public NetworkException(String errorMessage) {
        super("Network error while sending message: " + errorMessage);
    }

}
