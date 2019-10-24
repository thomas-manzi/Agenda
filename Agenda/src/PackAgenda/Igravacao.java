package PackAgenda;

import java.util.List;

public interface Igravacao {
	public boolean gravar(List<Pessoa> list);

	public List<Pessoa> ler();
	// criar persistencia e construir essa interface injecao de dependencia
	}


