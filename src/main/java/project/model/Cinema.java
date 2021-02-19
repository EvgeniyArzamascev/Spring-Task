package project.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Cinema")
public class Cinema {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "user_id", nullable = false)
    private User userMapped;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE, targetEntity = Film.class)
    @JoinColumn(name = "film_id", nullable = false)
    private Film filmMapped;





    public Cinema(){};

    public User getUserMapped() {
        return userMapped;
    }

    public void setUserMapped(User userMapped) {
        this.userMapped = userMapped;
    }

    public Film getFilmMapped() {
        return filmMapped;
    }

    public void setFilmMapped(Film filmMapped) {
        this.filmMapped = filmMapped;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}
