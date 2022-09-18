package kbsc.kbsc.domain.sharingtimezone.dao.impl;

import io.swagger.models.auth.In;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.post.domain.PostResult;
import kbsc.kbsc.domain.sharingtimezone.dao.SharingTimeZoneDao;
import kbsc.kbsc.domain.sharingtimezone.domain.SharingTimeZone;
import kbsc.kbsc.domain.sharingtimezone.repository.SharingTimeZoneRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SharingTimeZoneDaoImpl implements SharingTimeZoneDao {
    //final SharingTimeZoneDao sharingTimeZoneReposioty;
    final SharingTimeZoneRepository sharingTimeZoneRepository;

    public SharingTimeZoneDaoImpl(SharingTimeZoneRepository sharingTimeZoneRepository) {
        this.sharingTimeZoneRepository = sharingTimeZoneRepository;
    }

    @Override //postIdx로
    public List<List<String>> findByPostIdx(Long postIdx) {
        List<List<String>> availableTimezone = new ArrayList<>();

        for(SharingTimeZone sharingTimeZone: sharingTimeZoneRepository.findAll()){
            if(sharingTimeZone.getPostIdx() == postIdx){
                List<String> dateTimePair = new ArrayList<>();
                dateTimePair.add(sharingTimeZone.getDateZone());
                dateTimePair.add(sharingTimeZone.getTimeZone());

                availableTimezone.add(dateTimePair);
            }
        }

        return availableTimezone;
    }

    public void saveSharingTimeZone(SharingTimeZone sharingTimeZone)throws IOException {
        sharingTimeZone.setPostIdx(sharingTimeZone.getPostIdx());
        sharingTimeZone.setDateZone(sharingTimeZone.getDateZone());
        sharingTimeZone.setTimeZone(sharingTimeZone.getTimeZone());
        sharingTimeZoneRepository.save(sharingTimeZone); //jpa가 자동으로 함
    }
}
