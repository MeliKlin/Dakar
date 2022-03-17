package com.dakar;

import com.dakar.models.Corrida;

import java.math.BigDecimal;

public class Program {

    public static void main(String[] args) {
        Corrida corrida = new Corrida(5000, BigDecimal.valueOf(20000.99), "Super Corrida", 10);

        corrida.addCarro(820, 8, 45, "ABC-1234");
        corrida.addCarro(620, 5, 35, "ABC-4321");
        corrida.addCarro(720, 7, 45, "CBA-1234");
        corrida.addCarro(690, 20, 55, "CBA-4321");

        corrida.addMoto(185, 5, 40, "AAA-1234");
        corrida.addMoto(280, 2, 35, "BBB-1234");
        corrida.addMoto(220, 4, 45, "CCC-1234");
        corrida.addMoto(200, 10, 45, "AAA-4321");
        corrida.addMoto(230, 8, 45, "BBB-4321");
        corrida.addMoto(200, 8, 50, "CCC-4321");

        corrida.addCarro(120, 30, 8, "CBA-4321");
        corrida.addCarro(120, 30, 8, "CBA-4321");

        corrida.deleteVeiculoComPlaca("AAA-4321");
        System.out.println(corrida.getVencedor().getPlaca());
    }

}
