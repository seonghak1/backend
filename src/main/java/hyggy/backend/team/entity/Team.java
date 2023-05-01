package hyggy.backend.team.entity;

import javax.persistence.*;

@Entity
@Table(name = "team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "leader_id")
    private int leaderId;

    @Column(name = "subject_id")
    private int subjectId;

    @Column(name = "description")
    private String description;

    @Column(name = "max_member")
    private int maxMember;


}