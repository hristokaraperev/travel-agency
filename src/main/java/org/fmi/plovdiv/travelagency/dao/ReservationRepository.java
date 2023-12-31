package org.fmi.plovdiv.travelagency.dao;

import org.fmi.plovdiv.travelagency.model.Holiday;
import org.fmi.plovdiv.travelagency.model.Reservation;

public interface ReservationRepository extends BaseRepository<Reservation, Long> {

	Integer countByHoliday(Holiday holiday);
}
