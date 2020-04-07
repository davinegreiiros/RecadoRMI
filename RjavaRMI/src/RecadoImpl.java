import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class RecadoImpl extends UnicastRemoteObject implements IMural{
	private static final long serialVersionUID = 1L;
	
	protected RecadoImpl() throws RemoteException {
		recados = new ArrayList<>();
	}

	private ArrayList<Recado> recados;
	@Override
	public void registrarRecado(Recado recado) throws RemoteException {
		Recado r = consultarRecado(recado.getCodigo());
		if(r == null) {
			recados.add(recado);
		}else {
			r.setTexto(recado.getTexto());
			r.setNome(recado.getNome());
			
		}
		
	}

	@Override
	public Recado consultarRecado(int codigo) throws RemoteException {
		for(Recado r : recados) {
			if(r.getCodigo() == codigo) {
				return r;
			}
		}
		return null;
	}

	@Override
	public List<Recado> consultarRecados() throws RemoteException {
		return recados;
	}

	@Override
	public String removerRecado(Recado recado) throws RemoteException {
		String mensagem = "\n******** recado removido com Sucesso! ********\n";
		recados.remove(recados);
		return mensagem;
		
	}

}
