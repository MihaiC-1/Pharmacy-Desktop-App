package Domain;

import javax.persistence.*;

import entity.ComandaEntity;
import entity.MedicamentEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MedicamenteRepository {

    MedicamenteRepository() { }

    public MedicamentEntity getMedById(int idMedicament) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        MedicamentEntity medicament = new MedicamentEntity();
        medicament.setDenumire("");
        medicament.setCantitate(0);
        medicament.setSectii("");

        try {
            transaction.begin();

            TypedQuery<MedicamentEntity> MedById = entityManager.createQuery("select m from MedicamentEntity m where m.idMedicament=:idMedicament", MedicamentEntity.class);
            MedById.setParameter("idMedicament", idMedicament);

            for (MedicamentEntity med : MedById.getResultList()) {
                if (med.getIdMedicament() == idMedicament) {
                    medicament.setIdMedicament(med.getIdMedicament());
                    medicament.setDenumire(med.getDenumire());
                    medicament.setCantitate(med.getCantitate());
                    medicament.setSectii(med.getSectii());
                }
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return medicament;
    }

    public ArrayList<MedicamentEntity> getMedicamente() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ArrayList<MedicamentEntity> meds = new ArrayList<MedicamentEntity>();

        try {
            transaction.begin();

            TypedQuery<MedicamentEntity> MedById = entityManager.createQuery("select m from MedicamentEntity m", MedicamentEntity.class);

            for (MedicamentEntity med : MedById.getResultList()) {
                meds.add(med);
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return meds;
    }

    public int getIdMedByDenumire(String denumire) {
        int idmed = 0;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<MedicamentEntity> MedById = entityManager.createQuery("select m from MedicamentEntity m where m.denumire = :denumire", MedicamentEntity.class);
            MedById.setParameter("denumire", denumire);

            for (MedicamentEntity med : MedById.getResultList()) {
                if (med.getDenumire().equals(denumire)) {
                    idmed = med.getIdMedicament();
                }
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return idmed;
    }

    public void updateMed(String denumire, String denumire_noua, int cant, String sectii) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<MedicamentEntity> MedById = entityManager.createQuery("select m from MedicamentEntity m where m.denumire = :denumire", MedicamentEntity.class);
            MedById.setParameter("denumire", denumire);

            for (MedicamentEntity med : MedById.getResultList()) {
                if (cant != 0) {
                    med.setCantitate(cant);
                }
                if (!(denumire_noua.equals(""))) {
                    med.setDenumire(denumire_noua);
                }
                if (!(sectii.equals(""))) {
                    med.setSectii(sectii);
                }
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void updateCantitateMed(String denumire, int cant) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<MedicamentEntity> MedById = entityManager.createQuery("select m from MedicamentEntity m where m.denumire = :denumire", MedicamentEntity.class);
            MedById.setParameter("denumire", denumire);

            for (MedicamentEntity med : MedById.getResultList()) {
                int cantitate = med.getCantitate() - cant;
                med.setCantitate(cantitate);
            }

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void deleteMed(int idMed) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.flush();
            entityManager.clear();

            MedicamentEntity med = entityManager.find(MedicamentEntity.class, idMed);
            entityManager.remove(med);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public void addMed(String denumire, int cantitate, String sectii) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            MedicamentEntity med = new MedicamentEntity();
            med.setDenumire(denumire);
            med.setCantitate(cantitate);
            med.setSectii(sectii);
            entityManager.persist(med);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
