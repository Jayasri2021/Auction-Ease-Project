package com.ACS560.AuctionEase.controllers;

import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import com.ACS560.AuctionEase.services.AuctionUserService;
import com.fasterxml.jackson.core.JsonEncoding;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * REST controller for managing auction users.
 */
@RestController
@RequestMapping("/AuctionEase/auctionusers")
@CrossOrigin
public class AuctionUserController 
{

    @Autowired
    private AuctionUserService auctionUserService;

    /**
     * Retrieve all users.
     *
     * @return a list of all auction users
     */
    @GetMapping
    public ResponseEntity<List<AuctionUserEntity>> getAllUsers() 
    {
        return ResponseEntity.ok(auctionUserService.getAllUsers());
    }

    /**
     * Retrieve a user by username.
     *
     * @param username the username to search for
     * @return the auction user entity, if found
     */
    @GetMapping("/{username}")
    public ResponseEntity<List<AuctionUserEntity>> getUserByUsername(@PathVariable String username)
    {
       List<AuctionUserEntity> users = auctionUserService.getUserByUsername(username);
        return ResponseEntity.ok(users);
    }

    /**
     * Create or update a user.
     *
     * @param user the user entity to save
     * @return the saved user entity
     */
    @PostMapping
    public ResponseEntity<AuctionUserEntity> saveUser(@RequestBody AuctionUserEntity user)
    {
        return ResponseEntity.ok(auctionUserService.saveUser(user));
    }

    /**
     * Delete a user by username.
     *
     * @param username the username of the user to delete
     * @return a response indicating the deletion status
     */
    @DeleteMapping("/{username}")
    public ResponseEntity<Void> deleteUser(@PathVariable String username)
    {
        auctionUserService.deleteUserByUsername(username);
        return ResponseEntity.noContent().build();
    }

    /**
     * Search for users by a username filter.
     *
     * @param filter the username filter
     * @return a list of matching users
     */
    @GetMapping("/search/{username}")
    public ResponseEntity<List<AuctionUserEntity>> searchUsers(@PathVariable String filter)
    {
        return ResponseEntity.ok(auctionUserService.searchUsersByUsername(filter));
    }
    
    @PutMapping(value="/{auction_user_id}", consumes={"application/json"})
    public ResponseEntity<AuctionUserEntity> updateUser(@PathVariable long auction_user_id, @RequestBody HashMap<String,String>json)
    {
        AuctionUserEntity auctionUserToUpdate=auctionUserService.getUserByUserId(auction_user_id);
        auctionUserToUpdate.setUsername(json.get("username"));
        auctionUserToUpdate.setPassword(json.get("password"));
        auctionUserToUpdate.setEmail(json.get("email"));
        auctionUserToUpdate.setRole(json.get("role"));
        AuctionUserEntity updated=auctionUserService.updatAuctionUserById(auctionUserToUpdate);
        return updated != null ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        
    }
}
