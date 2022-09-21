package ir.bustick.entity;

import ir.bustick.entity.generator.TravelIDGen;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    private String orig;

    private String dest;

    private String date;

    private String time;

    private String travelID = TravelIDGen.generate();

    public Ticket() {
    }

    public Ticket(String orig, String dest, String date, String time) {
        this.orig = orig;
        this.dest = dest;
        this.date = date;
        this.time = time;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrig() {
        return orig;
    }

    public void setOrig(String orig) {
        this.orig = orig;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTravelID() {
        return travelID;
    }

    public void setTravelID(String travelID) {
        this.travelID = travelID;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", orig='" + orig + '\'' +
                ", dest='" + dest + '\'' +
                '}';
    }
}