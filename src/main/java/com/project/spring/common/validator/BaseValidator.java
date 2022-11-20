package com.project.spring.common.validator;

import com.project.spring.core.model.request.BaseRequest;

public interface BaseValidator {
    void validate(BaseRequest request) throws Exception;
}
