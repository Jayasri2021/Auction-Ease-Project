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