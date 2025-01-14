package target;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


public class Exercicio3 {
    public static void main(String[] args) {
    	try {

            String caminhoArquivo = "src/main/resources/faturamento.json";
            String jsonConteudo = new String(Files.readAllBytes(Paths.get(caminhoArquivo)));


            JSONObject obj = new JSONObject(jsonConteudo);
            JSONArray faturamentoArray = obj.getJSONArray("faturamento");


            List<Double> valoresValidos = new ArrayList<>();

            for (int i = 0; i < faturamentoArray.length(); i++) {
                JSONObject dia = faturamentoArray.getJSONObject(i);
                double valor = dia.getDouble("valor");
                if (valor > 0) {
                    valoresValidos.add(valor);
                }
            }


            if (valoresValidos.isEmpty()) {
                System.out.println("Não há valores válidos de faturamento.");
                return;
            }


            double menorFaturamento = valoresValidos.stream().min(Double::compare).get();
            double maiorFaturamento = valoresValidos.stream().max(Double::compare).get();


            double somaTotal = valoresValidos.stream().mapToDouble(Double::doubleValue).sum();
            double mediaFaturamento = somaTotal / valoresValidos.size();


            long diasAcimaDaMedia = valoresValidos.stream().filter(valor -> valor > mediaFaturamento).count();

            System.out.println("Menor valor de faturamento: " + menorFaturamento);
            System.out.println("Maior valor de faturamento: " + maiorFaturamento);
            System.out.println("Dias com faturamento acima da média: " + diasAcimaDaMedia);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

