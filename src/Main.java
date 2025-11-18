import Repository.Repository;
import Service.ServiceComanda;
import Service.ServiceTort;
import UI.Consola;
import domain.Comanda;
import domain.Entity;
import domain.Tort;
import Repository.Repository;

void main(String[]args ) throws ParseException {

    //Repo
Repository<Tort> Tortrepo=new Repository<Tort>();
Repository<Comanda> Comandarepo=new Repository<Comanda>();

ServiceTort serviceTort=new ServiceTort(Tortrepo);
ServiceComanda serviceComanda=new ServiceComanda(Comandarepo);


// 1. CREAREA OBIECTELOR TORT
    Tort t1 = new Tort(10, "Amandina");
    Tort t2 = new Tort(20, "Diplomat");
    Tort t3 = new Tort(30, "Mousse Ciocolata");
    Tort t4 = new Tort(40, "Ecler");
    Tort t5 = new Tort(50, "Pădurea Neagră");

// ADAUGAREA LOR ÎN REPOSITORY-UL DE TORTURI
    serviceTort.addTort(t1); // Presupunem ca serviceTort are metoda addTort() care adauga in repo
    serviceTort.addTort(t2);
    serviceTort.addTort(t3);
    serviceTort.addTort(t4);
    serviceTort.addTort(t5);


    // Formatator pentru a converti datele text
    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");


    Date data1 = formatter.parse("05.11.2025");
    Comanda c1 = new Comanda(101,  data1);
    serviceComanda.addComanda(c1);

    // C2: ID 102, 06.11.2025, 1 tort
    Date data2 = formatter.parse("06.11.2025");
    Comanda c2 = new Comanda(102, data2);
    serviceComanda.addComanda(c2);

    // C3: ID 103, 10.11.2025, 2 torturi
    Date data3 = formatter.parse("10.11.2025");
    Comanda c3 = new Comanda(103,data3);
    serviceComanda.addComanda(c3);

    // C4: ID 104, 15.11.2025, 3 torturi
    Date data4 = formatter.parse("15.11.2025");
    Comanda c4 = new Comanda(104,data4);
    serviceComanda.addComanda(c4);

    // C5: ID 105, 05.12.2025, 1 tort
    Date data5 = formatter.parse("05.12.2025");
    Comanda c5 = new Comanda(105,data5);
    serviceComanda.addComanda(c5);

    Scanner scanner = new Scanner(System.in);

    Consola ui = new Consola(serviceComanda, serviceTort, scanner);
    ui.start();

    scanner.close();




        }