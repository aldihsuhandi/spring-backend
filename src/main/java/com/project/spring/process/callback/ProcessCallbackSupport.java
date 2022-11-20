package com.project.spring.process.callback;

import com.project.spring.common.model.context.ResultContext;
import com.project.spring.common.model.enumeration.ProcessTypeEnum;
import com.project.spring.common.model.enumeration.SpringErrorCodeEnum;
import com.project.spring.common.model.exception.SpringException;
import com.project.spring.core.model.request.BaseRequest;
import com.project.spring.core.model.result.BaseResult;

public class ProcessCallbackSupport {
    public static BaseResult process(final BaseRequest request, final ProcessTypeEnum processType, final ProcessCallback callback) {
        BaseResult result = callback.initResult();
        ResultContext resultContext = new ResultContext();

        try {
            callback.process(processType, result);

            resultContext.setSuccess(true);
            resultContext.setResultMsg("SUCCESS");
            resultContext.setResultCode("SUCCESS");
        } catch (Exception e) {
            e.printStackTrace();
            resultContext.setSuccess(false);
            resultContext.setResultMsg(SpringErrorCodeEnum.SYSTEM_BUSY.getErrorMsg());
            resultContext.setResultCode(SpringErrorCodeEnum.SYSTEM_BUSY.getErrorCode());

            if (e instanceof SpringException) {
                SpringException se = (SpringException) e;
                resultContext.setResultCode(se.getErrorCode().getErrorCode());
                resultContext.setResultMsg(se.getMessage());
            }
        }

        result.setResultContext(resultContext);

        return result;
    }
}
