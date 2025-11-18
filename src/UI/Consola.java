package UI;

import Exceptions.RepositoryExceptions;
import Exceptions.TortException;
import Service.ServiceComanda;
import Service.ServiceTort;
import domain.Comanda;
import domain.Tort;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consola {
    private final ServiceComanda ServiceComanda;
    private final ServiceTort ServiceTort;
    private final Scanner scanner;

    public Consola(ServiceComanda serviceComanda, ServiceTort serviceTort,Scanner scanner){
        this.ServiceComanda=serviceComanda;
        this.ServiceTort=serviceTort;
        this.scanner=new Scanner(System.in);
    }

    public void start() {
        boolean running = true;

        while (running) {
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> addTort();
                case 2 -> addComanda();
                case 3 -> deleteTort();
                case 4 -> deleteComanda();
                case 5 -> listTort();
                case 6 -> listComanda();
                case 7 -> searchTort();
                case 8 -> searchComanda();
                case 9 -> updateComanda();
                case 10 -> addTortToComanda();
                case 11 -> clearComanda();
                case 0 -> {
                    running = false;
                    System.out.println("Iesire");
                }
                default -> System.out.println("Optiune invalida");
            }
        }
    }

    private void printMenu() {
        System.out.println("1. Adauga tort");
        System.out.println("2. Adauga comanda");
        System.out.println("3. Sterge tort dupa ID");
        System.out.println("4. Sterge comanda dupa ID");
        System.out.println("5. Afiseaza toate Torturile");
        System.out.println("6. Afiseaza toate Comenziile");
        System.out.println("7. Cauta tort dupa ID");
        System.out.println("8. Cauta comanda dupa ID");
        System.out.println("9. Actualizeaza Comanda");
        System.out.println("10. Adauga tort la comanda ");
        System.out.println("11. Curata comenzi");
        System.out.println("0. Iesire");
        System.out.print("Alege optiunea: ");
    }

    private void addTort() {
        try{
        System.out.print("ID tort: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("Tip: "); String name = scanner.nextLine();
        ServiceTort.addTort(new Tort(id, name));
        System.out.println("Tort adaugat");
        }catch(InputMismatchException e) {
            System.err.println(" Eroare de intrare: ID-ul trebuie să fie un număr întreg.");
            scanner.nextLine();

        } catch (TortException e) {
            System.err.println(" Eroare la adăugarea tortului: " + e.getMessage());

        } catch (Exception e) {
            System.err.println(" Eroare neașteptată: " + e.getMessage());
        }
    }

    private void addComanda() {
        System.out.print("ID Comanda: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Data (dd.MM.yyyy): ");
        String dataText = scanner.nextLine(); // Citim ca String

        try {
            SimpleDateFormat formatator = new SimpleDateFormat("dd.MM.yyyy");

            Date dataObiect = formatator.parse(dataText);

            Comanda nouaComanda = new Comanda(id, dataObiect);
            ServiceComanda.addComanda(nouaComanda);

            System.out.println("Comanda adaugata.");

        } catch (ParseException e) {
            System.err.println(" Eroare: Formatul datei este invalid. Folosește dd.MM.yyyy.");
        } catch (IllegalArgumentException e) {
            System.err.println(" Eroare de validare: " + e.getMessage());
        }
    }

    private void deleteTort() {
        try{
        System.out.print("ID Tort de sters: "); int id = scanner.nextInt();
        ServiceTort.RemoveTort(id);
        System.out.println("Tort sters (daca exista).");
        }catch (RepositoryExceptions e){
            System.err.println("Nu exista nici o comanda cu acest id");
        }


    }

    private void deleteComanda() {
        System.out.print("ID Comanda de sters: "); int id = scanner.nextInt();
        ServiceComanda.deleteComanda(id);
        System.out.println("Comanda stearsa (daca exista).");


    }

    private void listTort() {
        System.out.println(ServiceTort.getAllTort());

    }

    private void listComanda() {
        System.out.println(ServiceComanda.getAllComanda());

    }

    private void searchTort() {
        System.out.print("ID Tort: "); int id = scanner.nextInt();
        System.out.println(ServiceTort.getTort(id));

    }

    private void searchComanda() {
        System.out.print("ID Comanda: "); int id = scanner.nextInt();
        System.out.println(ServiceComanda.getComanda(id));

    }

    private void updateComanda() {
        try {
            System.out.print("ID Comanda de actualizat: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            Comanda comandaExistenta = ServiceComanda.getComanda(id);
            if (comandaExistenta == null) {
                System.err.println("Eroare: Comanda cu ID-ul " + id + " nu există.");
                return;
            }

            System.out.print("Noua Dată și Oră (dd.MM.yyyy HH:mm): ");
            String nouaDataOraText = scanner.nextLine();

            SimpleDateFormat formatator = new SimpleDateFormat("dd.MM.yyyy HH:mm");
            Date nouaDataOraObiect = formatator.parse(nouaDataOraText);

            comandaExistenta.setData(nouaDataOraObiect);

            ServiceComanda.updateComanda(comandaExistenta);

            System.out.println(" Comanda ID " + id + " a fost actualizată la data: " + nouaDataOraObiect);

        } catch (java.util.InputMismatchException e) {
            System.err.println(" Eroare: ID-ul trebuie să fie un număr întreg.");
            scanner.nextLine();
        } catch (ParseException e) {
            System.err.println("Eroare: Formatul datei și orei este invalid. Folosește dd.MM.yyyy HH:mm (ex: 20.12.2025 14:30).");
        } catch (Exception e) {
            System.err.println(" Eroare la actualizare: " + e.getMessage());
        }
    }



    private void addTortToComanda() {
        System.out.print("ID Comanda: "); int comandaid= scanner.nextInt();
        System.out.print("ID Tort: "); int tortid = scanner.nextInt();
        Tort tort = ServiceTort.getTort(tortid);
        if (tort != null) {
            ServiceComanda.addTortToComanda(comandaid,tort);
            System.out.println("Tort adaugat la comanda");
        } else {
            System.out.println("Tortul nu exista ");
        }

    }

    private void clearComanda() {
        ServiceComanda.getAllComanda().clear();
        System.out.println("Toate comenz au fost sterse.");

    }


}
