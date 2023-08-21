package com.blog.gateway.payload.request;

import lombok.*;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class NewAccountRequest {
    private String username;
    private String password;
}
