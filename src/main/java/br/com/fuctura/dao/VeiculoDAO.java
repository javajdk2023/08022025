package br.com.fuctura.dao;

import br.com.fuctura.entidade.Veiculo;
import br.com.fuctura.utils.JDBCUtils;

import java.sql.*;

public class VeiculoDAO {

    public Veiculo salvar(Veiculo veiculo) throws SQLException {
        Connection connection = JDBCUtils.getConnection();

        String comandoSQL = "INSERT INTO veiculo (placa, modelo, ano, valor) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(comandoSQL, Statement.RETURN_GENERATED_KEYS);

        preparedStatement.setString(1, veiculo.getPlaca());
        preparedStatement.setString(2, veiculo.getModelo());
        preparedStatement.setInt(3, veiculo.getAno());
        preparedStatement.setDouble(4, veiculo.getValor());

        int affectedRow = preparedStatement.executeUpdate();

        if(affectedRow > 0){
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if(resultSet.next()){
                int codigo = resultSet.getInt(1);
                Veiculo response = clone(veiculo);
                response.setCodigo(codigo);
                return response;
            }
        }
        throw new RuntimeException("Error on insert Veiculo");
    }

    private Veiculo clone(Veiculo veiculo){
        return new Veiculo(veiculo.getPlaca(), veiculo.getModelo(), veiculo.getAno(), veiculo.getValor());
    }
}
