package com.example.booking.service;
 
import com.example.booking.service.TravelPackageService;
import com.example.booking.entity.TravelPackage;
import com.example.booking.repository.TravelPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
 
@Service
public class TravelPackageService {
    @Autowired
    private TravelPackageRepository packageRepo;
 
    public List<TravelPackage> searchByDestination(String destination) {
        return packageRepo.findByDestination(destination);
    }
    public List<TravelPackage> searchByCountry(String country) {
        return packageRepo.findByCountryContainingIgnoreCase(country);
    }
    public List<TravelPackage> searchByOffer(String offer) {
        return packageRepo.findByOfferContainingIgnoreCase(offer);
    }
 
    public List<TravelPackage> searchByDateRange(LocalDate from, LocalDate to) {
        return packageRepo.findByStartDateLessThanEqualAndEndDateGreaterThanEqual(from, to);
    }
 
    public TravelPackage savePackage(TravelPackage travelPackage) {
        return packageRepo.save(travelPackage);
    }
    
    public void savePackages(List<TravelPackage> travelPackages) {
    	for(TravelPackage tp:travelPackages)
		{
    		packageRepo.save(tp);
		}
    }
}
