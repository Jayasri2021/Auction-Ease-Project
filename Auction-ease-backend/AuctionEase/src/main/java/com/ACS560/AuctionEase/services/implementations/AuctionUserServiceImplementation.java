package com.ACS560.AuctionEase.services.implementations;

import com.ACS560.AuctionEase.entities.AuctionUserEntity;
import com.ACS560.AuctionEase.repositories.AuctionUserRepository;
import com.ACS560.AuctionEase.services.AuctionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for managing AuctionUser entities.
 */
@Service
public class AuctionUserServiceImplementation implements AuctionUserService 
{

    @Autowired
    private AuctionUserRepository auctionUserRepository;

    @Override
    public List<AuctionUserEntity> getAllUsers() 
    {
        return auctionUserRepository.findAll();
    }

    @Override
    public List<AuctionUserEntity> getUserByUsername(String username)
    {
        return (List<AuctionUserEntity>) auctionUserRepository.findByUsername(username).get();
    }

    @Override
    public boolean userExists(String username) 
    {
        return auctionUserRepository.existsByUsername(username);
    }

    @Override
    public AuctionUserEntity saveUser(AuctionUserEntity user)
    {
        return auctionUserRepository.save(user);
    }

    @Override
    public void deleteUserByUsername(String username) 
    {
    	
        auctionUserRepository.delete(auctionUserRepository.findByUsername(username).get());
    }

    @Override
    public List<AuctionUserEntity> searchUsersByUsername(String filter)
    {
        return auctionUserRepository.findByUsernameContains(filter);
    }

	@Override
	public AuctionUserEntity getUserByUserId(Long bidderId)
	{
		return auctionUserRepository.findByAuctionUserId(bidderId).get();
	}

	@Override
	public AuctionUserEntity updatAuctionUserById(AuctionUserEntity auctionUser)
	{
		return auctionUserRepository.save(auctionUser);
	}
}