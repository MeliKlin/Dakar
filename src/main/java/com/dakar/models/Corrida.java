package com.dakar.models;

import com.dakar.enums.Categorias;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Corrida {

    private int distancia;
    private BigDecimal premio;
    private String nome;
    private int limiteVeiculos;
    private final ArrayList<Veiculo> veiculos = new ArrayList<>();

    public void addMoto(int velocidade, int aceleracao, int anguloDeGiro, String placa) {
        Veiculo moto = new VeiculoFactory().getVeiculo(Categorias.MOTO);
        moto.setVelocidade(velocidade);
        moto.setAceleracao(aceleracao);
        moto.setAnguloDeGiro(anguloDeGiro);
        moto.setPlaca(placa);
        veiculos.add(moto);
    }

    public void addCarro(int velocidade, int aceleracao, int anguloDeGiro, String placa) {
        Veiculo carro = new VeiculoFactory().getVeiculo(Categorias.CARRO);
        carro.setVelocidade(velocidade);
        carro.setAceleracao(aceleracao);
        carro.setAnguloDeGiro(anguloDeGiro);
        carro.setPlaca(placa);
        veiculos.add(carro);
    }

    private void deleteVeiculo(Veiculo veiculo) {
        veiculos.remove(veiculo);
    }

    private void deleteVeiculoComPlaca(String placa) {
        for (Veiculo veiculo: veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                deleteVeiculo(veiculo);
                break;
            }
        }
    }

}
