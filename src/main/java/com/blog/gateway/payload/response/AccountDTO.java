package com.blog.gateway.payload.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@Getter
@Setter
@Builder
public class AccountDTO {
    private String username;
    private String password;
}
