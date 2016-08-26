package com.tmdm.entities;

import com.tmdm.enums.Party;
import com.tmdm.enums.Position;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "candidates")
@Data
public class Candidate {
    private int id;
    private String name;
    private Position position;
    private Party party;
    private int totalVotes;
    private Date createdAt;
    private Date updatedAt;
    private int version;

    public Candidate() {
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Id
    @GeneratedValue
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @Column(name = "created_at", updatable = false)
    public Date getCreatedAt() {return createdAt;}
    public void setCreatedAt(Date createdAt) {this.createdAt = createdAt;}

    @Column(name = "updated_at", updatable = false)
    public Date getUpdatedAt() {return updatedAt;}
    public void setUpdatedAt(Date updatedAt) {this.updatedAt = updatedAt;}


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('P', 'G', 'S')")
    public Position getPosition() {return position;}
    public void setPosition(Position position) {this.position = position;}

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "ENUM('D', 'R')")
    public Party getParty() {return party;}
    public void setParty(Party party) {this.party = party;}

    @Column(name = "total_votes")
    public int getTotalVotes() {return totalVotes;}
    public void setTotalVotes(int totalVotes) {this.totalVotes = totalVotes;}

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
