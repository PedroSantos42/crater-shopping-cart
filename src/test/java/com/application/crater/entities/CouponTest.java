package com.application.crater.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CouponTest {

	@Test
	public void givenValidArgs_createCouponObject() {
		int id = 1;
		double discount = 10.0;
		String occasion = "OCASIÃO";

		Coupon coupon = new Coupon();
		coupon = new Coupon(id, discount, occasion);

		coupon.setId(id);
		coupon.setDiscount(discount);
		coupon.setOccasion(occasion);

		assertEquals(coupon.getId(), id);
		assertEquals(coupon.getDiscount(), discount);
		assertEquals(coupon.getOccasion(), occasion);
	}
}
