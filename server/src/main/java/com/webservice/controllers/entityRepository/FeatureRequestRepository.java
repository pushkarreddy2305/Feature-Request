package com.webservice.controllers.entityRepository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webservice.entities.FeatureRequest;


@Repository
@Transactional
public interface FeatureRequestRepository extends JpaRepository<FeatureRequest,String> {	
	@Query("SELECT f from FeatureRequest f where f.client =:client ")
    List<FeatureRequest> findAllRequestsByClient(@Param("client") String client);
	
	@Query("SELECT f from FeatureRequest f")
    List<FeatureRequest> findAllRequests();
	
	@Query("SELECT f from FeatureRequest f where f.id =:id ")
    FeatureRequest findAllRequestsById(@Param("id") Long id);
	
	@Modifying
	@Query("update FeatureRequest f set f.clientPriority = :value where f.id = :id")
	void updateClientPriorityById(@Param("id") Long id, @Param("value") int value);
	
	@Modifying
	@Query("update FeatureRequest f set f.clientPriority = :clientPriority,f.title = :title,f.description = :description, f.client = :client, f.targetDate = :targetDate , f.productArea = :productArea  where f.id = :id")
	void updateFeatureRequest(@Param("id") Long id, @Param("clientPriority") int clientPriority,
			@Param("title") String title, @Param("description") String description, 
			@Param("client") String client, @Param("targetDate") String targetDate,
			@Param("productArea") String productArea);
	
	@Modifying
	@Query("delete from FeatureRequest f where f.id = :id")
	void deleteFeatureRequestById(@Param("id") Long id);
}
