package com.ACS560.AuctionEase.ETL;

import java.util.*;

import com.ACS560.AuctionEase.entities.BidEntity;
import com.ACS560.AuctionEase.services.AuctionService;

public class BidTransform 
{

	private static AuctionService as;
    // Method to transform and validate bid data
    public static List<BidEntity> transformBid(List<BidEntity> BidList) 
    {
        List<BidEntity> validBids = new ArrayList<>();
        
        for (BidEntity bid : BidList) 
        {
            // Validate bid (check auction existence and current bid conditions)
            if (auctionExists(bid.getAuction().getAuctionId())) 
            {
                validBids.add(bid);
            }
        }
        return validBids;
    }

    // Simulated method to check if auction ID exists in the database
    private static boolean auctionExists(long auctionId) 
    {
        // Query the database to check if auction exists
    	return as.auctionExistsById(auctionId);
    }
}
