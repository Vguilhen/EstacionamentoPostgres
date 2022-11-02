package org.example;

import org.example.dao.CarroDao;
import org.example.dataConfig.DataConfig;
import org.example.model.Carro;
import org.example.service.MenuService;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        CarroDao dao = new CarroDao();
        Carro carro = new Carro();
        Scanner sc = new Scanner(System.in);
        DataConfig dataConfig = new DataConfig();
        MenuService menuService = new MenuService();
        boolean condicao = true;
        String continuar;

        while (condicao) {
            menuService.showMenu();
            int entrada = sc.nextInt();

            switch (entrada) {
                case 0:
                    condicao = false;
                    break;
                case 1:
                    System.out.print("Informe a placa do veículo:");
                    carro.setPlaca(sc.next());
                    carro.setEntrada(dataConfig.formatDateTime);
                    System.out.print("Informe a a vaga do veículo: ");
                    carro.setVaga(sc.next());
                    dao.save(carro);
                    System.out.println(" \n Entrada Confirmada! " +
                            "\n ID: " + carro.getId() +
                            "\n Vaga: " + carro.getVaga() +
                            "\n Placa: " + carro.getPlaca() +
                            "\n Entrada: " + carro.getEntrada() + "\n");
                    System.out.println("deseja continuar? s/n");
                    continuar = sc.next();
                    if (continuar.equals("n")) {
                        condicao = false;
                    }
                    break;
                case 2:
                    List<Carro> listaCarros = dao.findAll();
                    for (Carro listaCarro : listaCarros) {
                        System.out.println("ID: " + listaCarro.getId());
                        System.out.println("Vaga: " + listaCarro.getVaga());
                        System.out.println("Placa: " + listaCarro.getPlaca());
                        System.out.println("Entrada: " + listaCarro.getEntrada());
                        System.out.println("------------------------------------------------\n");
                    }
                    System.out.println("deseja continuar? s/n");
                    continuar = sc.next();
                    if (continuar.equals("n")) {
                        condicao = false;
                    }
                    break;
                case 3:
                    System.out.println("Digite o Id do veículo");
                    Long id = sc.nextLong();
                    Optional<Carro> carroOptional = dao.findById(id);
                    carroOptional.ifPresent(carr -> {
                        System.out.println("ID: " + carr.getId());
                        System.out.println("Vaga: " + carr.getVaga());
                        System.out.println("Placa: " + carr.getPlaca());
                        System.out.println("Entrada: " + carr.getEntrada());
                        System.out.println("------------------------------------------------");
                    });
                    dao.delete(id);
                    System.out.println("Horário de saída: " + dataConfig.formatDateTime);
                    System.out.println("deseja continuar? s/n");
                    continuar = sc.next();
                    if (continuar.equals("n")) {
                        condicao = false;
                    }
                    break;
                case 4:
                    System.out.println("Digite a placa do veículo");
                    String scPlaca = sc.next();
                    Optional<Carro> plcaOptional = dao.findByPlaca(scPlaca);
                    plcaOptional.ifPresent(placa -> {
                        System.out.println("\n ID: " + placa.getId());
                        System.out.println("Vaga: " + placa.getVaga());
                        System.out.println("Placa: " + placa.getPlaca());
                        System.out.println("Entrada: " + placa.getEntrada());
                        System.out.println("------------------------------------------------");
                    });
                    System.out.println("deseja continuar? s/n");
                    continuar = sc.next();
                    if (continuar.equals("n")) {
                        condicao = false;
                    }
                    break;
                case 5:
                    System.out.println("Informe o Id da Entrada que deseja alterar: ");
                    Long idAtualiza = sc.nextLong();
                    Optional<Carro> atualizaOptional = dao.findById(idAtualiza);
                    atualizaOptional.ifPresent(atualiza -> {
                        System.out.println("ID: " + atualiza.getId());
                        System.out.println("Vaga: " + atualiza.getVaga());
                        System.out.println("Placa: " + atualiza.getPlaca());
                        System.out.println("Entrada: " + atualiza.getEntrada());
                        System.out.println("------------------------------------------------");
                    });
                    Carro atualiza = atualizaOptional.get();
                    System.out.println("informe a Vaga: ");
                    String vaga = sc.next();
                    System.out.println("informe a Placa: ");
                    String placa = sc.next();
                    atualiza.setVaga(vaga);
                    atualiza.setPlaca(placa);
                    atualiza.setEntrada(dataConfig.formatDateTime);
                    dao.update(atualiza);
                    System.out.println("Entrada Atualizada com sucesso! ");
                    System.out.println("deseja continuar? s/n");
                    continuar = sc.next();
                    if (continuar.equals("n")) {
                        condicao = false;
                    }
                    break;
            }
        }
    }
}
