package com.ozansaribal.n11bootcamp.graduation_project.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MemberIdAndMemberBirthdateNotMatched extends RuntimeException {

    public MemberIdAndMemberBirthdateNotMatched(String message) {
        super(message);
    }

}
