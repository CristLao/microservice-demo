package com.ms.user.controller;

import com.ms.common.page.PageUtil;
import com.ms.common.page.PageVO;
import com.ms.common.result.ApiResponseData;
import com.ms.common.result.ResponseUtil;
import com.ms.user.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

import static com.ms.user.exception.UserException.ERROR;

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
        return ResponseUtil.ok(userDTO);
    }

    @GetMapping("/demoPage")
    public ApiResponseData<PageVO<UserDTO>> demoPage() {
        log.info("test");
        UserDTO userDTO = new UserDTO();
        userDTO.setName("crist");
        userDTO.setNumber(11);
        List<UserDTO> singleton = Collections.singletonList(userDTO);
        PageVO<UserDTO> pageVO = PageUtil.getPage(singleton, 1, 1, 1);
        return ResponseUtil.ok(pageVO);
    }


    @PostMapping("/demoException")
    public ApiResponseData<PageVO<UserDTO>> demoException(@RequestBody @Valid UserDTO userDTO) {
        log.info("test");
        List<UserDTO> singleton = Collections.singletonList(userDTO);
        if (singleton != null) {
            throw ERROR;
        }
        PageVO<UserDTO> pageVO = PageUtil.getPage(singleton, 1, 1, 1);
        return ResponseUtil.ok(pageVO);
    }
}
