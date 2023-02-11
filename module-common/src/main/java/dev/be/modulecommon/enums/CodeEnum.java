package dev.be.modulecommon.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {
    SUCCESS("00000","SUCCESS"),
    ERROR_CODE("99999","ERROR");
    private String code;
    private String message;
}
