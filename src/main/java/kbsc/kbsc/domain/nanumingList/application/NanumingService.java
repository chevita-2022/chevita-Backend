package kbsc.kbsc.domain.nanumingList.application;

import kbsc.kbsc.domain.nanumingList.dao.NanumingDAO;
import kbsc.kbsc.domain.nanumingList.dto.NanumingDto;
import kbsc.kbsc.domain.post.application.PostService;
import kbsc.kbsc.domain.post.domain.Post;
import kbsc.kbsc.domain.reservation.application.ReservationService;
import kbsc.kbsc.domain.reservation.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NanumingService {

    private final NanumingDAO  nanumingDAO;
    private final ReservationService reservationService;
    private final PostService postService;

    public NanumingService(NanumingDAO nanumingDAO,
                           ReservationService reservationService,
                           PostService postService) {
        this.nanumingDAO = nanumingDAO;
        this.reservationService = reservationService;
        this.postService = postService;
    }

    public List<NanumingDto> getNanumings(Long userIdx) throws Exception {
        List<Reservation> reservations = reservationService.findAllReservation();
        List<NanumingDto> nanumings = new ArrayList<>();
        for (Reservation reservation: reservations) {
            if(reservation.getReserveIdx() == userIdx || reservation.getNanumiIdx() == userIdx)
            {
                NanumingDto nanuming = new NanumingDto();
                nanuming.setProfileUrl(nanumingDAO.getUserNickName(userIdx));
                nanuming.setUserNickname(nanumingDAO.getUserProfileUrl(userIdx));
                nanuming.setNanumiIdx(reservation.getNanumiIdx());
                nanuming.setTakerIdx(reservation.getTakerIdx());
                nanuming.setNanumStatus(reservation.getNanumStatus());
                nanuming.setConfirmedTimeZone(reservation.getConfirmedSharingTime());
                nanuming.setReserveIdx(reservation.getReserveIdx());

                Post post = postService.getSinglePost(reservation.getPostIdx());
                nanuming.setGlobalLocation(post.getGlobalLocation());
                nanuming.setDetailedLocation(post.getDetailedLocation());
                nanuming.setTitle(post.getTitle());
                nanuming.setPostIdx(post.getPostIdx());
                nanumings.add(nanuming);
            }

        }

        return nanumings;

    }

}
