package Domain;

import GUI.*;
import entity.AngajatSpitalEntity;
import entity.ComandaEntity;
import entity.ContinutComandaEntity;
import entity.MedicamentEntity;

import java.util.ArrayList;

public class Controller {
    private final UserRepository repoUser = new UserRepository();
    private final MedicamenteRepository repoMed = new MedicamenteRepository();
    private final ComandaRepository repoComanda = new ComandaRepository();
    private final MedicamentEntity[] temp;
    private int length;

    public Controller() {
        length = 0;
        temp = new MedicamentEntity[50];
    }

    // for LOGIN/SIGNUP part of app

    public void initiateLogIn() {
        GUI_autentificare aut = new GUI_autentificare();
        aut.show(aut);
    }

    public int checkUser(String username, String password) {
        AngajatSpitalEntity user = repoUser.findUser(username, password);
        if (user.getType().equals("Farmacist")) {
            GUI_lista_comenzi farm = new GUI_lista_comenzi();
            farm.setCurrentUser(user.getIdAngajat());
            farm.show(farm);
            return 1;
        }
        else if (user.getType().equals("Cadru medical")){
            GUI_medicamente med = new GUI_medicamente();
            med.setCurrentUser(user.getIdAngajat());
            med.setTabel();
            med.show(med);
            return 1;
        }
        else {
            return 0;
        }
    }

    public void signUpOption() {
        GUI_Inregistrare inre = new GUI_Inregistrare();
        inre.show(inre);
    }

    public int checkNewUser(int idAngajat, String username, String password, String type) {
        int newUser = repoUser.verifyNewUser(idAngajat);

        if (newUser == 0) {
            int setNewUser = repoUser.saveNewUser(idAngajat, username, password, type);
            if (setNewUser == 0) {
                initiateLogIn();
            }
            else {
                return 1;
            }
        }
        else if (newUser == 1) {
            return 2;
        }
        else if (newUser == 2) {
            return 3;
        }
        return 0;
    }

    // for Medical Staff par of app

    public void continutCosButton(int idUser) {
        GUI_continut_cos cos = new GUI_continut_cos();
        cos.setCurrentUser(idUser);
        cos.setTabel();
        cos.show(cos);
    }

    public void medicamenteButtonMed(int idUser) {
        GUI_medicamente med = new GUI_medicamente();
        med.setCurrentUser(idUser);
        med.pack();
        med.setTabel();
        med.setVisible(true);
    }

    public void comenziButton(int idUser) {
        GUI_comenzi com = new GUI_comenzi();
        com.setCurrentUser(idUser);
        com.setTabel();
        com.show(com);
    }

    public ArrayList<MedicamentEntity> getMedicamente() {
        return repoMed.getMedicamente();
    }

    public MedicamentEntity getMedicament(int idMed) {
        return repoMed.getMedById(idMed);
    }

    public int verifCantitateMed(String denumire, int cantitate) {
        int idmed = repoMed.getIdMedByDenumire(denumire);
        MedicamentEntity med = repoMed.getMedById(idmed);
        int rez = 0;
        if (cantitate > med.getCantitate()) {
            rez = 1;
        }
        if (idmed == 0) {
            rez = 2;
        }
        return rez;
    }

    public void addMed(String denumire, int cantitate) {
        int idmed = repoMed.getIdMedByDenumire(denumire);
        MedicamentEntity med = new MedicamentEntity();
        med.setIdMedicament(idmed);
        med.setDenumire(denumire);
        med.setCantitate(cantitate);
        temp[length] = med;
        length += 1;
    }

    public void addMedToComanda(int idUser) {
        int idcom = repoComanda.getLastComand(idUser);
        if (idcom == 0 && length > 0) {
            repoComanda.addComandaNoua(idUser);
            idcom = repoComanda.getLastComand(idUser);
        }
        for (int i = 0; i < length; i++) {
            int idMed = temp[i].getIdMedicament();
            int cantitate = temp[i].getCantitate();
            repoComanda.addContinut(idMed, idcom, cantitate);
        }
    }

