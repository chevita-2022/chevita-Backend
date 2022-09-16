package kbsc.kbsc.domain.sharingtimezone.repository;

import kbsc.kbsc.domain.sharingtimezone.domain.SharingTimeZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SharingTimeZoneRepository extends JpaRepository<SharingTimeZone, Integer> {
}
