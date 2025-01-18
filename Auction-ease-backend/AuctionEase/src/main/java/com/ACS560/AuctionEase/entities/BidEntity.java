package com.ACS560.AuctionEase.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * Represents a bid placed by a user in an auction.
 */
@Entity
@Table(name = "bids")
public class BidEntity 
{

    // Primary key for the bids table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long bidId;

    // Many-to-One relationship: Each bid belongs to one auction
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "auction_id") // Foreign key referencing the auctions table
    private AuctionEntity auction;

    // Many-to-One relationship: Each bid is placed by one bidder
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "auction_user_id") // Foreign key referencing the auction_users table
    private AuctionUserEntity bidder;

    // The amount of the bid
    @Column(name = "bid_amount")
    private double bidAmount;

    // Timestamp indicating when the bid was created
    @Column(name = "created_at")
    private String createdAt = LocalDateTime.now().toString();

    public BidEntity()
    {}
    
	public BidEntity(Long bidId, AuctionEntity auction, AuctionUserEntity bidder, double bidAmount, String createdAt) 
	{
		super();
		this.bidId = bidId;
		this.auction = auction;
		this.bidder = bidder;
		this.bidAmount = bidAmount;
		this.createdAt = createdAt;
		this.auction.getBids().add(this);
		this.auction.getAttendees().add(bidder);
		this.bidder.getBids().add(this);
		this.bidder.getAttendedAuctions().add(auction);
	}
	// Getters and Setters
	/**
     * Gets the bid ID.
     * 
     * @return the unique identifier of the bid
     */
    public Long getBidId()
    {
        return bidId;
    }

    /**
     * Sets the bid ID.
     * 
     * @param bidId the unique identifier to set
     */
    public void setBidId(Long bidId) 
    {
        this.bidId = bidId;
    }

    /**
     * Gets the auction associated with this bid.
     * 
     * @return the auction object
     */
    public AuctionEntity getAuction()
    {
        return auction;
    }

    /**
     * Sets the auction associated with this bid.
     * 
     * @param auction the auction object to set
     */
    public void setAuction(AuctionEntity auction)
    {
        this.auction = auction;
    }

    /**
     * Gets the bidder who placed this bid.
     * 
     * @return the bidder (user) object
     */
    public AuctionUserEntity getBidder()
    {
        return bidder;
    }

    /**
     * Sets the bidder who placed this bid.
     * 
     * @param bidder the bidder (user) object to set
     */
    public void setBidder(AuctionUserEntity bidder)
    {
        this.bidder = bidder;
    }

    /**
     * Gets the bid amount.
     * 
     * @return the amount of the bid
     */
    public double getBidAmount()
    {
        return bidAmount;
    }

    /**
     * Sets the bid amount.
     * 
     * @param bidAmount the amount to set for the bid
     */
    public void setBidAmount(double bidAmount)
    {
        this.bidAmount = bidAmount;
    }

    /**
     * Gets the creation timestamp of the bid.
     * 
     * @return the timestamp when the bid was created
     */
    public String getCreatedAt()
    {
        return createdAt;
    }

    /**
     * Sets the creation timestamp of the bid.
     * 
     * @param createdAt the timestamp to set
     */
    public void setCreatedAt(String createdAt)
    {
        this.createdAt = createdAt;
    }
}
