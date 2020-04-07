import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;


public class RecadoClient {
	
	
	public static void main(String arg[]) {
		try {
			IMural mural = (IMural) Naming.lookup("//localhost:2020/AgendaServer");
			Recado r = new Recado();
			r.setCodigo(25);
			r.setTexto("Recado teste 1");
			r.setNome("Negreiros");
			mural.registrarRecado(r);
			
			Recado r2 = new Recado();
			r2.setCodigo(30);
			r2.setTexto("Recado teste 2");
			r2.setNome("Victor");
			mural.registrarRecado(r2);
			mural.removerRecado(r);
			
			List<Recado> recados = mural.consultarRecados();
			for(Recado cont: recados)
				System.out.println(cont.getNome() + " " + cont.getTexto());
			
		}catch(Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
		}
	}
}
