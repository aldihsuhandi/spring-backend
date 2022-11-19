package com.project.spring.core.model.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class BaseResult implements Serializable {

    private static final long serialVersionUID = 6556129195307610223L;

    private String resultMsg;
    private String resultCode;
    private Boolean success;

}
