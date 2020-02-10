package br.com.versa.client.controller;

public class ResponseErrorDTO {

    private String returnCode;
    private String message;
    private StackTraceElement[] traceElements;

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTraceElements(StackTraceElement[] stackTrace) {
        this.traceElements = stackTrace;
    }
}
