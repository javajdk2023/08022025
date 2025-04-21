package br.com.fuctura.controller;

import br.com.fuctura.br.com.fuctura.service.VeiculoService;
import br.com.fuctura.controller.request.VeiculoRequestDTO;
import br.com.fuctura.dto.VeiculoDTO;

public class VeiculoController {

    private final VeiculoService veiculoService;

    public VeiculoController(VeiculoService veiculoService) {
        this.veiculoService = veiculoService;
    }

    public void cadastrarVeiculo(VeiculoRequestDTO requestDTO){

        var veiculoDTO = convertToVeiculoDTO(requestDTO);

        veiculoService.salvar(veiculoDTO);
    }

    private VeiculoDTO convertToVeiculoDTO(VeiculoRequestDTO requestDTO) {
        var veiculoDTO = new VeiculoDTO();
        veiculoDTO.setPlaca(requestDTO.getPlaca());
        veiculoDTO.setModelo(requestDTO.getModelo());
        veiculoDTO.setAno(requestDTO.getAno());
        veiculoDTO.setValor(requestDTO.getValor());
        return veiculoDTO;
    }
}
