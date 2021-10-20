package Entities;

import javax.persistence.*;
import java.util.Set;
@Entity
@Table(name = "SportGroup")
public class SportGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGroup;
    @Column(name= "nameGroup", length = 10)
    private String nameGroup;
    @Column(name = "number")
    private int number;
    @Column(name="workingDay")
    private int workingDay;
    @ManyToMany
    @JoinTable(name = "GroupByCoach", joinColumns = @JoinColumn(name = "idGroup"),
            inverseJoinColumns =@JoinColumn(name = "idCoach") )
    private Set<Coach> coaches;
    @ManyToMany
    @JoinTable(name = "HallByGroup", joinColumns = @JoinColumn(name = "idGroup"),
            inverseJoinColumns =@JoinColumn(name = "idHall") )
    private Set <Hall> halls;
    @OneToMany (mappedBy = "group")
    private Set <Client> clients;

    public SportGroup() {}
    public SportGroup(String nameGroup, int workingDay) {
        this.nameGroup = nameGroup;
        this.number = 0;
        this.workingDay = workingDay;
    }

    public int getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(int idGroup) {
        this.idGroup = idGroup;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(int workingDay) {
        this.workingDay = workingDay;
    }

    public Set<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(Set<Coach> coaches) {
        this.coaches = coaches;
    }

    public Set<Hall> getHalls() {
        return halls;
    }

    public void setHalls(Set<Hall> halls) {
        this.halls = halls;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }
}

