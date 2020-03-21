package com.ms.user.controller;

import com.ms.common.page.PageVO;
import com.ms.common.result.ApiResponseData;
import com.ms.user.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * @author : crist
 * @Description :
 * @Date : 2020/3/21 22:38
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {

    @GetMapping("/demo")
    public ApiResponseData<UserDTO> demo() {
        log.info("test");
        UserDTO userDTO = new UserDTO();
        userDTO.setName("crist");
        userDTO.setNumber(11);
        return ApiResponseData.<UserDTO> builder().result(userDTO).build();
    }

    @GetMapping("/demoPage")
    public ApiResponseData<PageVO<UserDTO>> demoPage() {
        log.info("test");
        UserDTO userDTO = new UserDTO();
        userDTO.setName("crist");
        userDTO.setNumber(11);
        List<UserDTO> singleton = Collections.singletonList(userDTO);
        PageVO<UserDTO> pageVO = PageVO.<UserDTO> builder().data(singleton).page(1).size(1).total(1).build();
        return ApiResponseData.<PageVO<UserDTO>> builder().result(pageVO).build();
    }
}
