package com.example.vaccinationcenter.advice;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorResponse {

    private List<ErrorDetail> errors = new ArrayList<>();

    public void addError(String field, String message) {
        ErrorDetail errorDetail = new ErrorDetail(field, message);
        errors.add(errorDetail);
    }

    public List<ErrorDetail> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorDetail> errors) {
        this.errors = errors;
    }

    public static class ErrorDetail {
        private String field;
        private String message;

        public ErrorDetail(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
