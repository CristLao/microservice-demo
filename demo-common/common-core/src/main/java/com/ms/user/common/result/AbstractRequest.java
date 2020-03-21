package com.ms.user.common.result;

import java.io.Serializable;

/**
 * @Description :
 * @Date ： 2020/3/21 22:16
 */
public abstract class AbstractRequest implements Serializable {

    private static final long serialVersionUID = 1717442845820713651L;

    public abstract void requestCheck();

    @Override
    public String toString() {
        return "AbstractRequest{}";
    }
}
