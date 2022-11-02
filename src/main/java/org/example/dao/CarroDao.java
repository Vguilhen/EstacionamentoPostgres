package org.example.dao;

import org.example.Connection.ConnectionFactory;
import org.example.model.Carro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarroDao implements CarroDaoInterface {

    @Override
    public Carro save(Carro carro) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO Carro (placa, entrada, vaga) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, carro.getPlaca());
            preparedStatement.setString(2, carro.getEntrada());
            preparedStatement.setString(3, carro.getVaga());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            Long generatedId = resultSet.getLong("id");
            carro.setId(generatedId);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return carro;
    }

    @Override
    public Carro update(Carro carro) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE Carro SET placa = ?, entrada = ?, vaga = ? WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, carro.getPlaca());
            preparedStatement.setString(2, carro.getEntrada());
            preparedStatement.setString(3, carro.getVaga());
            preparedStatement.setLong(4, carro.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carro;
    }

    @Override
    public void delete(Long id) {

        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM Carro WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Carro> findAll() {
        String sql = "SELECT id, placa, entrada, vaga FROM Carro";

        List<Carro> carros = new ArrayList<>();

        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String placa = resultSet.getString("placa");
                String entrada = resultSet.getString("entrada");
                String vaga = resultSet.getString("vaga");

                Carro carro = new Carro(id, placa, entrada, vaga);
                carros.add(carro);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carros;
    }

    @Override
    public Optional<Carro> findById(Long id) {
        String sql = "SELECT id, placa, entrada, vaga FROM Carro WHERE id = ?";

        Carro carros = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long pk = resultSet.getLong("id");
                String placa = resultSet.getString("placa");
                String entrada = resultSet.getString("entrada");
                String vaga = resultSet.getString("vaga");

                carros = new Carro(pk, placa, entrada, vaga);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(carros);
    }

    @Override
    public Optional<Carro> findByPlaca(String placa) {
        String sql = "SELECT id, placa, entrada, vaga FROM Carro WHERE placa = ?";

        Carro carros = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, placa);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Long pk = resultSet.getLong("id");
                String placadb = resultSet.getString("placa");
                String entrada = resultSet.getString("entrada");
                String vaga = resultSet.getString("vaga");

                carros = new Carro(pk, placadb, entrada, vaga);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.ofNullable(carros);
    }
}