    public ArrayList<Object[]> getOrderContent(int idUser) {
        ArrayList<Object[]> rez = new ArrayList<Object[]>();
        int lastC = repoComanda.getLastComand(idUser);
        if (lastC > 0) {
            int cantity = repoComanda.getCountContinut(lastC);
            for (int i = 1; i <= cantity; i++) {
                int idMed = repoComanda.getNstIdMed(i, lastC);
                MedicamentEntity med = repoMed.getMedById(idMed);
                int cantitate = repoComanda.getCantitateMed(idMed, lastC);
                rez.add(new Object[] {med.getDenumire(), cantitate});
            }
        }
        return rez;
    }

    public void deleteContinut(int idUser) {
        int idCurrentComand = repoComanda.getLastComand(idUser);
        repoComanda.deleteContinutComanda(idCurrentComand);
    }

    public void sendStatusComanda(int idUser) {
        int idCurrentComand = repoComanda.getLastComand(idUser);
        repoComanda.modifyStatusForSend(idCurrentComand);
    }

    public ArrayList<Object[]> getOrdersUser(int idUser) {
        ArrayList<Object[]> rez = new ArrayList<>();
        ArrayList<ComandaEntity> orders = repoComanda.getOrders("");
        for (ComandaEntity com : orders) {
            if (com.getIdAngajat() == idUser) {
                rez.add(new Object[] {com.getIdComanda(), com.getIdAngajat(), com.getSatus()});
            }
        }
        return rez;
    }

    public String getStatusCommand(int idCommand) {
        return repoComanda.getStatusCommandByID(idCommand);
    }

    public void deleteComenzi(int idUser) {
        int idComanda = repoComanda.getIdComandaForDelete(idUser);
        while (idComanda != 0) {
            repoComanda.deleteContinutComanda(idComanda);
            repoComanda.deleteComanda(idComanda);
            idComanda = repoComanda.getIdComandaForDelete(idUser);
        }
    }

    // for Pharmacy part of app

    public String[] orderList() {
        ArrayList<ComandaEntity> orderList = repoComanda.getOrders("In Asteptare");
        String[] orders = new String[orderList.size()];

        for (int i=0; i < orderList.size(); i++) {
            int nrOrder = orderList.get(i).getIdComanda();
            int nrSectie = orderList.get(i).getIdAngajat();
            String element = "Comanda : " + Integer.toString(nrOrder) + ", User ID: " + Integer.toString(nrSectie);
            orders[i] = element;
        }
        return orders;
    }

    public Object[][] orderContent(int idComanda) {
        ArrayList<ContinutComandaEntity> orderContents = repoComanda.getContents(idComanda);
        Object[][] data = new Object[orderContents.size()][3];

        for (int i = 0; i < orderContents.size(); i++) {
            MedicamentEntity med = repoMed.getMedById(orderContents.get(i).getIdMedicament());
            data[i][0] = med.getDenumire();
            data[i][1] = orderContents.get(i).getCantitate();
            data[i][2] = med.getCantitate();
        }

        return data;
    }

    public void modifyStatus(int idComanda, String status) {
        repoComanda.modifyStatus(idComanda, status);
    }

    public void onListaComenziButton(int currentUser) {
        GUI_lista_comenzi farm = new GUI_lista_comenzi();
        farm.setCurrentUser(currentUser);
        farm.show(farm);
    }

    public void onMedicamenteFarmButton(int currentUser) {
        GUI_medicamente_farm farm = new GUI_medicamente_farm();
        farm.setCurrentUser(currentUser);
        farm.show(farm);
    }

    public void updateMed(String denumire, String denumire_noua, int cantitate, String sectii) {
        repoMed.updateMed(denumire, denumire_noua, cantitate, sectii);
    }

    public void updateCantitateMed(String denumire, int cant) {
        repoMed.updateCantitateMed(denumire, cant);
    }

    public void deleteMed(String denumire) {
        int idMed = repoMed.getIdMedByDenumire(denumire);
        repoMed.deleteMed(idMed);
    }

    public void addMed(String denumire, int cantitate, String sectii) {
        repoMed.addMed(denumire, cantitate, sectii);
    }
}
