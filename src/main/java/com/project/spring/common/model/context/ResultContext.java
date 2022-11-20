package com.project.spring.common.model.context;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class ResultContext implements Serializable {

    private static final long serialVersionUID = 416698582951066185L;

    private String resultMsg;
    private String resultCode;
    private Boolean success;
}
