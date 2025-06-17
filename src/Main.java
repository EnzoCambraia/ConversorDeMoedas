import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        RequisicaoAPI api = new RequisicaoAPI();
        while (true) {
            System.out.println("Bem-vindo, ao conversor de moedas, por favor escolha uma opção");
            System.out.println("""
                    1) Dólar ---> Peso Argentino
                    2) Peso Argentino ---> Dólar
                    3) Dólar ---> Real Brasileiro
                    4) Real Brasileiro ---> Dólar
                    5) Dólar ---> Peso Colombiano
                    6) Peso Colombiano ---> Dólar
                    7) Real Brasileiro ---> Iene
                    8) Iene ---> Real Brasileiro
                    9) Sair (Para encerrar a aplicação)
                    """);
            String opcao = scanner.nextLine();

            if (opcao.equals("9") || opcao.equalsIgnoreCase("Sair")) {
                System.out.println("Aplicação encerrada.");
                break;
            }

            switch (opcao){
                case "1": //Dólar Norte Americano para Peso Argentino ARS
                    ConversorDeMoeda.converter(api,"USD","ARS",scanner);
                    break;
                case "2": //Peso argentino para Dólar Norte Americano
                    ConversorDeMoeda.converter(api,"ARS","USD",scanner);
                    break;
                case "3": //Dólar Norte Americano para Real Brasileiro
                    ConversorDeMoeda.converter(api,"USD","BRL",scanner);
                    break;
                case "4": //Real Brasileiro para Dólar Norte Americano
                    ConversorDeMoeda.converter(api,"BRL","USD",scanner);
                    break;
                case "5": //Dólar Norte Americano para peso Colombiano
                    ConversorDeMoeda.converter(api,"USD","COP",scanner);
                    break;
                case "6": //Peso Colombiano para Dólar Norte Americano
                    ConversorDeMoeda.converter(api,"COP","USD",scanner);
                    break;
                case "7": //Real Brasileiro para Iene Japonês
                    ConversorDeMoeda.converter(api,"BRL","JPY",scanner);
                    break;
                case "8": // Iene Japonês para Real Brasileiro
                    ConversorDeMoeda.converter(api,"JPY","BRL",scanner);
                    break;
            }

        }
    }
}