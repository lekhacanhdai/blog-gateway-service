package com.blog.gateway.grpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@Configuration
@RequiredArgsConstructor
public class GrpcChannelConfig {
    private final Environment environment;

    @Bean("AccountGrpcChannel")
    public ManagedChannel studentChannel(){
        var messageSize = environment.getRequiredProperty("blog.grpc.client.account.message.size", Integer.class);

        return ManagedChannelBuilder.forAddress(
                environment.getRequiredProperty("blog.grpc.client.account.host"),
                environment.getRequiredProperty("blog.grpc.client.account.port", Integer.class)
        )
                .usePlaintext()
                .maxInboundMessageSize(messageSize * 1024 * 1024)
                .build();
    }
}
