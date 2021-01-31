package com.application.crater.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.crater.dtos.request.CreateCouponRequest;
import com.application.crater.dtos.response.CreateCouponResponse;
import com.application.crater.entities.Coupon;
import com.application.crater.mappers.CouponMapper;
import com.application.crater.services.CreateCouponService;

@RestController
@RequestMapping(value = "/cupom")
public class CouponResource {

	@Autowired
	private CreateCouponService createCoupon;

	@PostMapping
	public ResponseEntity<CreateCouponResponse> create(@RequestBody CreateCouponRequest request) {

		Coupon obj = CouponMapper.createEntityFromRequestDTO(request);

		obj = createCoupon.execute(obj);

		CreateCouponResponse response = CouponMapper.createResponseDTOFromEntity(obj);

		return ResponseEntity.created(null).body(response);
	}
}
