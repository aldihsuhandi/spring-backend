/**
 * Dana.id
 * Copyright (c) 2017‐2022 All Rights Reserved.
 */
package com.project.spring.common.model.request.session;

import com.fasterxml.jackson.databind.DatabindException;
import com.project.spring.common.model.request.BaseInnerRequest;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author Aldih Suhandi (i-aldih.suhandi@dana.id)
 * @version $Id: SessionRefreshInnerRequest.java, v 0.1 2022‐11‐25 16:17 Aldih Suhandi Exp $$
 */
@Getter
@Setter
@ToString
public class SessionRefreshInnerRequest extends BaseInnerRequest {
    private String sessionId;
    private Date sessionDt;
    private Date gmtModified;
}
