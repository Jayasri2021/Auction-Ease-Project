package com.ACS560.AuctionEase.entities;

import jakarta.persistence.*;
import java.util.List;
import java.util.Set;

import com.ACS560.AuctionEase.models.Role;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "auction_users") // Maps this class to the "auction_users" table in the database
public class AuctionUserEntity 
{

    // Primary key for the auction_users table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "auction_user_id")
    private Long auctionUserId;

    // Username of the auction user
    @Column(name = "user_name")
    private String username;

    // Encrypted password of the auction user
    @Column(name = "user_password")
    private String password;

    // Email address of the auction user
    @Column(name = "email")
    private String email;

    // Role of the user, can be BUYER or SELLER
    @Column(name = "user_role")
    private String role;

    // List of auctions created by this user (as a seller)
//    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AuctionEntity> auctions;

    // List of bids placed by this user (as a bidder)S
//    @JsonManagedReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "bidder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BidEntity> bids;

    // Set of auctions that this user has attended
//    @JsonBackReference
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToMany
    @JoinTable
    (
        name = "auction_attendees",
        joinColumns = @JoinColumn(name = "auction_user_id"),
        inverseJoinColumns = @JoinColumn(name = "auction_id")
    )
    private Set<AuctionEntity> attendedAuctions;

    // Default constructor
    public AuctionUserEntity() {}

    // Parameterized constructor
    public AuctionUserEntity(String username, String password, String email, String role,
                             List<AuctionEntity> auctions, List<BidEntity> bids, Set<AuctionEntity> attendedAuctions) 
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.auctions = auctions;
        this.bids = bids;
        this.attendedAuctions = attendedAuctions;
    }

    // Getters and Setters

    public Long getAuctionUserId() 
    {
        return auctionUserId;
    }

    public void setAuctionUserId(Long auctionUserId)
    {
        this.auctionUserId = auctionUserId;
    }

    public String getUsername() 
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getRole() 
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }

    public List<AuctionEntity> getAuctions() 
    {
        return auctions;
    }

    public void setAuctions(List<AuctionEntity> auctions) {
        this.auctions = auctions;
    }

    public List<BidEntity> getBids() 
    {
        return bids;
    }

    public void setBids(List<BidEntity> bids)
    {
        this.bids = bids;
    }

    public Set<AuctionEntity> getAttendedAuctions()
    {
        return attendedAuctions;
    }

    public void setAttendedAuctions(Set<AuctionEntity> attendedAuctions) 
    {
        this.attendedAuctions = attendedAuctions;
    }
}
