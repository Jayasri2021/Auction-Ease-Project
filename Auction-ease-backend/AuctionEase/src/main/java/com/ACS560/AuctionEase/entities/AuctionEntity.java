package com.ACS560.AuctionEase.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "auctions")
public class AuctionEntity 
{

    // Primary key for the auction table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_id")
    private Long auctionId;

    // Title of the auction
    @Column(name = "title")
    private String title;

    // Description of the auction item or event
    @Column(name = "item_description")
    private String description;

    // Starting price of the auction item
    @Column(name = "startingprice")
    private double startingPrice;

    // Timestamp when the auction starts
    @Column(name = "starttime")
    private LocalDateTime startTime;

    // Timestamp when the auction ends
    @Column(name = "endtime")
    private LocalDateTime endTime;

    // Status of the auction (e.g., active or inactive)
    @Column(name = "auction_status")
    private boolean status;

    // List of attendees (users) associated with this auction
    @ManyToMany(mappedBy = "attendedAuctions")
    private Set<AuctionUserEntity> attendees;
    
    // Many-to-One relationship with AuctionUserEntity (seller)
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne
    @JoinColumn(name = "auction_user_id")
    private AuctionUserEntity seller;

    // List of bids associated with this auction
    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "auction", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BidEntity> bids = new ArrayList<>();

    // Default constructor
    public AuctionEntity() {}

    // Parameterized constructor to initialize auction attributes
    public AuctionEntity(Long auctionId, String title, String description, double startingPrice,
                         LocalDateTime startTime, LocalDateTime endTime, boolean status, 
                         AuctionUserEntity seller)
    {
        this.auctionId = auctionId;
        this.title = title;
        this.description = description;
        this.startingPrice = startingPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.seller = seller;
        this.attendees.add(seller);
    }

    // Getter for the list of bids associated with this auction
    public List<BidEntity> getBids() 
    {
        return bids;
    }

    // Setter for the list of bids
    public void setBids(List<BidEntity> bids)
    {
        this.bids = bids;
    }

    // Getter for the list of attendees associated with this auction
    public Set<AuctionUserEntity> getAttendees()
    {
        return attendees;
    }

    // Setter for the list of attendees
    public void setAttendees(Set<AuctionUserEntity> attendees) 
    {
        this.attendees = attendees;
    }

    // Getter for the auction ID
    public Long getAuctionId() 
    {
        return auctionId;
    }

    // Setter for the auction ID
    public void setAuctionId(Long auctionId) 
    {
        this.auctionId = auctionId;
    }

    // Getter for the auction title
    public String getTitle()
    {
        return title;
    }

    // Setter for the auction title
    public void setTitle(String title) 
    {
        this.title = title;
    }

    // Getter for the auction description
    public String getDescription() 
    {
        return description;
    }

    // Setter for the auction description
    public void setDescription(String description)
    {
        this.description = description;
    }

    // Getter for the starting price of the auction
    public double getStartingPrice()
    {
        return startingPrice;
    }

    // Setter for the starting price of the auction
    public void setStartingPrice(double startingPrice)
    {
        this.startingPrice = startingPrice;
    }

    // Getter for the auction start time
    public LocalDateTime getStartTime() 
    {
        return startTime;
    }

    // Setter for the auction start time
    public void setStartTime(LocalDateTime startTime)
    {
        this.startTime = startTime;
    }

    // Getter for the auction end time
    public LocalDateTime getEndTime()
    {
        return endTime;
    }

    // Setter for the auction end time
    public void setEndTime(LocalDateTime endTime) 
    {
        this.endTime = endTime;
    }

    // Getter for the auction status (active/inactive)
    public boolean getStatus()
    {
        return status;
    }

    // Setter for the auction status
    public void setStatus(boolean status)
    {
        this.status = status;
    }
    
    public AuctionUserEntity getSeller()
    {
        return seller;
    }

    public void setSeller(AuctionUserEntity seller)
    {
        this.seller = seller;
    }
}
