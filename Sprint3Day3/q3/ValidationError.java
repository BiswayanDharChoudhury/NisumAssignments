package com.nisum.NisumAssignments;

import java.time.LocalDateTime;
import java.util.List;

public class ValidationError {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private List<FieldErrorDetail> fieldErrors;

    // Constructor
    public ValidationError(int status, String error, List<FieldErrorDetail> fieldErrors) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.fieldErrors = fieldErrors;
    }

    // Getters
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getError() { return error; }
    public List<FieldErrorDetail> getFieldErrors() { return fieldErrors; }

    public static class FieldErrorDetail {
        private String field;
        private String message;

        public FieldErrorDetail(String field, String message) {
            this.field = field;
            this.message = message;
        }

        // Getters
        public String getField() { return field; }
        public String getMessage() { return message; }
    }
}
