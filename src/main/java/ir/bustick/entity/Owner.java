package ir.bustick.entity;

import ir.bustick.entity.enumeration.Gender;
import jakarta.persistence.*;

@Entity
public class Owner {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Gender gender;

    @OneToOne
    private Ticket ticket;

    @ManyToOne
    private User user;

    public Owner() {
    }

    public Owner(String name, Gender gender,User user) {
        this.name = name;
        this.gender = gender;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Ticket getTicket() {
        if(ticket == null)
            ticket = new Ticket();
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", ticket=" + ticket +
                ", user=" + user +
                '}';
    }
}