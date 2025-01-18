package com.ACS560.AuctionEase.controllers;

import com.ACS560.AuctionEase.entities.AuctionEntity;
import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import com.ACS560.AuctionEase.entities.BidEntity;
import com.ACS560.AuctionEase.repositories.AuctionRepository;
import com.ACS560.AuctionEase.repositories.AuctionUserRepository;

import com.ACS560.AuctionEase.request.BidRequest;

import com.ACS560.AuctionEase.services.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST controller for managing bids.
 */
@RestController
@RequestMapping("/Auctions/bids")
@CrossOrigin
public class BidController
{

    @Autowired
    private BidService bidService;
    @Autowired
    private AuctionRepository auctionRepository;
    @Autowired
    private AuctionUserRepository auctionUserRepository;
    
    /**
     * Retrieve all bids.
     *
     * @param none
     * @return a list of bids
     */
    @GetMapping("/auction")
    public ResponseEntity<List<BidEntity>> getAllBids() 
    {
        return ResponseEntity.ok(bidService.getAllBids());
    }
    /**
     * Retrieve all bids for a specific auction.
     *
     * @param auctionId the ID of the auction
     * @return a list of bids for the auction
     */
    @GetMapping("/auction/{auctionId}")
    public ResponseEntity<List<BidEntity>> getBidsByAuction(@PathVariable Long auctionId) 
    {
        return ResponseEntity.ok(bidService.getBidsByAuctionId(auctionId));
    }

    /**
     * Retrieve all bids placed by a specific user.
     *
     * @param bidderId the ID of the bidder
     * @return a list of bids placed by the user
     */
    @GetMapping("/user/{bidderId}")
    public ResponseEntity<List<BidEntity>> getBidsByBidder(@PathVariable Long bidderId) 
    {
        return ResponseEntity.ok(bidService.getBidsByBidderId(bidderId));
    }

    /**
     * Retrieve the highest bid for a specific auction.
     *
     * @param auctionId the ID of the auction
     * @return the highest bid entity
     */
    @GetMapping("/auction/{auctionId}/highest")
    public ResponseEntity<BidEntity> getHighestBid(@PathVariable Long auctionId) 
    {
        return ResponseEntity.ok(bidService.getHighestBid(auctionId));
    }

    /**
     * Create or update a bid.
     *
     * @param bid the bid entity to save
     * @return the saved bid entity
     */
    @PostMapping
    public ResponseEntity<BidEntity> saveBid(@RequestBody BidRequest bidRequest)
    {	
    	try
	    {
	    	AuctionEntity auction = auctionRepository.findById(bidRequest.getAuctionId())
	                .orElseThrow(() -> new RuntimeException("Auction not found"));
	        AuctionUserEntity bidder = auctionUserRepository.findById(bidRequest.getBidderId())
	                .orElseThrow(() -> new RuntimeException("Bidder not found"));
	        BidEntity bid=new BidEntity();
	        bid.setAuction(auction);
	        bid.setBidder(bidder);
	        bid.setBidAmount(bidRequest.getBidAmount());
	        bid.setCreatedAt(LocalDateTime.now().toString());
	
	        BidEntity createdBid = bidService.saveBid(bid);
	
	        // Return the created bid as the response
	        return new ResponseEntity<>(createdBid, HttpStatus.CREATED);
	    } 
	    catch (Exception e) 
	    {
	        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	    }
    }
    /**
     * Delete a bid by ID.
     *
     * @param bidId the ID of the bid to delete
     * @return a response indicating the deletion status
     */
    @DeleteMapping("/{bidId}")
    public ResponseEntity<Void> deleteBid(@PathVariable Long bidId)
    {
        bidService.deleteBid(bidId);
        return ResponseEntity.noContent().build();
    }
}