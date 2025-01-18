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

//
//import com.ACS560.AuctionEase.models.Bid;
//import com.ACS560.AuctionEase.entities.BidEntity;
//import com.ACS560.AuctionEase.repositories.BidRepository;
//import com.ACS560.AuctionEase.mappers.BidMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class BiddingService
//{
//
//    @Autowired
//    private BidRepository bidRepository;
//
//    public void placeBid(Bid bid)
//    {
//    	//check amount valid
//        // Convert Bid to BidEntity
//        BidEntity bidEntity = BidMapper.toEntity(bid);
//        // Save to database
//        bidRepository.save(bidEntity);
//        System.out.println("Bid saved: " + bidEntity);
//    }
//
//    public Bid getBid(Long id) 
//    {
//        // Fetch BidEntity from database
//        BidEntity bidEntity = bidRepository.findById(id)
//                                           .orElseThrow(() -> new RuntimeException("Bid not found"));
//        // Convert BidEntity to Bid
//        return BidMapper.toModel(bidEntity);
//    }
//}
//
