package pl.giscon.demo.sb2spatial.services;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pl.giscon.demo.sb2spatial.model.Location;
import pl.giscon.demo.sb2spatial.repositories.LocationRepository;
import pl.giscon.demo.sb2spatial.utils.ApplicationException;
import pl.giscon.demo.sb2spatial.utils.NotFoundException;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class LocationService {

    private static GeometryFactory geometryFactory = new GeometryFactory();
    private static WKTReader wktReader = new WKTReader(geometryFactory);

    private final LocationRepository locationRepository;

    private static Geometry fromWkt(String wkt) {
        try {
            return wktReader.read(wkt);
        } catch (ParseException e) {
            throw new ApplicationException("Converting from WKT to Geometry failure. WKT:" + wkt, e);
        }
    }

    public List<Location> findAll() {
        return locationRepository.findAll();
    }

    public Location findById(Long id) {
        return locationRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Location not found with ID: " + id)
        );
    }

    public Location create(String name, String wkt) {
        Location location = Location.builder()
                .name(name)
                .geometry(fromWkt(wkt))
                .build();

        locationRepository.save(location);

        log.info("location created: {}", location);

        return location;
    }

    public void deleteById(Long id) {
        locationRepository.deleteById(id);
        log.info("location deleted: {}", id);
    }

}
