package org.fmi.plovdiv.travelagency.dao;

import java.time.LocalDate;

import org.fmi.plovdiv.travelagency.model.Holiday;

public interface HolidayRepository extends BaseRepository<Holiday, Long> {

	boolean existsByStartDate(LocalDate startDate);
	boolean existsByDuration(Integer duration);
}
