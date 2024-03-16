package uz.ilmnajot.adminpanel.exception;

import org.springframework.http.HttpStatus;

public class SuggestionException extends BaseException {
    public SuggestionException(String message) {
        super(message);
    }

    public SuggestionException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }

    public SuggestionException(HttpStatus httpStatus) {
        super(httpStatus);
    }
}
