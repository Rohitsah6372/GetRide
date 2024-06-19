package com.example.GetRide.service;


import com.example.GetRide.models.Coupon;
import com.example.GetRide.repo.CouponRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CouponService {


    @Autowired
    CouponRepo couponRepo;

    public Coupon addCoupon(String couponCode, int percentDis) {
        Coupon coupon = Coupon.builder()
                .percentageDis(percentDis)
                .CouponCode(couponCode)
                .build();

        return couponRepo.save(coupon);
    }
}
