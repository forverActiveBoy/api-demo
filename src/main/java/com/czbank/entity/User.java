package com.czbank.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author foreverActiveBoy
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @NotNull(message = "id不能为空")
    private Long id;

    @NotBlank(message = "账号不能为空")
    private String account;

/*    @DecimalMax(value = "18",message = "分数不符合规范")
    private BigDecimal score;*/

    @Email(message = "邮箱不符合规范")
    private String email;
}
