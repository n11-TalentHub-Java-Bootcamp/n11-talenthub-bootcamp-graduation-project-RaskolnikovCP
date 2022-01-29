package com.ozansaribal.n11bootcamp.graduation_project.Exception;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private Date errorDate;
    private String message;
    private String description;

    public Date getErrorDate() {
        return errorDate;
    }

    public void setErrorDate(Date errorDate) {
        this.errorDate = errorDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetail() {
        return description;
    }

    public void setDetail(String description) {
        this.description = description;
    }
}
