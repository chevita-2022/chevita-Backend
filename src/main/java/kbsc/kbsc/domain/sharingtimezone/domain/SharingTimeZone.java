package kbsc.kbsc.domain.sharingtimezone.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Table(name = "sharingTimeZone")
public class SharingTimeZone {
    @GeneratedValue
    @Id
    Long sharingTimeZoneIdx;

    Long postIdx;
    String dateZone;
    String timeZone;
}
