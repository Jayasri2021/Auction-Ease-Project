package com.ACS560.AuctionEase.request;

public class BidRequest 
{

    private Long auctionId;
    private Long bidderId;
    private double bidAmount;

    // Getters and setters
    public Long getAuctionId() 
    {
        return auctionId;
    }

    public void setAuctionId(Long auctionId)
    {
        this.auctionId = auctionId;
    }

    public Long getBidderId()
    {
        return bidderId;
    }

    public void setBidderId(Long bidderId)
    {
        this.bidderId = bidderId;
    }

    public double getBidAmount() 
    {
        return bidAmount;
    }

    public void setBidAmount(double bidAmount)
    {
        this.bidAmount = bidAmount;
    }
}
