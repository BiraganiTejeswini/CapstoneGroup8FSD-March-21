package com.hcl.repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.hcl.model.State;

@Repository
public interface IStateDAO extends JpaRepository<State, Integer> {
	@Query(value = "SELECT * FROM  state  WHERE country_country_id=?1", nativeQuery = true)
	public List<State> findByCountry(int id);
}
