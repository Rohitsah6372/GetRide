package com.example.GetRide.controllers;


import com.example.GetRide.models.Coupon;
import com.example.GetRide.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/coupon")
@RequiredArgsConstructor
public class CouponController {


    private final CouponService couponService;

    @PostMapping
    public Coupon addCoupon(@RequestParam("code") String couponCode,
                            @RequestParam("discount") int percentDis){
        return couponService.addCoupon(couponCode, percentDis);

    }

}
