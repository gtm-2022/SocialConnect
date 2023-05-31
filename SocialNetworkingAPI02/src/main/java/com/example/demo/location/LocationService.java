package com.example.demo.location;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
@Autowired
private LocationRepository locationRepository;
	
	public List<Location> getAllLocations(){
List<Location> location=new ArrayList<>();
locationRepository.findAll()
.forEach(location::add);
return location;
}
public Optional<Location> getLocation(String id) {
	 return locationRepository.findById(id);
}
public void addLocation(Location location) {
locationRepository.save(location);
}
public void updateLocation(String id, Location location) {
	locationRepository.save(location);
}
public void deleteLocation(String id) {
	locationRepository.deleteById(id);
	
}
}
