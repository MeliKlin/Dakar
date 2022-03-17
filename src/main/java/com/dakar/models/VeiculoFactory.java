package com.dakar.models;

import com.dakar.enums.Categorias;

public class VeiculoFactory {

    public Veiculo getVeiculo(Categorias categoria) {
        if (categoria == Categorias.CARRO) {
            Veiculo carro = new Veiculo();
            carro.setRodas(4);
            carro.setPeso(1000);
            return carro;
        }
        Veiculo moto = new Veiculo();
        moto.setRodas(2);
        moto.setPeso(300);
        return moto;
    }

}
