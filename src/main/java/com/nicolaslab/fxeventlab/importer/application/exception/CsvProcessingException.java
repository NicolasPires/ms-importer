package com.nicolaslab.fxeventlab.importer.application.exception;

public class CsvProcessingException extends ApplicationException {

    public CsvProcessingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CsvProcessingException(String message) {
        super(message);
    }
}
