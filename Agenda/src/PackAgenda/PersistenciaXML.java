package PackAgenda;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;






public class PersistenciaXML implements Igravacao{

	@Override
	public boolean gravar(List<Pessoa> list) {
		final String NOMEDOARQUIVO = "agenda";
        final String LOCALHOST = "src/PackAgenda/";
        Element config = new Element("pessoas");
        Document documento = new Document(config);
        Element titulo = new Element("titulo");

        for (int x = 0; x < list.size(); x++) {
            Element pessoa = new Element("pessoa");
            pessoa.setAttribute("codigo", String.valueOf(list.get(x).getCodigo()));

            Element nome = new Element("nome");
            nome.setText(list.get(x).getNome());
                    
            Element email = new Element("email");
            email.setText(list.get(x).getEmail());

            Element tel = new Element("telefone");
            tel.setText(list.get(x).getTelefone());
            
            Element data = new Element("data");
            data.setText(Arruma_data.arrumaDate(list.get(x).getDataNasc()));

            pessoa.addContent(nome);
            pessoa.addContent(tel);
            pessoa.addContent(email);
            pessoa.addContent(data);
            config.addContent(pessoa);
        }
        XMLOutputter xout = new XMLOutputter();
        try {
            //criando o arquivo de saida
            BufferedWriter arquivo = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream(LOCALHOST + NOMEDOARQUIVO + ".xml"), "UTF-8"));
            //imprimindo o xml no arquivo
            xout.output(config, arquivo);

        } catch (IOException e) {
            e.printStackTrace();
        }
	return false;
	}

	@Override
	public List<Pessoa> ler() {
		final String NOMEDOARQUIVO = "agenda";
        final String LOCALHOST = "src/PackAgenda/";
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        Document doc = null;
        SAXBuilder builder = new SAXBuilder();
        try {
            doc = builder.build(LOCALHOST + NOMEDOARQUIVO + ".xml");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Element config = doc.getRootElement();
        List lista = config.getChildren("pessoa");

        for (Iterator iter = lista.iterator(); iter.hasNext();) {
            Element element = (Element) iter.next();
            Pessoa p = new Pessoa();
            p.setCodigo(Integer.parseInt(element.getAttributeValue("codigo")));
            p.setNome(element.getChildText("nome"));
            p.setEmail(element.getChildText("email"));
            p.setDataNasc(Arruma_data.arrumaDateStrToCal(element.getChildText("data")));
            p.setTelefone(element.getChildText("telefone"));
            
            pessoas.add(p);
        }
        return pessoas;
	}
	

}
