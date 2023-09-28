package com.cardekhorest.response;

import java.util.List;

import com.cardekhorest.pojo.CarPOJO;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarResponse {
	private String msg;
	private CarPOJO car;
	private List<CarPOJO> cars;

}
