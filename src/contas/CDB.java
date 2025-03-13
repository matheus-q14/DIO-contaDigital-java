package contas;

import java.time.LocalDate;
import java.time.Period;

public class CDB {
    private LocalDate dataVencimento;
    private double taxaRentabilidade;
    private double iof = 0.96;
    private double saldoAtual;

    public CDB(LocalDate dataVencimento, double taxaRentabilidade, double valorInicial) {
        this.dataVencimento = dataVencimento;
        this.taxaRentabilidade = taxaRentabilidade;
        this.saldoAtual = valorInicial;
    }

    double sacarRendimento(LocalDate aplicacao, LocalDate dataResgate) {
        double duracaoInvestimento = Period.between(aplicacao, dataResgate).toTotalMonths();
        saldoAtual = saldoAtual * Math.pow((1 + (taxaRentabilidade / 12)), duracaoInvestimento);
        if (duracaoInvestimento == 1)
            saldoAtual = saldoAtual - saldoAtual * iof;
        double rendimento = saldoAtual;
        saldoAtual -= rendimento;
        return rendimento;
    }
}
