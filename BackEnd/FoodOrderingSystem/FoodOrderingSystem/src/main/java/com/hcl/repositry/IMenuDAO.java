package com.hcl.repositry;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.model.Menu;

@Repository
public interface IMenuDAO extends JpaRepository<Menu, Integer> {
	@Query(value = "SELECT * FROM  menu  WHERE restuarant_restuarant_id=?1", nativeQuery = true)
	public List<Menu> findByRestuarant(int id);

	@Query(value = "SELECT * FROM  menu  WHERE food_name=?1", nativeQuery = true)
	public List<Menu> findByFoodName(String name);
	
	@Query(value = "SELECT * FROM  menu order by food_price", nativeQuery = true)
	public List<Menu> findByFoodPrice();
	
	@Query(value = "SELECT * FROM  menu order by food_price DESC", nativeQuery = true)
	public List<Menu> findByFoodPriceDesc();

}
