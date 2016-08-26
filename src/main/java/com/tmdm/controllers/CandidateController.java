package com.tmdm.controllers;

import com.tmdm.entities.Candidate;
import com.tmdm.entities.Voter;
import com.tmdm.services.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/candidates")
public class CandidateController {
    private CandidateService service;

    @Autowired
    public void setService(CandidateService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Candidate> index(@RequestParam(name = "page", required = false, defaultValue = "0") int page) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Candidate show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"/{id}/voters"}, method = RequestMethod.GET)
    public Page<Voter> showAllVoters(@PathVariable int id , @RequestParam(name = "page", required = false, defaultValue = "0")  int page) {
        return this.service.findAllVotersByCandidate(id, page);
    }

    @RequestMapping(path = {"/{id}/voters/{state}"}, method = RequestMethod.GET)
    public Page<Voter> showVotersByCandidateIdAndState(@PathVariable int id , @PathVariable String state, @RequestParam(name = "page", required = false, defaultValue = "0")  int page) {
        return this.service.showVotersByCandidateIdAndState(id, state, page);
    }

    @RequestMapping(path = {"/{id}/votersCount/{state}"}, method = RequestMethod.GET)
    public List<Long> findVotersCountsByCandidateIdAndState(@PathVariable int id , @PathVariable String state, @RequestParam(name = "page", required = false, defaultValue = "0")  int page) {
        return this.service.findVotersCountsByCandidateIdAndState(id, state, page);
    }

    @RequestMapping(path = {"/whoWins/{state}"}, method = RequestMethod.GET)
    public Integer findWhoWinsByState(@PathVariable String state, @RequestParam(name = "page", required = false, defaultValue = "0")  int page) {
        return this.service.findWhoWins(page);
    }
//    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
//    public Actor create(@RequestBody Actor actor) {
//        return this.service.create(actor);
//    }
//
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
//    public void destroy(@PathVariable int id) {
//        this.service.destroy(id);
//    }
//
//    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
//    public Actor update(@PathVariable int id, @RequestBody Actor actor) {
//        return this.service.update(id, actor);
//    }
}