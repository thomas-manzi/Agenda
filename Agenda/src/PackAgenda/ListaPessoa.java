package PackAgenda;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class ListaPessoa {
	private List<Pessoa> pessoas;

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public ListaPessoa () {
		pessoas= new ArrayList<Pessoa>();
	}
	
	public void incluir(Pessoa p) {
		pessoas.add(p);
	}
	
	public void excluir(int cod) {
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getCodigo()==cod) {
				pessoas.remove(pessoa);
			}
		}
	}
	
	public void alterar(Pessoa p ) {
		for (Pessoa pessoa : pessoas) {
			if (p.getCodigo()==pessoa.getCodigo()) {
				pessoa.setNome(p.getNome());
				pessoa.setEmail(p.getEmail());
			}
		}
	}

	public String consultaNome (String letra) {
		String consulta=" ";
		for (Pessoa pessoa : pessoas) {
			if ((pessoa.getNome().toLowerCase().startsWith(letra.toLowerCase()))) {
				consulta=pessoa.getNome()+consulta;
			}
		}
		return consulta;
		
	}
	
	public String consultaDominio(String dom) {
		String domin=" ";
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getEmail().toLowerCase().contains(dom.toLowerCase())) {
				domin=pessoa.getEmail() +  "\r\n" +domin ;
			}
		}
		return domin;
	}
	
	
	public String aniversariantes(int mes) {
		String a="";
		for (Pessoa pessoa : pessoas) {
			if (pessoa.getDataNasc().get(Calendar.MONTH)==mes) {
				
				a+=Arruma_data.arrumaDate(pessoa.getDataNasc());
				
			}
		}
		return a;
	}
	private String mostrarPessoas() {
		String mostra="";
		if (!pessoas.isEmpty()) {
			
		
		for (Pessoa pessoa : pessoas) {
			mostra=pessoa.toString()+mostra+"\n";
		}
		
	}
		return mostra;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("listaPessoa =");
		builder.append(mostrarPessoas());
		builder.append("]");
		return builder.toString();
	}
}
