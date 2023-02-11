package dev.be.moduleapi.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import dev.be.modulecommon.enums.CodeEnum;
import lombok.*;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CommonResponse<T> {
    private String returnCode;
    private String returnMessage;

    private T info;

    public CommonResponse(CodeEnum codeEnum) {
        this(codeEnum, null);
    }

    public CommonResponse(T info) {
        this(CodeEnum.SUCCESS, info);
    }

    public CommonResponse(CodeEnum codeEnum, T info) {
        setReturnCode(codeEnum);
        setInfo(info);
    }

    public void setReturnCode(CodeEnum codeEnum) {
        this.returnCode = codeEnum.getCode();
        this.returnMessage = codeEnum.getMessage();
    }

    public static CommonResponse success() {
        return builder()
                .returnCode(CodeEnum.SUCCESS.getCode())
                .returnMessage(CodeEnum.SUCCESS.getMessage())
                .build();
    }
}
