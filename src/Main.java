import cliente.Cliente;
import contas.ContaCorrente;
import contas.ContaPoupanca;

public class Main {

    public static void main(String[] args) {
        Cliente matheus = new Cliente("Mathehus", 20);


        ContaCorrente cc = new ContaCorrente(matheus);
        ContaPoupanca poupanca = new ContaPoupanca(matheus, 0.006);

        cc.depositar(100);
        cc.depositar(10000);

        poupanca.depositar(1000);

        cc.fazerInvestimento(10000, 0.12);
        cc.resgatarInvestimento(matheus.getInvestimentos(0), 2030, 6);
        
        cc.imprimirExtrato();
        poupanca.imprimirExtrato();
    }

}
