package com.example.GetRide.controllers;


import com.example.GetRide.models.Coupon;
import com.example.GetRide.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/coupon")
public class CouponController {

    @Autowired
    CouponService couponService;

    @PostMapping
    public Coupon addCoupon(@RequestParam("code") String couponCode,
                            @RequestParam("discount") int percentDis){
        return couponService.addCoupon(couponCode, percentDis);

    }

}
