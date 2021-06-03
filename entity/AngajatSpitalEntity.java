package entity;

import javax.persistence.*;

@Entity
@Table(name = "AngajatSpital", schema = "FARM", catalog = "")
public class AngajatSpitalEntity {
    private int idAngajat;
    private String nume;
    private String username;
    private String parola;
    private String type;

    @Id
    @Column(name = "id_angajat")
    public int getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(int idAngajat) {
        this.idAngajat = idAngajat;
    }

    @Basic
    @Column(name = "nume")
    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "parola")
    public String getParola() {
        return parola;
    }

    public void setParola(String parola) {
        this.parola = parola;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AngajatSpitalEntity that = (AngajatSpitalEntity) o;

        if (idAngajat != that.idAngajat) return false;
        if (nume != null ? !nume.equals(that.nume) : that.nume != null) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (parola != null ? !parola.equals(that.parola) : that.parola != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAngajat;
        result = 31 * result + (nume != null ? nume.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (parola != null ? parola.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AngajatSpitalEntity{" +
                "idAngajat=" + idAngajat +
                ", nume='" + nume + '\'' +
                ", username='" + username + '\'' +
                ", parola='" + parola + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
