package PackAgenda;

import java.util.List;


import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;




public class PersistenciaJson implements Igravacao{

	@Override
	public boolean gravar(List<Pessoa> list) {
		ListaPessoa l = new ListaPessoa();
		l.setPessoas(list);
		FileWriter writer = null;
		try {
			GsonBuilder builder = new GsonBuilder();

			Gson gson = builder.create();

			writer = new FileWriter("src/PackAgenda/agenda.json");

			writer.write(gson.toJson(l,ListaPessoa.class));

			writer.close();
		} catch (IOException ex) {

		} finally {
			try {
				writer.close();
			} catch (IOException ex) {

			}
		}
		return true;
	}

	@Override
	public List<Pessoa> ler() {
		Gson gson = new Gson();
		
		String caminho="src/PackAgenda/agenda.json";
        ListaPessoa obj = new ListaPessoa();
		try {
			BufferedReader br = new BufferedReader(new FileReader(caminho));
			obj = gson.fromJson(br, ListaPessoa.class);
		}
			catch (Exception e) {
	            e.printStackTrace();
			}
		return obj.getPessoas();
	}
	}


