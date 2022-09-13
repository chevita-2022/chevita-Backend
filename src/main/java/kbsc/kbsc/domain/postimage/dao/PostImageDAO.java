package kbsc.kbsc.domain.postimage.dao;

import java.util.List;

public interface PostImageDAO {

    List<String> findByPostIdx(Long postIdx);

}
