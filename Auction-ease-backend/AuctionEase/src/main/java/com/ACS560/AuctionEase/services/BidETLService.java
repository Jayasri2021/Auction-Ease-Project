package com.ACS560.AuctionEase.services;

import java.util.List;

import com.ACS560.AuctionEase.models.Bid;

public interface BidETLService
{
    void processBidDataFromCSV(String filePath);
    List<Bid> extractBidData(String filePath);
    List<Bid> transformBidData(List<Bid> bidDataList);
    void loadBidDataToDatabase(List<Bid> validBids);
}
