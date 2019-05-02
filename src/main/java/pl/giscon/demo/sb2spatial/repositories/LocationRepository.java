package pl.giscon.demo.sb2spatial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.giscon.demo.sb2spatial.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
