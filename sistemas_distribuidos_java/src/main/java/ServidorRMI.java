package sd_project.sistemas_distribuidos_java.src.main.java;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {
    public static void main(String[] args) {
        try {
            //registro do RMI
            LocateRegistry.createRegistry(1099);
            
            PlanoDeTVServiceImpl service = new PlanoDeTVServiceImpl();
            Naming.rebind("rmi://localhost/PlanoDeTVService", service);
            
            System.out.println("Servidor RMI pronto para atender.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
