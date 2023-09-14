package com.blog.gateway.grpc.service;

import com.blog.account.proto.CreateAccountResponse;
import com.blog.account.proto.ListAccountResponse;
import com.blog.gateway.payload.request.NewAccountRequest;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */


public interface AccountGrpcClientService {
    CreateAccountResponse createAccount(NewAccountRequest request);

    ListAccountResponse listAccount();
}
