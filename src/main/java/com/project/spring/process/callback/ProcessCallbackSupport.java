package com.project.spring.process.callback;

import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.result.BaseResult;

public class ProcessCallbackSupport {
    public static BaseResult process(final BaseRequest request, final ProcessTypeEnum processType, final ProcessCallback callback) {
        BaseResult result = callback.initResult();

        try {
            callback.process(processType, result);

            result.setSuccess(true);
            result.setResultMsg("SUCCESS");
            result.setResultCode("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
            result.setSuccess(false);
            result.setResultMsg(SpringErrorCodeEnum.SYSTEM_BUSY.getErrorMsg());
            result.setResultCode(SpringErrorCodeEnum.SYSTEM_BUSY.getErrorCode());

            if (e instanceof SpringException) {
                SpringException se = (SpringException) e;
                result.setResultCode(se.getErrorCode().getErrorCode());
                result.setResultMsg(se.getMessage());
            }
        }

        return result;
    }
}
