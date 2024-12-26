package com.ACS560.AuctionEase.services;

import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 * Service interface for managing AuctionUser entities.
 */
@Service
public interface AuctionUserService 
{

    List<AuctionUserEntity> getAllUsers();

    List<AuctionUserEntity> getUserByUsername(String username);
    
    AuctionUserEntity getUserByUserId(Long bidderId);

    boolean userExists(String username);

    AuctionUserEntity saveUser(AuctionUserEntity user);

    void deleteUserByUsername(String username);

    List<AuctionUserEntity> searchUsersByUsername(String filter);
    
    AuctionUserEntity updatAuctionUserById(AuctionUserEntity auctionUser);
}