package entity;

import javax.persistence.*;

@Entity
@Table(name = "ContinutComanda", schema = "FARM", catalog = "")
public class ContinutComandaEntity {
    private int idContinut;
    private Integer idComanda;
    private Integer idMedicament;
    private Integer cantitate;

    @Id
    @Column(name = "idContinut")
    public int getIdContinut() {
        return idContinut;
    }

    public void setIdContinut(int idContinut) {
        this.idContinut = idContinut;
    }

    @Basic
    @Column(name = "idComanda")
    public Integer getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(Integer idComanda) {
        this.idComanda = idComanda;
    }

    @Basic
    @Column(name = "idMedicament")
    public Integer getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(Integer idMedicament) {
        this.idMedicament = idMedicament;
    }

    @Basic
    @Column(name = "cantitate")
    public Integer getCantitate() {
        return cantitate;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContinutComandaEntity that = (ContinutComandaEntity) o;

        if (idContinut != that.idContinut) return false;
        if (idComanda != null ? !idComanda.equals(that.idComanda) : that.idComanda != null) return false;
        if (idMedicament != null ? !idMedicament.equals(that.idMedicament) : that.idMedicament != null) return false;
        if (cantitate != null ? !cantitate.equals(that.cantitate) : that.cantitate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idContinut;
        result = 31 * result + (idComanda != null ? idComanda.hashCode() : 0);
        result = 31 * result + (idMedicament != null ? idMedicament.hashCode() : 0);
        result = 31 * result + (cantitate != null ? cantitate.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContinutComandaEntity{" +
                "idContinut=" + idContinut +
                ", idComanda=" + idComanda +
                ", idMedicament=" + idMedicament +
                ", cantitate=" + cantitate +
                '}';
    }
}
