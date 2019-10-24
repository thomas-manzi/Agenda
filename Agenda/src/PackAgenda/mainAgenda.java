package PackAgenda;

import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class mainAgenda {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		Scanner leia= new Scanner(System.in);
		
		
		Persistencia salvar = null;
		PersistenciaJson json=new PersistenciaJson();
		PersistenciaXML xml = new PersistenciaXML();
		PersistenciaCSV csv=new PersistenciaCSV();
		
		ListaPessoa lista= new ListaPessoa();
		
		Pessoa p = new Pessoa();
		
			
		//gravar
		
		//csv.gravar(lista.getPessoas());
		//json.gravar(lista.getPessoas());
		//xml.gravar(lista.getPessoas());
		
		//leitura
		
		//lista.setPessoas(json.ler());
		//lista.setPessoas(csv.ler());
		//lista.setPessoas(xml.ler());
	
		//System.out.println(lista);
		
		
		
		
		boolean t=true;
		int e,o;
		
		while (t) {
			System.out.println("Qual operação deseja fazer 1-Incluir , 2- Alterar, 3- Excluir , 4- Consulta por nome , 5- Aniversariante do Mes , 6- Pesquisar dominio de email, 7-Ler em json,xml , 0- Sair/Salvar ");
			e=leia.nextInt();
			leia.nextLine();
			if (e==1) {
				p=new Pessoa();
				int cod=0;
				System.out.println(" digite o cod ");
				cod=leia.nextInt();
				leia.nextLine();
				p.setCodigo(cod);
				
				String nome=" ";
				System.out.println(" digite o nome ");
				nome=leia.nextLine();
				p.setNome(nome);
				
				System.out.println(" digite o email ");
				String ema;
				ema=leia.nextLine();
				p.setEmail(ema);
				
				System.out.println(" digite a data de nascimento dd/MM/yyyy ");
				String dat="";
				dat=leia.nextLine();
				p.setDataNasc(Arruma_data.arrumaDateStrToCal(dat));
				
				System.out.println(" digite o telefone ");
				String tel;
				tel=leia.nextLine();
				p.setTelefone(tel);
				
				lista.incluir(p);
			}else if (e==4) {
				System.out.println(" digite o as inicias do nome ");
				String ini;
				ini=leia.nextLine();
				System.out.println(lista.consultaNome(ini));
			}else if (e==0) {
				int s=0;
				System.out.println(" deseja salvar as alteracoes? 1- sim 2 - nao  ");
				s=leia.nextInt();
				leia.nextLine();
				if (s==1) {
					System.out.println(" salvar em qual arquivo 1-XML 2-JSON 3-CSV");
					s=leia.nextInt();
					leia.nextLine();
					if (s==1) {
						salvar=new Persistencia(new PersistenciaXML());
						
						
					}else if (s==2) {
						salvar=new Persistencia(new PersistenciaJson());
						
						
					}else if (s==3) {
						salvar=new Persistencia(new PersistenciaCSV());
						
						
					}
					salvar.gravacao(lista.getPessoas());
				}else{
				
				t=false;
				}
			}else if (e==3) {
				System.out.println("digite o cod da pessoa a ser excluida ");
				for (Pessoa pessoa : lista.getPessoas()) {
					System.out.println(pessoa.getCodigo());
					System.out.println(pessoa.getNome());
				}
				int cc;
				cc=leia.nextInt();
				lista.excluir(cc);
			}else if (e==5) {
				System.out.println(" passe o mes do aniversario");
				int ms;
				ms=leia.nextInt();
				System.out.println(lista.aniversariantes(ms));
			}else if (e==6) {
				System.out.println(" digite o dominio do email ");
				String domE="";
				domE=leia.nextLine();
				System.out.println(lista.consultaDominio(domE));
			}else if (e==7) {
				System.out.println(" em qual tipo de arquivo quer ler os dados 1-XML 2-Json 3-CSV");
				o=leia.nextInt();
				leia.nextLine();
				if (o==1) {
					salvar= new Persistencia(new PersistenciaXML());
					
					
				}else if (o==2) {
					salvar= new Persistencia(new PersistenciaJson());
					
					
			}else  {
				salvar = new Persistencia(new PersistenciaCSV());
				
				
			}
				lista.setPessoas(salvar.leitura());
				System.out.println(lista);
			 
		}else if (e==2) {
			lista.alterar(p);
		}

	}

}
}
