package com.example.springdata.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String username;

    private int age;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    public void changeTeam(Team team) {
        this.team  = team;
        team.getMembers().add(this);
    }
}
