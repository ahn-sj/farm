package org.tally.farm.global.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tally.farm.global.exception.ErrorCode;
import org.tally.farm.global.response.ApplicationResponse;

import java.util.HashMap;
import java.util.Map;

@Tag(name = "00. GLOBAL", description = "GLOBAL API")
@RestController
public class GlobalController {

    @GetMapping("/create")
    public ApplicationResponse<Void> create() {
        return ApplicationResponse.created().build();
    }

    @GetMapping("/success")
    public ApplicationResponse<Map<Long, String>> success() {
        final Map<Long, String> map = new HashMap<>();
        map.put(1L, "학생");
        return ApplicationResponse.success("success authenticate").data(map);
    }

    @GetMapping("/fail")
    public ApplicationResponse<Void> exception() {
        return ApplicationResponse.fail(ErrorCode.BAD_REQUEST.getErrorCode(), "잘못된 요청입니다.").build();
    }

}
