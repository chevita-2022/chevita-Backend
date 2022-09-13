package kbsc.kbsc.domain.hashtag.domain;

import kbsc.kbsc.domain.post.domain.Post;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Setter
public class Hashtag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAG_ID")
    private Long tagIdx;

    private String tagName;



    @Builder
    public Hashtag(Long tagIdx, String tagName) {
        this.tagIdx = tagIdx;
        this.tagName = tagName;
    }
}
