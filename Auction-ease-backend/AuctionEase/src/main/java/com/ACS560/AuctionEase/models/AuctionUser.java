package com.ACS560.AuctionEase.models;

import java.util.List;
import java.util.Set;

/**
 * Represents a user participating in auctions, either as a buyer or a seller.
 */
public class AuctionUser 
{

    // Unique identifier for the user
    private Long id;

    // Username of the auction user
    private String username;

    // Email address of the user
    private String email;

    // Role of the user: BUYER or SELLER
    private Role role;

    // List of auctions created by this user
    private List<Auction> auctions;

    // List of bids placed by this user
    private List<Bid> bids;

    // Set of auctions attended by this user
    private Set<Auction> attendedAuctions;

    // Default constructor
    public AuctionUser() {}

    /**
     * Parameterized constructor for creating an auction user.
     *
     * @param id the unique identifier of the user
     * @param username the username of the user
     * @param email the email of the user
     * @param role the role of the user (BUYER or SELLER)
     * @param auctions the list of auctions created by the user
     * @param bids the list of bids placed by the user
     * @param attendedAuctions the set of auctions attended by the user
     */
    public AuctionUser(Long id, String username, String email, Role role,
                       List<Auction> auctions, List<Bid> bids, Set<Auction> attendedAuctions) 
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.role = role;
        this.auctions = auctions;
        this.bids = bids;
        this.attendedAuctions = attendedAuctions;
    }

    // Getters and Setters

    public Long getId() 
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getEmail() 
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public Role getRole() 
    {
        return role;
    }

    public void setRole(Role role) 
    {
        this.role = role;
    }

    public List<Auction> getAuctions() 
    {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) 
    {
        this.auctions = auctions;
    }

    public List<Bid> getBids()
    {
        return bids;
    }

    public void setBids(List<Bid> bids) 
    {
        this.bids = bids;
    }

    public Set<Auction> getAttendedAuctions()
    {
        return attendedAuctions;
    }

    public void setAttendedAuctions(Set<Auction> attendedAuctions)
    {
        this.attendedAuctions = attendedAuctions;
    }
}
