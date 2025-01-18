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

//
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import com.ACS560.AuctionEase.entities.BidEntity;
//
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface BidRepository extends JpaRepository<BidEntity, Long> 
//{ 
//	List<BidEntity> findAll();
//	
//	BidEntity saveBid(BidEntity ae);
//	
//	void deleteBid(BidEntity ae);
//	
//	/**
//     * Find all bids for a specific user and auction.
//     *
//     * @param username  the username of the bidder
//     * @param auctionId the ID of the auction
//     * @return a list of BidEntity objects
//     */
//    List<BidEntity> findAllByUsernameAndAuctionId(String username, String auctionId);
//	
//	List<BidEntity> findByTitleContains(String filter);
//
//	
//	
//    /**
//     * Find all bids for a specific auction.
//     *
//     * @param auctionId the ID of the auction
//     * @return a list of BidEntity objects
//     */
//    List<BidEntity> findByAuctionId(String auctionId);
////
////    /**
////     * Find the highest bid for a specific auction.
////     *
////     * @param auctionId the ID of the auction
////     * @return the highest bid as a BidEntity
////     */
////    @Query("SELECT b FROM BidEntity b WHERE b.auctionId = :auctionId ORDER BY b.bidAmount DESC LIMIT 1")
////    Optional<BidEntity> findHighestBidForAuction(String auctionId);
//
//    /**
//     * Find all bids placed by a specific user.
//     *
//     * @param userId the ID of the user
//     * @return a list of BidEntity objects
//     */
//    List<BidEntity> findByUsername(String username);
//
////    /**
////     * Find bids within a specific bid amount range for an auction.
////     *
////     * @param auctionId the ID of the auction
////     * @param minAmount the minimum bid amount
////     * @param maxAmount the maximum bid amount
////     * @return a list of BidEntity objects
////     */
////    @Query("SELECT b FROM BidEntity b WHERE b.auctionId = :auctionId AND b.bidAmount BETWEEN :minAmount AND :maxAmount")
////    List<BidEntity> findBidsByAmountRange(String auctionId, double minAmount, double maxAmount);
////
////    /**
////     * Count the number of bids placed in a specific auction.
////     *
////     * @param auctionId the ID of the auction
////     * @return the count of bids
////     */
////    @Query("SELECT COUNT(b) FROM BidEntity b WHERE b.auctionId = :auctionId")
////    long countBidsInAuction(String auctionId);
//
////    /**
////     * Delete all bids for a specific auction.
////     *
////     * @param auctionId the ID of the auction
////     */
////    void deleteByAuctionId(String auctionId);
//}
//
