package com.dakar.strategies;

public class SocorristaAuto implements  SocorristaStrategy {

    @Override
    public void socorrer(String placa) {
        System.out.println("Socorro carro de placa: " + placa);
    }

}
