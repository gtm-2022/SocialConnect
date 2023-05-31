package com.example.demo.location;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.post.Post;

@Controller

public class LocationController {
	@Autowired
	LocationService ls;
//	@RequestMapping(value="/locations")
//	public String getAllLocations(Model model) {
//		List<Location> locations=ls.getAllLocations();
//		model.addAttribute("locations",locations);
//		return "locations";
//	}

	
	@GetMapping(value="/locations")
	public String getAllLocations(Model model){
	model.addAttribute("locations",ls.getAllLocations());
	return  "locations";
	}
	
@RequestMapping("location/{id}")
public Optional<Location> getLocation(@PathVariable String id) {
	return ls.getLocation(id);
}
//@PostMapping(value="/addlocations")
//public ModelAndView addLocations(Model model){
//model.addAttribute("locations",ls.getAllLocations());
//return addlocation;
//}

@GetMapping("/addlocation")
public String add(Model model){
    Post post = new Post();
    model.addAttribute("post", post);
    return "addlocation";
}


@RequestMapping(method=RequestMethod.PUT, value="/updateLocation/{id}")
public void updateLocation(@RequestBody Location location,@PathVariable String id) {
	ls.updateLocation(id, location);
}
@RequestMapping(method=RequestMethod.DELETE,value="/deleteLocation/{id}")
public void deleteLocation(@PathVariable String id) {
	ls.deleteLocation(id);
}
public ModelAndView modelAndView(String mv){
ModelAndView modv=new ModelAndView();
modv.setViewName(mv);
return modv;
}
		 
}

