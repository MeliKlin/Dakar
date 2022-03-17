package com.dakar.models;

import com.dakar.enums.Categorias;
import com.dakar.strategies.SocorristaAuto;
import com.dakar.strategies.SocorristaMoto;
import com.dakar.strategies.SocorristaStrategy;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Corrida {

    private int distancia;
    private BigDecimal premio;
    private String nome;
    private int limiteVeiculos;
    private final ArrayList<Veiculo> veiculos = new ArrayList<>();

    public Corrida(int distancia, BigDecimal premio, String nome, int limiteVeiculos) {
        this.distancia = distancia;
        this.premio = premio;
        this.nome = nome;
        this.limiteVeiculos = limiteVeiculos;
    }

    public ArrayList<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void addMoto(int velocidade, int aceleracao, int anguloDeGiro, String placa) {
        if (limiteAtingido()) {
            System.out.println("Limite antigido");
            return;
        }

        Veiculo moto = new VeiculoFactory().getVeiculo(Categorias.MOTO);
        moto.setVelocidade(velocidade);
        moto.setAceleracao(aceleracao);
        moto.setAnguloDeGiro(anguloDeGiro);
        moto.setPlaca(placa);
        veiculos.add(moto);
    }

    public void addCarro(int velocidade, int aceleracao, int anguloDeGiro, String placa) {
        if (limiteAtingido()) {
            System.out.println("Limite antigido");
            return;
        }

        Veiculo carro = new VeiculoFactory().getVeiculo(Categorias.CARRO);
        carro.setVelocidade(velocidade);
        carro.setAceleracao(aceleracao);
        carro.setAnguloDeGiro(anguloDeGiro);
        carro.setPlaca(placa);
        veiculos.add(carro);
    }

    public void deleteVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    public void deleteVeiculoComPlaca(String placa) {
        for (Veiculo veiculo: veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                deleteVeiculo(veiculo);
                break;
            }
        }
    }

    public boolean limiteAtingido() {
        return veiculos.size() == limiteVeiculos;
    }

    public Veiculo getVencedor() {
        Veiculo vencedor = null;

        if (veiculos.size() > 0) {
            vencedor = veiculos.get(0);
        }

        for (int i = 1; i < veiculos.size(); i++) {
            double atual = calculaVelocidadeFinal(vencedor.getVelocidade(), vencedor.getAceleracao(), vencedor.getAnguloDeGiro(), vencedor.getPeso(), vencedor.getRodas());
            double proximo = calculaVelocidadeFinal(veiculos.get(i).getVelocidade(), veiculos.get(i).getAceleracao(), veiculos.get(i).getAnguloDeGiro(), veiculos.get(i).getPeso(), veiculos.get(i).getRodas());

            if (proximo > atual) {
                vencedor = veiculos.get(i);
            }
        }

        return vencedor;
    }

    public double calculaVelocidadeFinal(int velocidade, int aceleracao, int anguloRotacao, int peso, int quantidadeRodas) {
        return velocidade * (aceleracao * 0.5) / (anguloRotacao * (peso - quantidadeRodas * 100));
    }

     public void socorrer(Veiculo veiculo) {
        if (veiculo.getRodas() == 4) {
            socorrerStrategy(new SocorristaAuto(), veiculo);
        } else {
            socorrerStrategy(new SocorristaMoto(), veiculo);
        }
     }

     public void socorrerStrategy(SocorristaStrategy strategy, Veiculo veiculo) {
        strategy.socorrer(veiculo.getPlaca());
     }
}
