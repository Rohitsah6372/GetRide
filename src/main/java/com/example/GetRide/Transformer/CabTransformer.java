package com.example.GetRide.Transformer;

import com.example.GetRide.dtos.request.CabRequest;
import com.example.GetRide.models.Cab;

public class CabTransformer {

    public static Cab cabReqToCab(CabRequest cabRequest){
        return Cab.builder()
                .cabNumber(cabRequest.getCabNumber())
                .cabType(cabRequest.getCabType())
                .farePerKm(cabRequest.getFarePerKm())
                .booked(false)
                .build();
    }

}
