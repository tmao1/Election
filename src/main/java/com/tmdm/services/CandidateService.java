package com.tmdm.services;


import com.tmdm.entities.Candidate;
import com.tmdm.entities.Voter;
import com.tmdm.helper.StateElectoralMap;
import com.tmdm.repositories.ICandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class CandidateService {
    private ICandidateRepository repository;

    @Autowired
    public void setRepository(ICandidateRepository repository) {
        this.repository = repository;
    }

    public Page<Candidate> findAll(int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAll(pr);
    }

    public Page<Voter> findAllVotersByCandidate(int id, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findAllVotersByCandidate(id, pr);
    }

    public Page<Voter> showVotersByCandidateIdAndState(int id, String state, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.showVotersByCandidateIdAndState(id, state, pr);
    }

    public List<Long> findVotersCountsByCandidateIdAndState(int id, String state, int page) {
        PageRequest pr = new PageRequest(page, 3);
        return this.repository.findVotersCountsByCandidateIdAndState(id, state, pr);
    }

    public int findWhoWins(int page) {
        PageRequest pr = new PageRequest(page, 3);
        StateElectoralMap electoralMap = new StateElectoralMap();

        int hTotal = 0;
        int tTotal = 0;

        Set set = electoralMap.getElectoralVotes().entrySet();
        Iterator i = set.iterator();

        while(i.hasNext()) {
            Map.Entry me = (Map.Entry) i.next();

            Page h = this.repository.showVotersByCandidateIdAndState(1, me.getKey().toString(), pr);
            Page t = this.repository.showVotersByCandidateIdAndState(2, me.getKey().toString(), pr);
            if ((h.getContent().size() != 0 ) && (t.getContent().size() != 0)) {
                if (h.getContent().size() > t.getContent().size()) {
                    hTotal += electoralMap.getElectoralVotes().get(me.getKey().toString());
                } else {
                    tTotal += electoralMap.getElectoralVotes().get(me.getKey().toString());
                }
            }

        }
        return hTotal - tTotal;
    }

    public Candidate findOne(int id) {
        return this.repository.findOne(id);
    }

}