package com.project.spring.common.converter;

import com.project.spring.common.model.viewobject.SessionVO;
import com.project.spring.core.model.result.session.SessionQueryResult;
import com.project.spring.dalgen.model.response.SessionDO;

public class SessionVOConverter {
    public static SessionVO toResult(SessionDO sessionDO) {
        SessionVO vo = new SessionVO();
        vo.setSessionId(sessionDO.getSessionId());
        vo.setUserId(sessionDO.getUserId());
        vo.setSessionDt(sessionDO.getSessionDt());
        vo.setActive(sessionDO.isActive());
        vo.setRemembered(sessionDO.isRemembered());
        vo.setGmtModified(sessionDO.getGmtModified());
        vo.setGmtCreate(sessionDO.getGmtCreate());

        return vo;
    }

    public static void toResult(SessionVO vo, SessionQueryResult result) {
        result.setSessionId(vo.getSessionId());
        result.setSessionDt(vo.getSessionDt());
        result.setActive(vo.isActive());
        result.setRemembered(vo.isRemembered());
        result.setGmtCreate(vo.getGmtCreate());
        result.setGmtModified(vo.getGmtModified());
    }
}
