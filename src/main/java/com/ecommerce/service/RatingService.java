package com.ecommerce.service;

import java.util.List;

import com.ecommerce.exception.ProductException;
import com.ecommerce.model.Rating;
import com.ecommerce.model.User;

public interface RatingService {
	
	public Rating createRating(RatingRequest re,User user)throws ProductException;
	
	public List<Rating>getProductsRating(Long productId);
	
	
}
