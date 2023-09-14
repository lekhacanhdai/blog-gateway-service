package com.blog.gateway.controller;

import com.blog.gateway.grpc.service.AccountGrpcClientService;
import com.blog.gateway.payload.converter.AccountGrpcResponseConverter;
import com.blog.gateway.payload.request.NewAccountRequest;
import com.blog.gateway.payload.response.AccountDTO;
import com.blog.gateway.payload.response.ListDTO;
import com.blog.gateway.payload.response.OnlyIdDTO;
import com.blog.gateway.payload.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountGrpcClientService accountGrpcClientService;
    private final AccountGrpcResponseConverter accountGrpcResponseConverter;

    @GetMapping("accounts")
    public Response<ListDTO<AccountDTO>> listAccounts(){
        var grpcRes = accountGrpcClientService.listAccount();

        if (grpcRes.getSuccess()){
            return accountGrpcResponseConverter.asSuccessResponse(grpcRes.getData());
        }
        return Response.<ListDTO<AccountDTO>>builder()
                .success(false)
                .build();
    }

    @PostMapping("accounts")
    public Response<OnlyIdDTO> createAccount(@RequestBody NewAccountRequest request){
        var grpcRes = accountGrpcClientService.createAccount(request);
        if (grpcRes.getSuccess()){
            return accountGrpcResponseConverter.asSuccessResponse(grpcRes.getData());
        }
        return Response.<OnlyIdDTO>builder()
                .success(false)
                .build();
    }
}
