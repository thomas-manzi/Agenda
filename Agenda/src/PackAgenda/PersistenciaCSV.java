package PackAgenda;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class PersistenciaCSV implements Igravacao {

	@Override
	public boolean gravar(List<Pessoa> list) {
		try {
			Scanner ler = new Scanner(System.in);
			FileWriter arq = new FileWriter("src/PackAgenda/agenda.csv");
			PrintWriter gravarArq = new PrintWriter(arq);
			for (Pessoa pessoa : list) {
				gravarArq.printf("%d,%s,%s,%s,%s\n", pessoa.getCodigo(), pessoa.getNome(), Arruma_data.arrumaDate(pessoa.getDataNasc()), pessoa.getEmail(), pessoa.getTelefone() );
			}
			arq.close();
			return true;
			}catch (IOException e) {
				return false;
			}
		
	}

	@Override
	public List<Pessoa> ler() {
		List <Pessoa> lista = new ArrayList <Pessoa>();
		Pessoa p = new Pessoa();
		try {
			FileReader arq1 = new FileReader("src/PackAgenda/agenda.csv");
			BufferedReader lerArq = new BufferedReader(arq1);
			String linha = lerArq.readLine();
			lista = new ArrayList <Pessoa>();
			while (linha != null) {
				String [] leitura = linha.split(",");
				p = new Pessoa ();
				p.setCodigo(Integer.parseInt(leitura[0]));
				p.setNome(leitura[1]);
				p.setDataNasc(Arruma_data.arrumaDateStrToCal(leitura[2]));
				p.setEmail(leitura[3]);
				p.setTelefone(leitura[4]);
				lista.add(p);
				linha = lerArq.readLine ();
			}
			arq1.close();
			return lista;
		} catch (IOException e) {
			System.err.printf("Erro na abertura do arquivo : %s.\n" , e.getMessage());
			return null;
		}
	}
	
}
