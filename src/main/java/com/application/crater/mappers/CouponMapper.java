package com.application.crater.mappers;

import com.application.crater.dtos.request.CreateCouponRequest;
import com.application.crater.dtos.response.CreateCouponResponse;
import com.application.crater.entities.Coupon;

public class CouponMapper {
	public static Coupon createEntityFromRequestDTO(CreateCouponRequest dto) {
		return new Coupon(null, dto.getDiscount(), dto.getOccasion());
	}

	public static CreateCouponRequest createRequestDTOFromEntity(Coupon obj) {
		return new CreateCouponRequest(obj.getDiscount(), obj.getOccasion());
	}

	public static CreateCouponResponse createResponseDTOFromEntity(Coupon obj) {
		return new CreateCouponResponse(obj.getId(), obj.getDiscount(), obj.getOccasion());
	}
}
