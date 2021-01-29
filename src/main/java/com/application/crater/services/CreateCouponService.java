package com.application.crater.services;

import com.application.crater.entities.Coupon;
import com.application.crater.repositories.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCouponService {

    @Autowired
    private CouponRepository repository;

    public Coupon execute(Coupon obj) {
        Coupon coupon = repository.save(obj);

        return coupon;
    }
}
