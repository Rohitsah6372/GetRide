package com.example.GetRide.repo;

import com.example.GetRide.models.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepo extends JpaRepository<Coupon, Integer> {
}
