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