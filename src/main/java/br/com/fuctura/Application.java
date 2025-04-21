package br.com.fuctura;

import br.com.fuctura.br.com.fuctura.service.VeiculoService;
import br.com.fuctura.controller.VeiculoController;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.view.VeiculoView;

import java.util.Scanner;

public class Application {

    private final Scanner scanner;
    private final VeiculoDAO veiculoDAO;
    private final VeiculoService veiculoService;
    private final VeiculoController veiculoController;
    private final VeiculoView veiculoView;

    public Application(){
        this.scanner = new Scanner(System.in);
        this.veiculoDAO = new VeiculoDAO();
        this.veiculoService = new VeiculoService(veiculoDAO);
        this.veiculoController = new VeiculoController(veiculoService);
        this.veiculoView = new VeiculoView();
    }

    public void run() {
        System.out.println("- Sistema Gerenciador - Veicular - ");
        System.out.println("1 - Gerenciar Veiculo");


        while (true){
            int opcao = scanner.nextInt();
            switch (opcao){
                case 1: veiculoView.exibirMenu();
                    System.out.println("Digite: ");
                    var opcaoCadastroVeiculo = scanner.nextInt();
                    switch (opcaoCadastroVeiculo){
                        case 1:
                            var veiculo = veiculoView.lerDadosVeiculo();
                            veiculoController.cadastrarVeiculo(veiculo);
                    }

            }
        }

    }

}
