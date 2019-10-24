package PackAgenda;

import java.util.List;

public class Persistencia {
private Igravacao g;
	
	public Persistencia(Igravacao g) {
		this.g=g;
	}
	
	public List<Pessoa> leitura() {
		return g.ler();
	}
	
	public void gravacao(List<Pessoa> list) {
			g.gravar(list);
	}
}
