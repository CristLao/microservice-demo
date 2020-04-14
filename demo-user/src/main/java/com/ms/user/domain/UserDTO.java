package com.ms.user.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @author : crist
 * @Description :
 * @Date : 2020/3/21 23:11
 */
@Data
public class UserDTO {
    @NotBlank(message = "名称不能为空")
    private String name;
    private Integer number;
}
