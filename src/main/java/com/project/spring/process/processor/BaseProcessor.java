package com.project.spring.process.processor;

import com.project.spring.common.model.exception.SpringException;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.result.BaseResult;

public interface BaseProcessor {
    void doProcess(final BaseResult result, final BaseRequest request) throws SpringException;
}
