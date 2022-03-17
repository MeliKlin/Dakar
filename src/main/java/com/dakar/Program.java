package com.dakar;

import com.dakar.models.Corrida;

import java.math.BigDecimal;

public class Program {

    public static void main(String[] args) {
        Corrida corrida = new Corrida(5000, BigDecimal.valueOf(20000.99), "Super Corrida", 10);

        corrida.addCarro(285, 8, 45, "ABC-1234");
        corrida.addCarro(320, 5, 45, "ABC-4321");
        corrida.addCarro(240, 7, 60, "CBA-1234");
        corrida.addCarro(290, 6, 55, "CBA-4321");

        corrida.addMoto(285, 8, 40, "AAA-1234");
        corrida.addMoto(380, 2, 35, "BBB-1234");
        corrida.addMoto(320, 4, 45, "CCC-1234");
        corrida.addMoto(200, 10, 25, "AAA-4321");
        corrida.addMoto(230, 10, 45, "BBB-4321");
        corrida.addMoto(300, 8, 50, "CCC-4321");

        corrida.addCarro(120, 30, 8, "CBA-4321");
        corrida.addCarro(120, 30, 8, "CBA-4321");
    }

}
