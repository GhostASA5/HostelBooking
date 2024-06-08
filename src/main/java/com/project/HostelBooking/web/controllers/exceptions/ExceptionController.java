package com.project.HostelBooking.web.controllers.exceptions;

import com.project.HostelBooking.exceptions.HotelNotFoundException;
import com.project.HostelBooking.web.dto.errors.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HotelNotFoundException.class)
    public ResponseEntity<ErrorResponse> failedVerify(HotelNotFoundException ex) {
        log.error("Ошибка при попытке получить сущность отеля", ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(ex.getLocalizedMessage()));
    }
}
