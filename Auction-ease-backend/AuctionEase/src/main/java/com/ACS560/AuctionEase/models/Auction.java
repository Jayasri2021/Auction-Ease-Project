package com.ACS560.AuctionEase.models;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents an auction for a specific item, with details such as title, description, and participants.
 */
public class Auction
{

    // Unique identifier for the auction
    private Long auctionId;

    // Title of the auction
    private String title;

    // Description of the auction item
    private String description;

    // Starting price for the auction item
    private double startingPrice;

    // Start time of the auction
    private LocalDateTime startTime;

    // End time of the auction
    private LocalDateTime endTime;

    // Status of the auction (active/inactive)
    private boolean status;

    // List of bids placed in this auction
    private List<Bid> bids;

    // Default constructor
    public Auction() {}

    /**
     * Parameterized constructor for creating an auction.
     *
     * @param id the unique identifier of the auction
     * @param title the title of the auction
     * @param description the description of the auction item
     * @param startingPrice the starting price of the auction
     * @param startTime the start time of the auction
     * @param endTime the end time of the auction
     * @param status the status of the auction
     * @param bids the list of bids placed in the auction
     */
    public Auction(Long auctionId, String title, String description, double startingPrice,
                   LocalDateTime startTime, LocalDateTime endTime, boolean status,
                   List<Bid> bids)
    {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.bids = bids;
    }

    // Getters and Setters

    public Long getAuctionId() 
    {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) 
    {
        this.auctionId = auctionId;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getStartingPrice() 
    {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice)
    {
        this.startingPrice = startingPrice;
    }

    public LocalDateTime getStartTime() 
    {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime()
    {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) 
    {
        this.endTime = endTime;
    }

    public boolean isStatus() 
    {
        return status;
    }

    public void setStatus(boolean status)
    {
        this.status = status;
    }

    public List<Bid> getBids()
    {
        return bids;
    }

    public void setBids(List<Bid> bids)
    {
        this.bids = bids;
    }
}
