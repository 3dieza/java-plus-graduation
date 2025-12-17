package ru.practicum.ewm.exception;

import jakarta.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    /* =========================
       400 BAD REQUEST
       ========================= */

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            BindException.class,
            ConstraintViolationException.class,
            MethodArgumentTypeMismatchException.class,
            MissingServletRequestParameterException.class,
            HttpMessageNotReadableException.class,
            IllegalArgumentException.class,
            InvalidRequestException.class,
            ConditionNotMetException.class
    })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleBadRequest(Exception ex) {
        log.debug("400 Bad Request: {}", ex.getMessage());
        return ErrorResponse.builder()
                .message("Invalid request")
                .reason("Bad request.")
                .status(HttpStatus.BAD_REQUEST)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /* =========================
       404 NOT FOUND
       ========================= */

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleNotFound(NotFoundException ex) {
        return ErrorResponse.builder()
                .message(ex.getMessage())
                .reason("The required object was not found.")
                .status(HttpStatus.NOT_FOUND)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /* =========================
       409 CONFLICT
       ========================= */

    @ExceptionHandler({
            DuplicateLocationsException.class,
            ConflictException.class,
            DataIntegrityViolationException.class
    })
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handleConflict(RuntimeException ex) {
        log.debug("409 Conflict: {}", ex.getMessage());
        return ErrorResponse.builder()
                .message(ex.getMessage())
                .reason("Condition not met.")
                .status(HttpStatus.CONFLICT)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /* =========================
       403 FORBIDDEN
       ========================= */

    @ExceptionHandler({
            NoAccessException.class,
            ForbiddenException.class
    })
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorResponse handleForbidden(RuntimeException ex) {
        return ErrorResponse.builder()
                .message(ex.getMessage())
                .reason("No access.")
                .status(HttpStatus.FORBIDDEN)
                .timestamp(LocalDateTime.now())
                .build();
    }

    /* =========================
       500 INTERNAL SERVER ERROR
       ========================= */

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleInternal(Exception ex) {
        log.error("500 Internal Server Error", ex);
        return ErrorResponse.builder()
                .message("Unexpected error")
                .reason("Internal server error.")
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .timestamp(LocalDateTime.now())
                .build();
    }
}