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

//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.ACS560.AuctionEase.entities.AuctionUserEntity;
//import com.ACS560.AuctionEase.models.AuctionUser;
//import com.ACS560.AuctionEase.repositories.AuctionUserRepository;
//import com.ACS560.AuctionEase.services.AuctionUserService;
//
//@Service
//public class AuctionUserServiceImplementation implements AuctionUserService
//{
//	@Autowired
//	private AuctionServiceImplementation auctionServiceImplementation;
//	@Autowired
//    private AuctionUserRepository aur;
//	
//	@Autowired
//	public AuctionUserServiceImplementation(AuctionUserRepository aur)
//	{
//		this.aur=aur;
//	}
//	
//	@Override
//    public List<AuctionUser> getAllUsers() 
//    {
//    	return aur.findAll()
//				.stream()
//				.map(this::convertToAUModel)
//				.collect(Collectors.toList());
//    }
//	
//	@Override
//    public Optional<AuctionUser> getUserByUsername(String username) 
//    {
//        return aur.findByUsername(username)
//        		 .stream()
// 	             .findFirst()
// 	             .map(this::convertToAUModel);
//    }
//	
//	@Override
//    public AuctionUser createUser(AuctionUser auctionUser)
//    {
//    	aur.save(convertToAUEntity(auctionUser));
//    	return auctionUser;
//    }
//	
//	@Override
//    public AuctionUser updateUser(AuctionUser updateUser)
//    {
//		aur.save(convertToAUEntity(updateUser));
//            return updateUser;
//    }
//	
//	@Override
//    public void deleteUser(String username)
//    {
//        aur.deleteByUsername(username);
//    }
//	
//	//get all bids by a user
//	//get all auctions a user 
//	
//    @Override
//	public List<AuctionUserEntity> getAuctionUserFiltered(String filter)
//	{
//		return aur.findByUsernameContains(filter);
//	}	
//	
//	 private AuctionUser convertToAUModel(AuctionUserEntity entity) 
//	 {
//	        if (entity == null)
//	        	return null;
//	        return new AuctionUser
//	        	(
//	        			entity.getUsername(),
//	        			entity.getEmail(),
//	        			entity.getPassword(),
//	        			auctionServiceImplementation.convertToModel(entity.getAuction())
//	        );
//	    }
//
//	 private AuctionUserEntity convertToAUEntity(AuctionUser model)
//	 {
//	        if (model == null) 
//	        	return null;
//	        return new AuctionUserEntity
//	        		(
//	        				model.getUsername(),
//	        				model.getEmail(),
//	        				model.getPassword(),
//	        				auctionServiceImplementation.convertToEntity(model.getAuction())
//	        		);
////	    }
//}