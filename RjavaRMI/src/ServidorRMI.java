import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorRMI {

	public static void main(String args[]) {
		try {
			RecadoImpl recado = new RecadoImpl();
			LocateRegistry.createRegistry(2020);
			Naming.rebind("//locahost:2020/AgendaServer",recado);
			
			System.out.println("Servidor Mural ativo");
			
		}catch(Exception e) {
			System.out.println("Servidor Mural erro:" + e);
			e.printStackTrace();
		}
	}
}
