package com.project.spring.core.validator;

import com.project.spring.core.model.request.BaseRequest;

public interface BaseValidator {
    void validate(BaseRequest request) throws Exception;
}
