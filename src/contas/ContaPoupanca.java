package contas;

import cliente.Cliente;

import java.time.LocalDate;
import java.time.Period;

public class ContaPoupanca extends Conta {

    private int SEQUECIA_CONTA = 1;
    private final double taxaRendimentoPoupanca;
    private LocalDate dataUltimoDeposito;

    public ContaPoupanca(Cliente cliente, double taxaRendimentoPoupanca) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = 20 + SEQUECIA_CONTA++;
        this.cliente = cliente;
        this.taxaRendimentoPoupanca = taxaRendimentoPoupanca;
    }

    public double calcularRendimentoPoupanca(LocalDate dataSaque) {
        double periodoRendimento = Period.between(this.dataUltimoDeposito, dataSaque).getMonths();
        this.saldo = this.saldo * Math.pow((1 + this.taxaRendimentoPoupanca), periodoRendimento);
        return saldo;
    }

    @Override
    public void depositar(double valor) {
        super.depositar(valor);
        dataUltimoDeposito = LocalDate.now();
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("=== Extrato contas.Conta Poupan�a ===");
        super.imprimirInfosComuns();
    }
}
