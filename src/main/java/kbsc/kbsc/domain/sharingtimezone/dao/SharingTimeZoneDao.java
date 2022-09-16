package kbsc.kbsc.domain.sharingtimezone.dao;

import java.util.List;

public interface SharingTimeZoneDao {
    List<Integer> findByPostIdx(Long postIdx);
}
