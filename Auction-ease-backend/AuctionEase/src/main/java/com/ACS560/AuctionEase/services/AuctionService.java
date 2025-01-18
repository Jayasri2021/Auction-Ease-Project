package com.ACS560.AuctionEase.services;

import com.ACS560.AuctionEase.entities.AuctionEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service interface for managing Auction entities.
 */
public interface AuctionService 
{

    List<AuctionEntity> getAllAuctions();

    Optional<AuctionEntity> getAuctionById(Long auctionId);
    
    List<AuctionEntity> getAuctionByTitle(String title);

    List<AuctionEntity> getAuctionsByStatus(boolean status);
    
    boolean auctionExistsById(Long auctionId);

    AuctionEntity saveAuction(AuctionEntity auction);

    void deleteAuctionById(Long auctionId);
    
    AuctionEntity updatAuctionById(AuctionEntity auction);
}