package kbsc.kbsc.domain.sharingtimezone.dao;

import java.util.List;

public interface SharingTimeZoneDao {
    List<List<String>> findByPostIdx(Long postIdx);
}
