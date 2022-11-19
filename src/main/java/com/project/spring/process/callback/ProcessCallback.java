package com.project.spring.process.callback;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.core.model.result.BaseResult;

public interface ProcessCallback {
    BaseResult initResult();

    void process(ProcessTypeEnum processType, BaseResult result) throws Exception;
}
