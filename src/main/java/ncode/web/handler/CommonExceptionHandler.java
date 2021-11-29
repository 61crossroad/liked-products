package ncode.web.handler;

import ncode.web.payload.ApiResponse;
import ncode.web.payload.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.management.InstanceAlreadyExistsException;

public class CommonExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiResponse<?>> illegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity
                .status(HttpStatus.FORBIDDEN)
                .body(ApiResponse.of(
                        false,
                        null,
                        ErrorResponse.builder()
                                .status(HttpStatus.FORBIDDEN.value())
                                .message(e.getMessage())
                                .build()));
    }

    @ExceptionHandler(InstanceAlreadyExistsException.class)
    public ResponseEntity<ApiResponse<?>> instanceAlreadyExistsException() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.of(
                        false,
                        null,
                        ErrorResponse.builder()
                                .status(HttpStatus.BAD_REQUEST.value())
                                .message("이미 존재하는 코드입니다.")
                                .build()));
    }

}
