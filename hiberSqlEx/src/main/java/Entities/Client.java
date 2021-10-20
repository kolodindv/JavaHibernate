package Entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table (name = "Client")
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int idClient;
    @Column(name = "firstName", length = 20)
    private String firstName;
    @Column(name = "lastName", length = 20)
    private String lastName;
    @Column(name = "telephoneNumber", length = 11)
    private String telephoneNumber;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idGroup")
    private SportGroup group;

    public Client() {}

    public Client(String firstName, String lastName, String telephoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephoneNumber = telephoneNumber;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public SportGroup getGroup() {
        return group;
    }

    public void setGroup(SportGroup group) {
        this.group = group;
    }
}
