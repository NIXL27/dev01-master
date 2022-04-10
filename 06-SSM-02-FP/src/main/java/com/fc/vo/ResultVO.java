package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVO {
    private String massage;
    private Integer code;
    private Boolean success;
    private Object data;
}
