import java.rmi.*;
import java.util.List;

public interface IMural extends Remote
{
	void registrarRecado(Recado recado) throws RemoteException;
	Recado consultarRecado(int codigo) throws RemoteException;
	List<Recado> consultarRecados() throws RemoteException;
	String removerRecado(Recado recado) throws RemoteException;	
}
