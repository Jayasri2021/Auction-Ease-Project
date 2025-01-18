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

//
//import org.springframework.stereotype.Service;
//
//import com.ACS560.AuctionEase.entities.AuctionUserEntity;
//import com.ACS560.AuctionEase.models.AuctionUser;
//
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public interface AuctionUserService 
//{
//    List<AuctionUser> getAllUsers();
//
//    Optional<AuctionUser> getUserByUsername(String username);
//    
//    AuctionUser updateUser(AuctionUser updateUser);
//    
//    AuctionUser createUser(AuctionUser auctionUser);
//
//    void deleteUser(String username);
//		
//    List<AuctionUserEntity> getAuctionUserFiltered(String filter);
//}
