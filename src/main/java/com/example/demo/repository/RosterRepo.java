package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Roster;

@Repository
public interface RosterRepo extends PagingAndSortingRepository<Roster, Long>, JpaSpecificationExecutor<Roster> {
	@Query("select a from Roster a where a.id.hrId = ? and a.id.startDate <= ? ")
	Roster findByHrIdAndStartDate(String hrId, Date startDate);
	
	@Query("select a from Roster a where a.id.hrId = ?1 ")
	Roster findActiveByHrId(String hrId);
	
//	@Query("select a from Roster a where a.attUid = ? and a.id.history.id = ? ")
//	Roster findByAttUidAndIdHisotryId(String attUid, long historyId);
	
//	@Query("select a from Roster a where a.attUid = ? and a.id.history.activeTime = (select max(h.activeTime) from UploadHistory h where h.type = 2 and h.dataDate<= ? and h.isRosterActivated = 1) order by a.id.history.id desc")
//	List<Roster> findByAttUid(String attUid, Date date);
	
	@Query("select distinct b from Team a join a.leaders b")
	public List<Roster> findTeamLeader();
	
	@Query("select distinct b from Team a join a.leaders b where a.id = ?")
	public List<Roster> findTeamLeader(long teamId);
	
	@Query("select max(r.id.startDate) from Roster r where r.dataScopeKey = ?")
	public Date findActiveDateBySiteKey(String dataScopeKey);
}