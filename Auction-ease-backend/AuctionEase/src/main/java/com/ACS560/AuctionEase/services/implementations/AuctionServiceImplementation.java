package com.ACS560.AuctionEase.services.implementations;

import com.ACS560.AuctionEase.entities.AuctionEntity;
import com.ACS560.AuctionEase.repositories.AuctionRepository;
import com.ACS560.AuctionEase.services.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service implementation for managing Auction entities.
 */
@Service
public class AuctionServiceImplementation implements AuctionService
{

    @Autowired
    private AuctionRepository auctionRepository;

    @Override
    public List<AuctionEntity> getAllAuctions()
    {
        return auctionRepository.findAll();
    }

    @Override
    public boolean auctionExistsById(Long auctionId) 
    {
    	return auctionRepository.existsByAuctionId(auctionId);
    }
    @Override
    public Optional<AuctionEntity> getAuctionById(Long auctionId) 
    {
        return auctionRepository.findById(auctionId);
    }

    @Override
    public List<AuctionEntity> getAuctionsByStatus(boolean status) 
    {
        return auctionRepository.findByStatus(status);
    }

    @Override
    public AuctionEntity saveAuction(AuctionEntity auction)
    {
        return auctionRepository.save(auction);
    }

    @Override
    public void deleteAuctionById(Long auctionId) 
    {
        auctionRepository.deleteById(auctionId);
    }

	@Override
	public AuctionEntity updatAuctionById(AuctionEntity auction)
	{
//		deleteAuctionById(auction.getAuctionId());
		saveAuction(auction);
		return auction;
	}

	@Override
	public List<AuctionEntity> getAuctionByTitle(String title) 
	{
		return auctionRepository.findByTitleContains(title);
	}
}

//
//import com.ACS560.AuctionEase.entities.AuctionEntity;
//import com.ACS560.AuctionEase.models.Auction;
//import com.ACS560.AuctionEase.repositories.AuctionRepository;
//import com.ACS560.AuctionEase.services.AuctionService;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class AuctionServiceImplementation implements AuctionService
//{
//
//    @Autowired
//    private AuctionRepository auctionRepository;
//
//    @Override
//    public List<Auction> getAllAuctions() 
//    {
//        List<AuctionEntity> auctionEntities = auctionRepository.findAll();
//        return auctionEntities
//        		.stream()
//                .map(this::convertToModel)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<Auction> getAuctionById(Long auctionId) 
//    {
//        Optional<AuctionEntity> auctionEntity = auctionRepository.findByAuctionId(auctionId);
//        return auctionEntity.map(this::convertToModel);
//    }
//
//    @Override
//    public boolean auctionExistsById(Long auctionId) 
//    {
//        return auctionRepository.existsByAuctionId(auctionId);
//    }
//
//    @Override
//    public Auction createAuction(Auction auction) 
//    {
//        AuctionEntity auctionEntity = convertToEntity(auction);
//        AuctionEntity savedEntity = auctionRepository.save(auctionEntity);
//        return convertToModel(savedEntity);
//    }
//
//    @Override
//    public Auction updateAuction(Auction auction) 
//    {
//        AuctionEntity auctionEntity = convertToEntity(auction);
//        AuctionEntity updatedEntity = auctionRepository.save(auctionEntity);
//        return convertToModel(updatedEntity);
//    }
//
//    @Override
//    public void deleteAuction(Long auctionId)
//    {
//        auctionRepository.deleteByAuctionId(auctionId);
//    }
//
//    @Override
//    public List<Auction> getAuctionsByUsername(String username) 
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findByUsername(username);
////        return auctionEntities.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList());
//    	return null;
//    }
//
//    @Override
//    public List<Auction> getActiveAuctions() 
//    {
//        List<AuctionEntity> auctionEntities = auctionRepository.findActiveAuctions();
//        return auctionEntities.stream()
//                .map(this::convertToModel)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Auction> getAuctionsStartingAfter(Date date)
//    {
//        List<AuctionEntity> auctionEntities = auctionRepository.findByStartTimeAfter(date);
//        return auctionEntities.stream()
//                .map(this::convertToModel)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Auction> getAuctionsEndingBefore(Date date) 
//    {
//        List<AuctionEntity> auctionEntities = auctionRepository.findByEndTimeBefore(date);
//        return auctionEntities.stream()
//                .map(this::convertToModel)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public List<Auction> getAuctionsByStatus(String status)
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findByStatus(status);
////        return auctionEntities.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList());
//    	return null;
//    }
//
//    @Override
//    public List<Auction> getAuctionsWithinTimeRange(Date startTime, Date endTime) 
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findAuctionsWithinTimeRange(startTime, endTime);
////        return auctionEntities.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList());
//    	return null;
//    }
//
//    @Override
//    public long countAuctionsByUsername(String username) 
//    {
//        //return auctionRepository.countAuctionsByUsername(username);
//        return 0L;
//    }
//
//    @Override
//    public void deleteAuctionsByUsername(String username)
//    {
//        //auctionRepository.deleteByUsername(username);
//        
//    }
//
//    @Override
//    public List<Auction> getAuctionsByTitleContaining(String keyword)
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findByTitleContaining(keyword);
////        return auctionEntities.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList());
//    	return null;
//    }
//
//    @Override
//    public List<Auction> getAuctionsByMinimumBids(int minBids) 
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findAuctionsByMinimumBids(minBids);
////        return auctionEntities
////        		.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList())
//return null;
//    }
//
//    @Override
//    public List<Auction> getAuctionsActiveNow(java.time.LocalDateTime now)
//    {
////        List<AuctionEntity> auctionEntities = auctionRepository.findByStartTimeBeforeAndEndTimeAfter(now);
////        return auctionEntities
////        		.stream()
////                .map(this::convertToModel)
////                .collect(Collectors.toList());
//    	return null;
//    }
//
//    @Override
//    public List<Auction> getAuctionsByTitle(String title) 
//    {
//        List<AuctionEntity> auctionEntities = auctionRepository.findByTitleContains(title);
//        return auctionEntities
//        		.stream()
//                .map(this::convertToModel)
//                .collect(Collectors.toList());
//    }
//
//    // Convert AuctionEntity to Auction model
//    public Auction convertToModel(AuctionEntity auctionEntity) 
//    {
//        Auction auction = new Auction();
//        auction.setAuctionId(auctionEntity.getAuctionId());
//        auction.setTitle(auctionEntity.getTitle());
//        auction.setDescription(auctionEntity.getDescription());
//        auction.setStartingPrice(auctionEntity.getStartingPrice());
//        auction.setStartTime(auctionEntity.getStartTime());
//        auction.setEndTime(auctionEntity.getEndTime());
//        auction.setStatus(auctionEntity.getStatus());
//        return auction;
//    }
//
//    // Convert Auction model to AuctionEntity
//    public AuctionEntity convertToEntity(Auction auction) 
//    {
//        AuctionEntity auctionEntity = new AuctionEntity();
//        auctionEntity.setAuctionId(auction.getAuctionId());
//        auctionEntity.setTitle(auction.getTitle());
//        auctionEntity.setDescription(auction.getDescription());
//        auctionEntity.setStartingPrice(auction.getStartingPrice());
//        auctionEntity.setStartTime(auction.getStartTime());
//        auctionEntity.setEndTime(auction.getEndTime());
//        auctionEntity.setStatus(auction.getStatus());
//        return auctionEntity;
//    }
//}
