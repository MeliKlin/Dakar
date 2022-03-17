package com.dakar.strategies;

public class SocorristaMoto implements SocorristaStrategy {

    @Override
    public void socorrer(String placa) {
        System.out.println("Socorro moto de placa: " + placa);
    }

}
