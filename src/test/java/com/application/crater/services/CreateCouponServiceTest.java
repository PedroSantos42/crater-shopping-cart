package com.application.crater.services;

import com.application.crater.entities.Coupon;
import com.application.crater.repositories.CouponRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(SpringRunner.class)
public class CreateCouponServiceTest {

    @Mock
    private CouponRepository repository;

    @InjectMocks
    private CreateCouponService createCoupon;

    private Coupon coupon;

    @Before
    public void setUp() {
        this.coupon = mockCoupon();
    }

    @Test
    public void givenCouponWithValidArgs_persistEntityInDatabase_thenReturnCreatedInstance() {
        given(repository.save(coupon)).willReturn(coupon);

        Coupon result = createCoupon.execute(coupon);

        then(repository).should(times(1)).save(coupon);
        assertNotNull(result);
    }

    private Coupon mockCoupon() {
        Coupon mockedCoupon = new Coupon();

        mockedCoupon.setId(1);
        mockedCoupon.setDiscount(15.0);
        mockedCoupon.setOccasion("ANNIVERSARY");

        return mockedCoupon;
    }
}