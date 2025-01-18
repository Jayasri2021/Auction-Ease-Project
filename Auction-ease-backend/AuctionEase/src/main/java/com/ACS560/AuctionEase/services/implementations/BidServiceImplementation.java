package com.ACS560.AuctionEase.services.implementations;

import com.ACS560.AuctionEase.entities.BidEntity;
import com.ACS560.AuctionEase.repositories.BidRepository;
import com.ACS560.AuctionEase.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing Bid entities.
 */
@Service
public class BidServiceImplementation implements BidService
{

    @Autowired
    private BidRepository bidRepository;
    
    @Override
    public List<BidEntity> getAllBids() 
    {
        return bidRepository.findAll();
    }
    
    @Override
    public List<BidEntity> getBidsByAuctionId(Long auctionId) 
    {
        return bidRepository.findByAuction_AuctionId(auctionId);
    }

    @Override
    public List<BidEntity> getBidsByBidderId(Long bidderId) 
    {
        return bidRepository.findByBidder_AuctionUserId(bidderId);
    }

    @Override
    public BidEntity getHighestBid(Long auctionId)
    {
        return bidRepository.findTopByAuction_AuctionIdOrderByBidAmountDesc(auctionId);
    }

    @Override
    public BidEntity saveBid(BidEntity bid) 
    {
        return bidRepository.save(bid);
    }

    @Override
    public void deleteBid(Long bidId) 
    {
        bidRepository.deleteById(bidId);
    }
}
