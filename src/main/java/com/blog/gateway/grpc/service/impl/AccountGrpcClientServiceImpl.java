package com.blog.gateway.grpc.service.impl;

import com.blog.account.proto.AccountServiceGrpc;
import com.blog.account.proto.CreateAccountResponse;
import com.blog.account.proto.ListAccountResponse;
import com.blog.gateway.grpc.service.AccountGrpcClientService;
import com.blog.gateway.payload.request.NewAccountRequest;
import com.google.protobuf.Empty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@Service
@RequiredArgsConstructor
public class AccountGrpcClientServiceImpl implements AccountGrpcClientService {

    private final AccountServiceGrpc.AccountServiceBlockingStub accountServiceBlockingStub;

    @Override
    public CreateAccountResponse createAccount(NewAccountRequest request) {
        return accountServiceBlockingStub.addNewAccount(com.blog.account.proto.NewAccountRequest.newBuilder()
                        .setUsername(request.getUsername())
                        .setPassword(request.getPassword())
                .build());
    }

    @Override
    public ListAccountResponse listAccount() {
        return accountServiceBlockingStub.listAccount(Empty.newBuilder().build());
    }
}
