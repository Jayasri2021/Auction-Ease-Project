package com.ACS560.AuctionEase.ETL;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.Value;

import com.ACS560.AuctionEase.entities.BidEntity;


public class BidLoad 
{

//	@Value("${spring.datasource.url}")
//    private String DB_URL;
//	@Value("${spring.datasource.username}")
//    private String USER;
//	@Value("${spring.datasource.password}")
//    private String PASSWORD;
	
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/AuctionEase";
//    private static final String USER = "root";
//    private static final String PASSWORD = "Password321";

	
	@Value("${spring.datasource.url}")
	private String DB_URL;

	@Value("${spring.datasource.username}")
	private String USER;

	@Value("${spring.datasource.password}")
	private String PASSWORD;
	
    // Method to load bid data into the MySQL database
    public void loadBidToDatabase(List<BidEntity> validBids) throws SQLException
    {
        // Establish a connection to the database
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

        // SQL query to insert a bid
        String insertQuery = "INSERT INTO bids (bid_id, auction_id, auction_user_id, bid_amount, created_at) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

        
        // Batch insert bid data
        for (BidEntity bid : validBids) 
        {
        	preparedStatement.setLong(1, bid.getBidId());
            preparedStatement.setLong(2, bid.getAuction().getAuctionId());
            preparedStatement.setLong(3, bid.getBidder().getAuctionUserId());
            preparedStatement.setDouble(4, bid.getBidAmount());
            preparedStatement.setString(5, bid.getCreatedAt().toString());
            
            //Add bid to the Auction
            bid.getAuction().getBids().add(bid);
            //Add Auction to the Bidder's profile
            bid.getBidder().getAttendedAuctions().add(bid.getAuction());
            //Add Bidder to Auction
            bid.getAuction().getAttendees().add(bid.getBidder());

            preparedStatement.addBatch();
        }

        // Execute batch insert
        preparedStatement.executeBatch();

        preparedStatement.close();
        connection.close();
    }
}
