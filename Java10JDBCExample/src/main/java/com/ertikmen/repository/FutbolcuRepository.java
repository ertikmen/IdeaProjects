package com.ertikmen.repository;

import com.ertikmen.repository.entity.Futbolcu;
import com.ertikmen.utility.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu>{
    private ConnectionProvider connectionProvider;

    public FutbolcuRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Futbolcu futbolcu) {
        String sql="insert into futbolcu (ad,mevki,forma_no,deger,takim_id) values ('"+futbolcu.getAd()+"','" +
                futbolcu.getMevki()+"','"+
                futbolcu.getFormaNo()+"','"+
                futbolcu.getDeger()+"','"+
                futbolcu.getTakim_id()+"'"
                +")";

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
    public void update(Futbolcu futbolcu) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Futbolcu> findAll() {
        return null;
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
        return Optional.empty();
    }
}
