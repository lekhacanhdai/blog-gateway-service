package com.blog.gateway.grpc.config;

import com.blog.account.proto.AccountServiceGrpc;
import io.grpc.Channel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@Configuration
public class AccountStubConfig {
    @Bean
    public AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub(@Qualifier("AccountGrpcChannel") Channel channel){
        return AccountServiceGrpc.newBlockingStub(channel);
    }
}
