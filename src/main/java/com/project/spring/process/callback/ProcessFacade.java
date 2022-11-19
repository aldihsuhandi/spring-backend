package com.project.spring.process.callback;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.common.validator.BaseValidator;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.result.BaseResult;
import com.project.spring.process.processor.BaseProcessor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class ProcessFacade {
    @Autowired
    Map<String, BaseProcessor> processors;

    @Autowired
    Map<String, BaseValidator> validators;

    public void doProcess(final BaseRequest request, final BaseResult result, final ProcessTypeEnum processType) throws Exception {
        validators.get(processType.getValidatorName()).validate(request);

        processors.get(processType.getProcessorName()).doProcess(result, request);
    }

    public void setProcessors(Map<String, BaseProcessor> processors) {
        this.processors = processors;
    }

    public void setValidators(Map<String, BaseValidator> validators) {
        this.validators = validators;
    }
}
