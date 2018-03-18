package models;

import javax.persistence.*;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {

    private int id;
    private String name;
    private int cash;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
        this.cash = 0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name="cash")
    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public void increaseCash(int amount){
        this.cash += amount;
    }

}
