package cliente;

import contas.CDB;

import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private String nome;
    private int idade;
    private List<CDB> investimentos = new ArrayList<>();

    public Cliente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void adicionarInvestimento(CDB investimento) {
        this.investimentos.add(investimento);
    }

    public CDB getInvestimentos(int index) {
        return investimentos.get(index);
    }

    public String getNome() {
        return nome;
    }


}
