package Domain;

import entity.AngajatSpitalEntity;

import javax.persistence.*;

public class UserRepository {

    UserRepository() { }

    public AngajatSpitalEntity findUser(String username, String password) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        AngajatSpitalEntity user = new AngajatSpitalEntity();
        user.setIdAngajat(0);
        user.setType("nu exista");
        try {
            transaction.begin();

            TypedQuery<AngajatSpitalEntity> UserByID = entityManager.createQuery("select a from AngajatSpitalEntity a where a.username = :username and a.parola = :parola", AngajatSpitalEntity.class);
            UserByID.setParameter("username", username);
            UserByID.setParameter("parola", password);
            for (AngajatSpitalEntity angajat : UserByID.getResultList()) {
                if (angajat.getIdAngajat() != 0) {
                    user.setIdAngajat(angajat.getIdAngajat());
                    user.setUsername(angajat.getUsername());
                    user.setParola(angajat.getParola());
                    user.setNume(angajat.getNume());
                    user.setType(angajat.getType());
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
        return user;
    }

    public int verifyNewUser(int idAngajat) {
        int nr = 0;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<AngajatSpitalEntity> UserByID = entityManager.createQuery("select a from AngajatSpitalEntity a where a.idAngajat = :idAngajat", AngajatSpitalEntity.class);
            UserByID.setParameter("idAngajat", idAngajat);
            for (AngajatSpitalEntity angajat : UserByID.getResultList()) {
                if (angajat.getIdAngajat() != idAngajat) {
                    nr = 1;
                }

                if (angajat.getUsername() != null) {
                    nr = 2;
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

        return nr;
    }

    public int saveNewUser(int idAngajat, String username, String password, String type) {
        int rez = 1;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();

            TypedQuery<AngajatSpitalEntity> UserByID = entityManager.createQuery("select a from AngajatSpitalEntity a where a.idAngajat = :idAngajat", AngajatSpitalEntity.class);
            UserByID.setParameter("idAngajat", idAngajat);

            for (AngajatSpitalEntity angajat : UserByID.getResultList()) {
                if (angajat.getIdAngajat() == idAngajat) {
                    if (angajat.getUsername() == null) {
                        angajat.setUsername(username);
                        angajat.setParola(password);
                        angajat.setType(type);
                        rez = 0;
                    } else {
                        rez = 1;
                    }
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

}
