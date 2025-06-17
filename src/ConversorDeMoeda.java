import java.io.IOException;
import java.util.Scanner;

public class ConversorDeMoeda {
    public static void converter(RequisicaoAPI requisicaoApi, String moedaBase, String moedaConvertida, Scanner scanner) throws IOException, InterruptedException {
    try{

            //realizar a requisição da API
        RespostaAPI resposta = requisicaoApi.pegarRespostaAPI(moedaBase);

        // pedir o valor e tratar os separadores
        System.out.printf("Digite o valor em %s", moedaBase);
        String input = scanner.nextLine().trim();//ler e remover espaços
        String valorFormatado = input.replace(".",","); // substituir o separador
        double valor = Double.parseDouble(valorFormatado.replace(",",".")); // converter para double e interlizar o separador novo e único

        //Verificador de moedaBase  (se é suportada) (quando o conversor for universal.)
        if (!resposta.getConversion_rates().containsKey(moedaBase)){
        System.out.println("A Moeda que você escolheu " + "'" + moedaConvertida + "'" + " não é suportada, ou está incorreta, tente novamente.");
        return;
        }

        if (valor <= 0 ){
        System.out.println("O valor deve ser positivo. Por favor, tente novamente.");
        return;
        }
        scanner.nextLine();//limpar o buffer

        //Verificador de moedaConvertida (se é suportada) (quando o conversor for universal.)
        if (!resposta.getConversion_rates().containsKey(moedaConvertida)){
            System.out.println("Moeda destino " + moedaConvertida + " não suportada");
        }
        //Pegar a taxa de conversão específica
        double taxa = resposta.getConversion_rates().get(moedaConvertida);

        //calcular e exibir
        double calculoDeCambio = valor * taxa;
        // Formatar resposta para exibição
            System.out.printf("\n%.2f %s = %.2f %s\n",valor,moedaBase,calculoDeCambio,moedaConvertida);
        } catch (NumberFormatException e){
            System.out.println("Erro, use apenas números com vírgula ou ponto (ex 1.50 ou 1,50)");
    }     catch (Exception e){
            System.out.println("Erro de conversão" + e.getMessage());
    }
    }
}