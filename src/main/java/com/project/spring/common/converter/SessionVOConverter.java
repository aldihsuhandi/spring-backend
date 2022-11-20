package com.project.spring.common.converter;

import com.project.spring.common.model.viewobject.SessionVO;
import com.project.spring.dalgen.model.response.SessionDO;

public class SessionVOConverter {
    public static SessionVO toResult(SessionDO sessionDO) {
        SessionVO vo = new SessionVO();
        vo.setSessionId(sessionDO.getSessionId());
        vo.setUserId(sessionDO.getUserId());
        vo.setSessionDt(sessionDO.getSessionDt());
        vo.setActive(sessionDO.isActive());
        vo.setGmtModified(sessionDO.getGmtModified());
        vo.setGmtCreate(sessionDO.getGmtCreate());

        return vo;
    }
}
