package ro.ase.cts.program;

import ro.ase.cts.clase.ManagerRezervari;
import ro.ase.cts.clase.ProxyManager;
import ro.ase.cts.claseState.Masa;
import ro.ase.cts.claseState_v2.StareLibera;
import ro.ase.cts.claseStrategy.Client;
import ro.ase.cts.claseStrategy.PlataBonuriMasa;
import ro.ase.cts.claseStrategy.PlataCard;
import ro.ase.cts.claseStrategy.PlataCash;

public class Main {
    public static void main(String[] args) {
        ManagerRezervari managerRezervari = new ManagerRezervari("Aaaa");
        managerRezervari.rezerva(2);
        ProxyManager proxyManager = new ProxyManager(managerRezervari, 4);
        proxyManager.rezerva(2);
        proxyManager.rezerva(4);

        System.out.println("--------------------------------------------------------------");

        Client client = new Client("Ionel", new PlataCash());
        client.platesteNoua(200);
        client.setPlata(new PlataCard());
        client.platesteNoua(100.3f);
        client.setPlata(new PlataBonuriMasa());
        client.platesteNoua(1000.5f);

        System.out.println("--------------------------------------------------------------");

        Masa masa1 = new Masa(1);
        masa1.cerereEliberare();
        masa1.cerereRezervare();
        masa1.cerereOcupare();
        masa1.cerereRezervare();
        masa1.cerereEliberare();

        System.out.println("--------------------------------------------------------------");

        ro.ase.cts.claseState_v2.Masa masa2 = new ro.ase.cts.claseState_v2.Masa(1);
        masa2.elibereazaMasa();
        masa2.ocupaMasa();
        //masa2.setStare(new StareLibera());
        masa2.rezervaMasa();
        masa2.elibereazaMasa();
        masa2.rezervaMasa();
    }
}
