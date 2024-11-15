package com.ACS560.AuctionEase.repositories;

import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for AuctionUserEntity.
 * Provides CRUD operations and custom query methods for auction users.
 */

public interface AuctionUserRepository extends CrudRepository<AuctionUserEntity, Long> {

    /**
     * Find an auction user by their username.
     *
     * @param username the username to search for
     * @return an Optional containing the found AuctionUserEntity, or empty if not found
     */
    Optional<AuctionUserEntity> findByUsername(String username);

    /**
     * Find an auction user by their email.
     *
     * @param email the email to search for
     * @return an Optional containing the found AuctionUserEntity, or empty if not found
     */
    Optional<AuctionUserEntity> findByEmail(String email);
    /**
     * Find all AuctionUserEntity objects.
     *
     * @return a list of all AuctionUserEntity objects
     */
    List<AuctionUserEntity> findAll();
    
    /**
     * Find an auction user by their email.
     *
     * @param email the email to search for
     * @return an Optional containing the found AuctionUserEntity, or empty if not found
     */
    Optional<AuctionUserEntity> findByAuctionUserId(Long userId);
    
    /**
     * Check if an AuctionUserEntity exists with the specified username.
     *
     * @param username the username to check
     * @return true if a user with the given username exists, false otherwise
     */
    boolean existsByUsername(String username);

    /**
     * Delete an AuctionUserEntity by username.
     *
     * @param username the username of the user to delete
     */
    void deleteByUsername(String username);

    /**
     * Save an AuctionUserEntity.
     * This method uses @SuppressWarnings to avoid unchecked warnings for saving entities.
     *
     * @param aue the AuctionUserEntity to save
     * @return the saved AuctionUserEntity
     */
    @SuppressWarnings("unchecked")
    AuctionUserEntity save(AuctionUserEntity aue);

    /**
     * Delete the specified AuctionUserEntity.
     *
     * @param aue the AuctionUserEntity to delete
     */
    void delete(AuctionUserEntity aue);

    /**
     * Find AuctionUserEntity objects where the username contains a specific filter.
     *
     * @param filter the string to search for within usernames
     * @return a list of AuctionUserEntity objects matching the filter
     */
    List<AuctionUserEntity> findByUsernameContains(String filter);
}