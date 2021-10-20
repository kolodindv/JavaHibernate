package Entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "KindSport")
public class KindSport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idKind;
    @Column(name = "nameKind", length = 10)
    private String nameKind;
    @ManyToMany
    @JoinTable(name = "CoachBySport", joinColumns = @JoinColumn(name = "idKind"),
            inverseJoinColumns =@JoinColumn(name = "idCoach"))
    @JsonBackReference
    private Set <Coach> coaches;
    public KindSport() {}

    public KindSport(String nameKind) {
        this.nameKind = nameKind;
    }

    public int getIdKind() { return idKind; }

    public void setIdKind(int idKind) { this.idKind = idKind; }

    public String getNameKind() { return nameKind; }

    public void setNameKind(String nameKind) {
        this.nameKind = nameKind;
    }

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }
}
