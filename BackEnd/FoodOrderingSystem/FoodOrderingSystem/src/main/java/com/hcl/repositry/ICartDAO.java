package com.hcl.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.Cart;

@Repository
public interface ICartDAO extends JpaRepository<Cart, Integer> {

}
