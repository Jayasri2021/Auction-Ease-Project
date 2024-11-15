package com.ACS560.AuctionEase.controllers;

import com.ACS560.AuctionEase.ETL.BidExtract;
import com.ACS560.AuctionEase.ETL.BidLoad;
import com.ACS560.AuctionEase.entities.AuctionEntity;
import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import com.ACS560.AuctionEase.entities.BidEntity;
import com.ACS560.AuctionEase.services.AuctionService;
import com.ACS560.AuctionEase.services.AuctionUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing auctions.
 */
@RestController
@RequestMapping("/AuctionEase/auctions")
@CrossOrigin
public class AuctionController 
{

    @Autowired
    private AuctionService auctionService;
    
    @Autowired
    private AuctionUserService auctionUserService;

    /**
     * Retrieve all auctions.
     *
     * @return a list of all auctions
     */
    @GetMapping
    public ResponseEntity<List<AuctionEntity>> getAllAuctions()
    {
        return ResponseEntity.ok(auctionService.getAllAuctions());
    }

    /**
     * Retrieve an auction by title.
     *
     * @param auctionId the ID of the auction to retrieve
     * @return the auction entity, if found
     */
    @GetMapping("/title/{title}")
    public ResponseEntity<List<AuctionEntity>> getAuctionByTitle(@PathVariable String title) 
    {
    	List<AuctionEntity> auction = auctionService.getAuctionByTitle(title);
        return ResponseEntity.ok(auction);
    }
    /**
     * Retrieve an auction by ID.
     *
     * @param auctionId the ID of the auction to retrieve
     * @return the auction entity, if found
     */
    @GetMapping("/{auctionId}")
    public ResponseEntity<AuctionEntity> getAuctionById(@PathVariable Long auctionId) 
    {
        Optional<AuctionEntity> auction = auctionService.getAuctionById(auctionId);
        return auction.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Retrieve all active or inactive auctions based on status.
     *
     * @param status true for active auctions, false for inactive
     * @return a list of matching auctions
     */
    @GetMapping("/status")
    public ResponseEntity<List<AuctionEntity>> getAuctionsByStatus(@RequestParam boolean status)
    {
        return ResponseEntity.ok(auctionService.getAuctionsByStatus(status));
    }

    /**
     * Create or update an auction.
     *
     * @param auction the auction entity to save
     * @return the saved auction entity
     */
    @PostMapping(consumes={"application/json"})
    public ResponseEntity<AuctionEntity> saveAuction(@RequestBody AuctionEntity auction)
    {
        return ResponseEntity.ok(auctionService.saveAuction(auction));
    }

    /**
     * Delete an auction by ID.
     *
     * @param auctionId the ID of the auction to delete
     * @return a response indicating the deletion status
     */
    @DeleteMapping("/{auctionId}")
    public ResponseEntity<Void> deleteAuction(@PathVariable Long auctionId)
    {
        auctionService.deleteAuctionById(auctionId);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/etl")
    public ResponseEntity<List<BidEntity>> performETL() 
    {	
    	try 
    	{
			List<BidEntity> loadedBids = extractBidData("bids.csv");
			if(loadedBids.isEmpty()) 
			{
				return  ResponseEntity.badRequest().build();
			}
			try {
				BidLoad loadBids = new BidLoad();
				loadBids.loadBidToDatabase(loadedBids);
				return ResponseEntity.ok(loadedBids);
			}
			catch (Exception e) {
				return ResponseEntity.ok(loadedBids);
			}
	
			
		} 
    	catch (IOException e) 
    	{
			return  ResponseEntity.internalServerError().build();
    	}
	}
    
    private List<BidEntity> extractBidData(String fileName) throws IOException 
    {
        List<BidEntity> bidDataList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        
        // Skip header line
        reader.readLine();
        
        // Read each line and map to BidData object
        while ((line = reader.readLine()) != null) 
        {
            String[] fields = line.split(",");
            long bidId=Long.parseLong(fields[0].trim());
            long auctionId = Integer.parseInt(fields[1].trim());
            long bidderId = Integer.parseInt(fields[2].trim());
            double bidAmount = Double.parseDouble(fields[3].trim());
            String bidTimestamp = fields[4].trim();
            
            AuctionEntity auctionToAdd = auctionService.getAuctionById(auctionId).get();
            AuctionUserEntity auctionUserToAdd = auctionUserService.getUserByUserId(bidderId);
            BidEntity bid = new BidEntity(bidId, auctionToAdd, auctionUserToAdd, bidAmount, bidTimestamp);
            bidDataList.add(bid);
        }
        
        reader.close();
        return bidDataList;
    }
    
    @PutMapping("/{auction_id}")
    public ResponseEntity<AuctionEntity> updateAuction(@PathVariable long auction_id, @RequestBody HashMap<String, String> json)
    {
    	AuctionEntity auctionToUpdate = auctionService.getAuctionById(auction_id).get();
    	auctionToUpdate.setTitle(json.get("title"));
    	auctionToUpdate.setDescription(json.get("description"));
    	auctionToUpdate.setStatus(Boolean.valueOf(json.get("status")).booleanValue());
    	AuctionEntity updated= auctionService.updatAuctionById(auctionToUpdate);
    	return updated != null ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
