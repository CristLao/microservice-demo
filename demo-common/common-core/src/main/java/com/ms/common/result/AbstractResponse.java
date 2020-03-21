package com.ms.common.result;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author : crist
 * @Description :
 * @Date ： 2020/3/21 22:18
 */
@Getter
@Setter
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = 7505997295595095971L;
    private String code;
    private String msg;
}
