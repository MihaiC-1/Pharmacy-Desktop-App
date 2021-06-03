package Domain;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.persistence.*;
import entity.ComandaEntity;
import entity.ContinutComandaEntity;

public class ComandaRepository {

    ComandaRepository() {}

    public void addComandaNoua(int idUser) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Timestamp nowT = Timestamp.valueOf(dtf.format(now));
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ComandaEntity com = new ComandaEntity();
            com.setDataOra(nowT);
            com.setSatus("In creare");
            com.setIdAngajat(idUser);
            entityManager.persist(com);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public int getLastComand(int idUser) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int maxim = 0;

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c where c.idAngajat = :idUser", ComandaEntity.class);
            ComById.setParameter("idUser", idUser);

            for (ComandaEntity com : ComById.getResultList()) {
                if (com.getSatus().equals("In creare")) {
                    maxim = com.getIdComanda();
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
        return maxim;
    }

    public void addContinut(int idMed, int idCom, int cantitate) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            ContinutComandaEntity con = new ContinutComandaEntity();
            con.setIdComanda(idCom);
            con.setIdMedicament(idMed);
            con.setCantitate(cantitate);
            entityManager.persist(con);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public int getCountContinut(int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int count = 0;

        try {
            transaction.begin();

            TypedQuery<ContinutComandaEntity> ConCom = entityManager.createQuery("select c from ContinutComandaEntity c where c.idComanda = :idCommand", ContinutComandaEntity.class);
            ConCom.setParameter("idCommand", idCommand);

            for (ContinutComandaEntity con : ConCom.getResultList()) {
                if (con.getIdComanda() == idCommand) {
                    count++;
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
        return count;
    }

    public int getNstIdMed(int n, int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int count = 0;
        int idMed = 0;

        try {
            transaction.begin();

            TypedQuery<ContinutComandaEntity> ConCom = entityManager.createQuery("select c from ContinutComandaEntity c where c.idComanda = :idCommand", ContinutComandaEntity.class);
            ConCom.setParameter("idCommand", idCommand);

            for (ContinutComandaEntity con : ConCom.getResultList()) {
                count++;
                if (count == n) {
                    idMed = con.getIdMedicament();
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
        return idMed;
    }

    public int getCantitateMed(int idMed, int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int cantitate = 0;

        try {
            transaction.begin();

            TypedQuery<ContinutComandaEntity> ConCom = entityManager.createQuery("select c from ContinutComandaEntity c where c.idMedicament = :idMed and c.idComanda = :idCommand", ContinutComandaEntity.class);
            ConCom.setParameter("idMed", idMed);
            ConCom.setParameter("idCommand", idCommand);

            for (ContinutComandaEntity con : ConCom.getResultList()) {
                if (con.getIdComanda() == idCommand && con.getIdMedicament() == idMed) {
                    cantitate = con.getCantitate();
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
        return cantitate;
    }

    public void deleteContinutComanda(int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<ContinutComandaEntity> ConCom = entityManager.createQuery("select c from ContinutComandaEntity c where c.idComanda = :idCommand", ContinutComandaEntity.class);
            ConCom.setParameter("idCommand", idCommand);

            for (ContinutComandaEntity con : ConCom.getResultList()) {
                entityManager.flush();
                entityManager.clear();

                ContinutComandaEntity conn = new ContinutComandaEntity();
                conn = entityManager.find(ContinutComandaEntity.class, con.getIdContinut());
                entityManager.remove(conn);
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

    public void modifyStatusForSend(int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c where c.idComanda = :idCommand", ComandaEntity.class);
            ComById.setParameter("idCommand", idCommand);

            for (ComandaEntity com : ComById.getResultList()) {
                if (com.getSatus().equals("In creare")) {
                    com.setSatus("In Asteptare");
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

    public String getStatusCommandByID(int idCommand) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        String rez = "";

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c where c.idComanda = :idCommand", ComandaEntity.class);
            ComById.setParameter("idCommand", idCommand);

            for (ComandaEntity com : ComById.getResultList()) {
                if (com.getIdComanda() == idCommand) {
                    rez = com.getSatus();
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
        return rez;
    }

    public int getIdComandaForDelete(int idUser) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        int idComanda = 0;

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c where c.idAngajat = :idUser", ComandaEntity.class);
            ComById.setParameter("idUser", idUser);

            for (ComandaEntity com : ComById.getResultList()) {
                if (com.getIdAngajat() == idUser && com.getSatus().equals("Onorat") ||
                com.getSatus().equals("Neonorat")) {
                    idComanda = com.getIdComanda();
                    break;
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
        return idComanda;
    }

    public void deleteComanda(int idComanda) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            entityManager.flush();
            entityManager.clear();

            ComandaEntity comm = entityManager.find(ComandaEntity.class, idComanda);
            entityManager.remove(comm);

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public ArrayList<ComandaEntity> getOrders(String status) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ArrayList<ComandaEntity> orders = new ArrayList<ComandaEntity>();

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c", ComandaEntity.class);

            for (ComandaEntity com : ComById.getResultList()) {
                if (status.equals("")) {
                    orders.add(com);
                }
                else if (com.getSatus().equals(status)) {
                    orders.add(com);
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
        return orders;
    }

    public ArrayList<ContinutComandaEntity> getContents(int idComanda) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        ArrayList<ContinutComandaEntity> contents = new ArrayList<ContinutComandaEntity>();

        try {
            transaction.begin();

            TypedQuery<ContinutComandaEntity> ConById = entityManager.createQuery("select c from ContinutComandaEntity c where c.idComanda = :idComanda", ContinutComandaEntity.class);
            ConById.setParameter("idComanda", idComanda);

            contents.addAll(ConById.getResultList());

            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
        return contents;
    }

    public void modifyStatus(int idComanda, String status) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<ComandaEntity> ComById = entityManager.createQuery("select c from ComandaEntity c where c.idComanda = :idCommand", ComandaEntity.class);
            ComById.setParameter("idCommand", idComanda);

            for (ComandaEntity com : ComById.getResultList()) {
                com.setSatus(status);
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
}
