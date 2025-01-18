package com.ACS560.AuctionEase.repositories;

import com.ACS560.AuctionEase.entities.AuctionEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for AuctionEntity.
 * Provides CRUD operations and custom query methods for auctions.
 */
public interface AuctionRepository extends CrudRepository<AuctionEntity, Long> 
{
	List<AuctionEntity>findAll();
	
	Optional<AuctionEntity> findByAuctionId(Long auctionId);
	
	boolean existsByAuctionId(Long auctionId);
    /**
     * Find all active auctions.
     *
     * @param status the status of the auction (true for active, false for inactive)
     * @return a list of active AuctionEntity objects
     */
    List<AuctionEntity> findByStatus(boolean status);

    /**
     * Find auctions created by a specific seller.
     *
     * @param sellerId the ID of the seller
     * @return a list of AuctionEntity objects created by the seller
     */
    List<AuctionEntity> findBySeller_AuctionUserId(Long sellerId);

	  /**
	   * Find auctions by title keyword.
	   *
	   * @param title the keyword in the title
	   * @return list of auctions
	   */
	 List<AuctionEntity> findByTitleContains(String title);
}

//import com.ACS560.AuctionEase.entities.AuctionEntity;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface AuctionRepository extends JpaRepository<AuctionEntity, Long> 
//{	
//	List<AuctionEntity> findAll();
//	
//	Optional<AuctionEntity> findByAuctionId(Long auctionId);
//    
//    boolean existsByAuctionId(Long auctionId);
//    
//    void deleteByAuctionId(Long auctionId);
//    
//    @SuppressWarnings("unchecked")
//	AuctionEntity save(AuctionEntity ae);
//    
//	void delete(AuctionEntity ae);
//	
//    /**
//     * Find all active auctions that are currently ongoing.
//     *
//     * @return list of active AuctionEntity objects
//     */
//    @Query("SELECT a FROM AuctionEntity a WHERE a.startTime <= CURRENT_TIMESTAMP AND a.endTime >= CURRENT_TIMESTAMP")
//    List<AuctionEntity> findActiveAuctions();
//
//    /**
//     * Find all auctions starting after a specific date.
//     *
//     * @param date the start date
//     * @return list of AuctionEntity objects
//     */
//    List<AuctionEntity> findByStartTimeAfter(Date date);
//
//    /**
//     * Find all auctions ending before a specific date.
//     *
//     * @param date the end date
//     * @return list of AuctionEntity objects
//     */
//    List<AuctionEntity> findByEndTimeBefore(Date date);
//
////    /**
////     * Find all auctions with a specific status.
////     *
////     * @param status the status of the auction (e.g., "OPEN", "CLOSED")
////     * @return list of AuctionEntity objects
////     */
////    List<AuctionEntity> findByStatus(String status);
////implement till here
//
//    /**
//     * Find auctions by title keyword.
//     *
//     * @param title the keyword in the title
//     * @return list of auctions
//     */
//    List<AuctionEntity> findByTitleContains(String title);
//}

