package com.ACS560.AuctionEase.services;

import com.ACS560.AuctionEase.entities.BidEntity;

import java.util.List;

/**
 * Service interface for managing Bid entities.
 */
public interface BidService
{

    List<BidEntity> getBidsByAuctionId(Long auctionId);

    List<BidEntity> getBidsByBidderId(Long bidderId);

    BidEntity getHighestBid(Long auctionId);

    BidEntity saveBid(BidEntity bid);

    void deleteBid(Long bidId);
    
    List<BidEntity> getAllBids();
}
