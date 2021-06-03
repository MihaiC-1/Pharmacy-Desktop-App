package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "Comanda", schema = "FARM", catalog = "")
public class ComandaEntity {
    private int idComanda;
    private String satus;
    private Timestamp dataOra;
    private Integer idAngajat;
    private Integer nrComanda;
    private Integer nrSectie;

    @Id
    @Column(name = "idComanda")
    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    @Basic
    @Column(name = "satus")
    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
    }

    @Basic
    @Column(name = "data_ora")
    public Timestamp getDataOra() {
        return dataOra;
    }

    public void setDataOra(Timestamp dataOra) {
        this.dataOra = dataOra;
    }

    @Basic
    @Column(name = "idAngajat")
    public Integer getIdAngajat() {
        return idAngajat;
    }

    public void setIdAngajat(Integer idAngajat) {
        this.idAngajat = idAngajat;
    }


    @Basic
    @Column(name = "nr_sectie")
    public Integer getNrSectie() {
        return nrSectie;
    }

    public void setNrSectie(Integer nrSectie) {
        this.nrSectie = nrSectie;
    }

    @Override
    public String toString() {
        return "ComandaEntity{" +
                "idComanda=" + idComanda +
                ", satus='" + satus + '\'' +
                ", dataOra=" + dataOra +
                ", idAngajat=" + idAngajat +
                ", nrComanda=" + nrComanda +
                ", nrSectie=" + nrSectie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComandaEntity that = (ComandaEntity) o;
        return idComanda == that.idComanda && Objects.equals(satus, that.satus) && Objects.equals(dataOra, that.dataOra) && Objects.equals(idAngajat, that.idAngajat) && Objects.equals(nrComanda, that.nrComanda) && Objects.equals(nrSectie, that.nrSectie);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComanda, satus, dataOra, idAngajat, nrComanda, nrSectie);
    }
}
