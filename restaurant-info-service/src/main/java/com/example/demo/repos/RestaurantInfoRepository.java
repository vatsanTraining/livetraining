package com.example.demo.repos;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RestaurantInfo;

@Repository
public interface RestaurantInfoRepository extends JpaRepository<RestaurantInfo, Integer> {

	public RestaurantInfo findByName(String srchName);
	
	@Query("update RestaurantInfo set openingHours=:newValue where id=:srchId")
	@Modifying
	@Transactional
	public int updateOpeningHours(@Param("srchId") int id,@Param("newValue") String valueToChange);
	
	
}
