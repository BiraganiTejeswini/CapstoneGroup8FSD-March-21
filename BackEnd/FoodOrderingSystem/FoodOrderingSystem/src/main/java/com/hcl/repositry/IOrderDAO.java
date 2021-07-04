package com.hcl.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hcl.model.OrderDetails;

@Repository
public interface IOrderDAO extends JpaRepository<OrderDetails, Integer> {

}
