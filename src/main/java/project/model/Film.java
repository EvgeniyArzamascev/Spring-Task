package project.model;


import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Film")
public class Film {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(name = "Name")
    private String Name;

    @Column(name = "Text")
    private String Text;

    @OneToMany(mappedBy = "filmMapped", cascade = CascadeType.MERGE, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Cinema> cinemaList;


    public Film(){};

    public Film(int ID, String name, String text) {
        this.ID = ID;
        this.Name = name;
        this.Text = text;
    }

    public List<Cinema> getCinemaList() {
        return cinemaList;
    }

    public void setCinemaList(List<Cinema> cinemaList) {
        this.cinemaList = cinemaList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        this.Text = text;
    }
}
