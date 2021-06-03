package entity;

import javax.persistence.*;

@Entity
@Table(name = "Medicament", schema = "FARM", catalog = "")
public class MedicamentEntity {
    private int idMedicament;
    private String denumire;
    private Integer cantitate;
    private String sectii;

    @Id
    @Column(name = "idMedicament")
    public int getIdMedicament() {
        return idMedicament;
    }

    public void setIdMedicament(int idMedicament) {
        this.idMedicament = idMedicament;
    }

    @Basic
    @Column(name = "denumire")
    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    @Basic
    @Column(name = "cantitate")
    public Integer getCantitate() {
        return cantitate;
    }

    public void setCantitate(Integer cantitate) {
        this.cantitate = cantitate;
    }

    @Basic
    @Column(name = "sectii")
    public String getSectii() {
        return sectii;
    }

    public void setSectii(String sectii) {
        this.sectii = sectii;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicamentEntity that = (MedicamentEntity) o;

        if (idMedicament != that.idMedicament) return false;
        if (denumire != null ? !denumire.equals(that.denumire) : that.denumire != null) return false;
        if (cantitate != null ? !cantitate.equals(that.cantitate) : that.cantitate != null) return false;
        if (sectii != null ? !sectii.equals(that.sectii) : that.sectii != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMedicament;
        result = 31 * result + (denumire != null ? denumire.hashCode() : 0);
        result = 31 * result + (cantitate != null ? cantitate.hashCode() : 0);
        result = 31 * result + (sectii != null ? sectii.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "MedicamentEntity{" +
                "idMedicament=" + idMedicament +
                ", denumire='" + denumire + '\'' +
                ", cantitate=" + cantitate +
                ", sectii='" + sectii + '\'' +
                '}';
    }
}
