package com.ACS560.AuctionEase.services;

import com.ACS560.AuctionEase.entities.AuctionEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Auction entities.
 */
public interface AuctionService 
{

    List<AuctionEntity> getAllAuctions();

    Optional<AuctionEntity> getAuctionById(Long auctionId);
    
    List<AuctionEntity> getAuctionByTitle(String title);

    List<AuctionEntity> getAuctionsByStatus(boolean status);
    
    boolean auctionExistsById(Long auctionId);

    AuctionEntity saveAuction(AuctionEntity auction);

    void deleteAuctionById(Long auctionId);
    
    AuctionEntity updatAuctionById(AuctionEntity auction);
}



//package com.ACS560.AuctionEase.services;
//
//import com.ACS560.AuctionEase.models.Auction;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.stereotype.Service;
//
//@Service
//public interface AuctionService
//{
//    // Get all auctions
//    List<Auction> getAllAuctions();
//
//    // Get auction by ID
//    Optional<Auction> getAuctionById(Long auctionId);
//
//    // Check if auction exists by ID
//    boolean auctionExistsById(Long auctionId);
//
//    // Create a new auction
//    Auction createAuction(Auction auction);
//
//    // Update an existing auction
//    Auction updateAuction(Auction auction);
//
//    // Delete an auction by ID
//    void deleteAuction(Long auctionId);
//
//    // Get auctions by username (owner)
//    List<Auction> getAuctionsByUsername(String username);
//
//    // Get active auctions
//    List<Auction> getActiveAuctions();
//
//    // Get auctions starting after a specific date
//    List<Auction> getAuctionsStartingAfter(Date date);
//
//    // Get auctions ending before a specific date
//    List<Auction> getAuctionsEndingBefore(Date date);
//
//    // Get auctions by status (e.g., "OPEN", "CLOSED")
//    List<Auction> getAuctionsByStatus(String status);
//
//    // Get auctions within a specific time range
//    List<Auction> getAuctionsWithinTimeRange(Date startTime, Date endTime);
//
//    // Count the number of auctions by a specific username
//    long countAuctionsByUsername(String username);
//
//    // Delete all auctions by a specific username
//    void deleteAuctionsByUsername(String username);
//
//    // Find auctions by title containing a keyword (case-insensitive)
//    List<Auction> getAuctionsByTitleContaining(String keyword);
//
//    // Get auctions with a minimum number of bids
//    List<Auction> getAuctionsByMinimumBids(int minBids);
//
//    // Get auctions that are active based on current time
//    List<Auction> getAuctionsActiveNow(java.time.LocalDateTime now);
//
//    // Get auctions by title keyword
//    List<Auction> getAuctionsByTitle(String title);
//}
