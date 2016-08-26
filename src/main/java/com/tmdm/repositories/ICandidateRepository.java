package com.tmdm.repositories;


import com.tmdm.entities.Candidate;
import com.tmdm.entities.Voter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICandidateRepository extends PagingAndSortingRepository<Candidate, Integer>{
    @Query("select distinct v from Voter v join v.candidates c where c.id = :id")
    public Page<Voter> findAllVotersByCandidate(@Param("id") int id, Pageable pageable);

    @Query("select distinct v from Voter v join v.candidates c where c.id = :id and v.state = :state")
    public Page<Voter> showVotersByCandidateIdAndState(@Param("id") int id, @Param("state") String state, Pageable pageable);


    @Query("select count(v) from Voter v join v.candidates c where c.id = :id and v.state = :state")
    public List<Long> findVotersCountsByCandidateIdAndState(@Param("id") int id, @Param("state") String state, Pageable pageable);



}
