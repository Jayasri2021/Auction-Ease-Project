package com.ACS560.AuctionEase.repositories;

import com.ACS560.AuctionEase.entities.BidEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for BidEntity.
 * Provides CRUD operations and custom query methods for bids.
 */
@Repository
public interface BidRepository extends JpaRepository<BidEntity, Long> 
{
	/**
     * Find all bids placed in all auctions.
     *
     * @param none
     * @return a list of BidEntity objects placed
     */
	List<BidEntity> findAll();
    /**
     * Find all bids placed in a specific auction.
     *
     * @param auctionId the ID of the auction
     * @return a list of BidEntity objects placed in the specified auction
     */
	List<BidEntity> findByAuction_AuctionId(Long auctionId);

    /**
     * Find all bids placed by a specific user.
     *
     * @param bidderId the ID of the bidder
     * @return a list of BidEntity objects placed by the specified user
     */
	List<BidEntity> findByBidder_AuctionUserId(Long bidderId);

    /**
     * Find the highest bid in a specific auction.
     *
     * @param auctionId the ID of the auction
     * @return the highest BidEntity in the auction
     */
    BidEntity findTopByAuction_AuctionIdOrderByBidAmountDesc(Long auctionId);
}