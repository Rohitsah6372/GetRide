package com.example.GetRide.Transformer;

import com.example.GetRide.dtos.request.CoustomerRequest;
import com.example.GetRide.dtos.request.response.CoustomerResponse;
import com.example.GetRide.models.Coustomer;

public class CoustomerTransformer {

    public static Coustomer coustomerRequestToCoustomer(CoustomerRequest coustomerRequest){
        return Coustomer.builder()
                .Name(coustomerRequest.getName())
                .age(coustomerRequest.getAge())
                .emailId(coustomerRequest.getEmailId())
                .gender(coustomerRequest.getGender())
                .build();
    }

    public static CoustomerResponse coustomerToCoustomerResponse(Coustomer coustomer){
        return CoustomerResponse.builder()
                .emailId(coustomer.getEmailId())
                .name(coustomer.getName())
                .gender(coustomer.getGender())
                .build();
    }

}
