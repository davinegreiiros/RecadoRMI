import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

public class AgendaClient {

	public static void main(String arg[]) {
		try {
			
			Agenda agenda = (Agenda) Naming.lookup("//localhost:2020/AgendaServer");
			Contato c = new Contato();
			c.setCodigo(1);
			c.setFone("99999-9999");
			c.setNome("Davi");
			agenda.registrarContato(c);
			Contato c2 = new Contato();
			c2.setCodigo(2);
			c2.setFone("88888-9999");
			c2.setNome("João");
			agenda.registrarContato(c2);
			List<Contato> contatos = agenda.consultarContatos();
			for(Contato cont: contatos)
				System.out.println(cont.getNome() + " " +cont.getFone());
			
		}
		catch(Exception e) {
			System.out.println("HelloClient exception: " + e.getMessage());
		}
	}
}
