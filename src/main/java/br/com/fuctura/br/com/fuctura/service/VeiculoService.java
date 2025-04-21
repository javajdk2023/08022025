package br.com.fuctura.br.com.fuctura.service;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.dto.VeiculoDTO;
import br.com.fuctura.entidade.Veiculo;

import java.sql.SQLException;

public class VeiculoService {

    private final VeiculoDAO veiculoDAO;

    public VeiculoService(VeiculoDAO veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }

    public void salvar(VeiculoDTO veiculoDTO){
        Veiculo veiculo = convertTOVeiculo(veiculoDTO);

        try {
            veiculoDAO.salvar(veiculo);
            System.out.println("Veiculo salvo com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private Veiculo convertTOVeiculo(VeiculoDTO veiculoDTO){
        return new Veiculo(veiculoDTO.getPlaca(), veiculoDTO.getModelo(), veiculoDTO.getAno(), veiculoDTO.getValor());
    }

}
