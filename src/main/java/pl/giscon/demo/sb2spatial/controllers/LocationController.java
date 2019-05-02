package pl.giscon.demo.sb2spatial.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.giscon.demo.sb2spatial.model.Location;
import pl.giscon.demo.sb2spatial.services.LocationService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/location")
public class LocationController {

    private final LocationService locationService;

    @GetMapping
    public List<Location> findAll() {
        return locationService.findAll();
    }

    @GetMapping(path = "/{id}")
    public Location findById(@PathVariable("id") Long id) {
        return locationService.findById(id);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        locationService.deleteById(id);
    }

    @PostMapping(path = "/{name}")
    public Location create(@PathVariable("name") String name,
                           @RequestBody String wkt) {
        return locationService.create(name, wkt);
    }

}
