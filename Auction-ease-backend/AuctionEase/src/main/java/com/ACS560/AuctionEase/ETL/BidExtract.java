package com.ACS560.AuctionEase.ETL;

import java.io.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import com.ACS560.AuctionEase.entities.AuctionEntity;
import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import com.ACS560.AuctionEase.entities.BidEntity;
import com.ACS560.AuctionEase.services.AuctionService;
import com.ACS560.AuctionEase.services.AuctionUserService;
import com.ACS560.AuctionEase.services.implementations.AuctionServiceImplementation;
import com.ACS560.AuctionEase.services.implementations.AuctionUserServiceImplementation;

@Component
public class BidExtract 
{
	
	@Autowired
	private AuctionService aucServ;
	
	@Autowired
	private AuctionUserService aucUserServ;
	
    // Method to extract bid data from CSV
    public List<BidEntity> extractBidData(String fileName) throws IOException 
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
            
            AuctionEntity auctionToAdd = aucServ.getAuctionById(auctionId).get();
            AuctionUserEntity auctionUserToAdd = aucUserServ.getUserByUserId(bidderId);
            BidEntity bid = new BidEntity(bidId, auctionToAdd, auctionUserToAdd, bidAmount, bidTimestamp);
            bidDataList.add(bid);
        }
        
        reader.close();
        return bidDataList;
    }
}
