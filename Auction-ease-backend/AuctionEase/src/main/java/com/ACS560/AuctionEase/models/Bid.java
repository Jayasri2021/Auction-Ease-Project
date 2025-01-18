package com.ACS560.AuctionEase.models;

import java.sql.Timestamp;

/**
 * Represents a bid placed by a user in a specific auction.
 */
public class Bid 
{

    // Unique identifier for the bid
    private Long bidId;

    // The auction associated with the bid
    private Auction auction;

    // The user who placed the bid
    private AuctionUser bidder;

    // The amount of the bid
    private double amount;

    // Timestamp when the bid was created
    private Timestamp createdAt;

    // Default constructor
    public Bid() {}

    /**
     * Parameterized constructor for creating a bid.
     *
     * @param id the unique identifier of the bid
     * @param auction the auction associated with the bid
     * @param bidder the user who placed the bid
     * @param amount the amount of the bid
     * @param createdAt the creation timestamp of the bid
     */
    public Bid(Long bidId, Auction auction, AuctionUser bidder, double amount, Timestamp createdAt)
    {
        this.bidId = bidId;
        this.auction = auction;
        this.bidder = bidder;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    // Getters and Setters

	public Long getBidId()
    {
        return bidId;
    }

    public void setBidId(Long bidId)
    {
        this.bidId = bidId;
    }

    public Auction getAuction() 
    {
        return auction;
    }

    public void setAuction(Auction auction) 
    {
        this.auction = auction;
    }

    public AuctionUser getBidder()
    {
        return bidder;
    }

    public void setBidder(AuctionUser bidder)
    {
        this.bidder = bidder;
    }

    public double getAmount() 
    {
        return amount;
    }

    public void setAmount(double amount)
    {
        this.amount = amount;
    }

    public Timestamp getCreatedAt() 
    {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) 
    {
        this.createdAt = createdAt;
    }
}
