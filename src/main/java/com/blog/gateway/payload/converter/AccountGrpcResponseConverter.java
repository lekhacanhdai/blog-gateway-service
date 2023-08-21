package com.blog.gateway.payload.converter;

import com.blog.account.proto.CreateAccountResponse;
import com.blog.account.proto.ListAccountResponse;
import com.blog.gateway.payload.response.AccountDTO;
import com.blog.gateway.payload.response.ListDTO;
import com.blog.gateway.payload.response.OnlyIdDTO;
import com.blog.gateway.payload.response.Response;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author dai.le-anh
 * @since 8/16/2023
 */

@Component
public class AccountGrpcResponseConverter {
    public Response<ListDTO<AccountDTO>> asSuccessResponse(ListAccountResponse.Data data){
        return Response.<ListDTO<AccountDTO>>builder()
                .success(true)
                .data(ListDTO.<AccountDTO>builder()
                        .totalElement((long) data.getAccountsCount())
                        .items(data.getAccountsList().stream().map(i -> AccountDTO.builder()
                                .username(i.getUsername())
                                .password(i.getPassword())
                                .build())
                                .collect(Collectors.toList()))
                        .build())
                .build();
    }

    public Response<OnlyIdDTO> asSuccessResponse(CreateAccountResponse.Data data) {
        return Response.<OnlyIdDTO>builder()
                .success(true)
                .data(OnlyIdDTO.builder()
                        .id(data.getId())
                        .build())
                .build();
    }
}
