package com.deadsystem.apparena.helper;

public class Util {

    public static Integer retornaPosicaoSpinnerTipos(String texto){
        Integer position;
        switch (texto){
            case "Caixa":
                position = 1;
                break;
            case "Garrafa":
                position = 2;
                break;
            case "Lata":
                position = 3;
                break;
            case "Pacote":
                position = 4;
                break;
            default:
                position = 0;
        }
        return position;
    }

}
