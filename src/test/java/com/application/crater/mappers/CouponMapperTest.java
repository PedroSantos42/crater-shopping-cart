package com.application.crater.mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.application.crater.dtos.request.CreateCouponRequest;
import com.application.crater.dtos.response.CreateCouponResponse;
import com.application.crater.entities.Coupon;

@ExtendWith(SpringExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class CouponMapperTest {

	@Test
	public void givenCallToConstructor_returnCreatedInstance() {
		CouponMapper mapper = new CouponMapper();

		assertNotNull(mapper);
	}

	@Test
	public void givenRequestDTO_mapToEntity_thenReturnCreatedInstance() {
		CreateCouponRequest requestDTO = mockRequest();

		Coupon Coupon = CouponMapper.createEntityFromRequestDTO(requestDTO);

		assertEquals(requestDTO.getOccasion(), Coupon.getOccasion());
		assertEquals(requestDTO.getDiscount(), Coupon.getDiscount());
	}

	@Test
	public void givenCouponEntity_mapToRequest_thenReturnCreatedDTO() {
		Coupon Coupon = mockCoupon();

		CreateCouponRequest requestDTO = CouponMapper.createRequestDTOFromEntity(Coupon);

		assertEquals(requestDTO.getOccasion(), Coupon.getOccasion());
		assertEquals(requestDTO.getDiscount(), Coupon.getDiscount());
	}

	@Test
	public void givenCouponEntity_mapToResponse_thenReturnCreatedDTO() {
		Coupon Coupon = mockCoupon();

		CreateCouponResponse responseDTO = CouponMapper.createResponseDTOFromEntity(Coupon);

		assertEquals(responseDTO.getOccasion(), Coupon.getOccasion());
		assertEquals(responseDTO.getDiscount(), Coupon.getDiscount());
	}

	private CreateCouponRequest mockRequest() {
		CreateCouponRequest request = new CreateCouponRequest();

		request.setOccasion("Natal");
		request.setDiscount(25.0);

		return request;
	}

	private Coupon mockCoupon() {
		Coupon Coupon = new Coupon();

		Coupon.setId(null);
		Coupon.setOccasion("Natal");
		Coupon.setDiscount(25.0);

		return Coupon;
	}
}
