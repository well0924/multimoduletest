package dev.be.moduleapi.ExceptionHandler;

import dev.be.moduleapi.Exception.CustomException;
import dev.be.moduleapi.response.CommonResponse;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Log4j2
@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public CommonResponse<?> handlerCustomException(CustomException e) {
        return getCommonResponse(e.getReturnCode(), e.getReturnMessage());
    }

    @ExceptionHandler(Exception.class)
    public CommonResponse<?> handleException(Exception e) {
        log.error("Unknown Exception", e);
        return getCommonResponse(CodeEnum.ERROR_CODE.getCode(),
                CodeEnum.ERROR_CODE.getMessage());
    }

    private CommonResponse<Object> getCommonResponse(String returnCode, String returnMessage) {
        return CommonResponse.builder()
                .returnCode(returnCode)
                .returnMessage(returnMessage)
                .build();
    }
}
