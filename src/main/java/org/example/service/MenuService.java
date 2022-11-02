package org.example.service;

import org.example.dataConfig.DataConfig;

public class MenuService {

    DataConfig dataConfig = new DataConfig();

    public String menu = "-- BEM VIDO! -- " + dataConfig.formatDateTime + " -- " +

            "\n" + "Digite 1 para entrada de um novo Horista " +
            "\n" + "Digite 2 para consultar vagas ocupadas " +
            "\n" + "Digite 3 registrar saída de veículo " +
            "\n" + "Digite 4 consultar uma vaga pela placa " +
            "\n" + "Digite 5 para alterar " +
            "\n" + "Digite 0 para sair ..." +
            "\n" + "-----------------------------------------";

    public void showMenu() {
        System.out.println(menu);
    }
}



