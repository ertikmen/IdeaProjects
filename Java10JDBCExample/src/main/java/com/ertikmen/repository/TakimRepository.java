package com.ertikmen.repository;

import com.ertikmen.repository.entity.Takim;
import com.ertikmen.utility.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements ICrud<Takim>{
    ConnectionProvider connectionProvider;

    public TakimRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Takim takim) {
        String sql="insert into takim(ad) values ('"+takim.getAd() +"')";
        connectionProvider.openConnection();
        try {
            PreparedStatement preparedStatement=connectionProvider.getConnection().prepareStatement(sql);
        } catch (SQLException e) {
           e.printStackTrace();
        }
        finally {
            connectionProvider.closeConnection();
        }

    }

    @Override
    public void update(Takim takim) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Takim> findAll() {
        return null;
    }

    @Override
    public Optional<Takim> findById(Long id) {
        return Optional.empty();
    }
}
