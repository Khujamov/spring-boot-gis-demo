package pl.giscon.demo.sb2spatial.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
public class ApplicationException extends RuntimeException {

    public ApplicationException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
