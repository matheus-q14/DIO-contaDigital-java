package contas;

import cliente.Cliente;

import java.time.LocalDate;

public class ContaCorrente extends Conta {
    private int SEQUECIA_CONTA = 1;

    public ContaCorrente(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = 10 + SEQUECIA_CONTA++;
        this.cliente = cliente;
    }

    public void fazerInvestimento(double valorAplicacao, double taxaRentabilidadeAnual) throws RuntimeException {
        if (valorAplicacao < this.saldo) {
            LocalDate dataAtual = LocalDate.now();
            LocalDate vencimento;
            vencimento = LocalDate.of(dataAtual.getYear() + 20, dataAtual.getMonth(), 1);
            CDB investimento = new CDB(vencimento, taxaRentabilidadeAnual, valorAplicacao);
            this.saldo -= valorAplicacao;
            cliente.adicionarInvestimento(investimento);
        } else {
            throw new RuntimeException("Valor de investimento menor que saldo em conta");
        }
    }

    public void resgatarInvestimento(CDB investimento, int anoResgate, int mesResgate) {
        LocalDate dataResgate = LocalDate.of(anoResgate, mesResgate, 10);
        double rendimento = investimento.sacarRendimento(LocalDate.now(), dataResgate);
        this.saldo += rendimento;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato contas.Conta Corrente ===");
        super.imprimirInfosComuns();
    }

}
