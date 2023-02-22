package by.it.academy.repositories;

import by.it.academy.entities.Tour;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TourRepositoryImpl implements TourRepository{
    @Override
    public void createTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf) {
        try {
            Connection conn = DBConnector.getConnection();
            PreparedStatement pr = conn.prepareStatement(
                    "INSERT INTO tour_table (nameTour, stateTour, costTour, hotel, additionalInf)VALUES (?,?,?,?,?)");
            pr.setString(1, nameTour);
            pr.setString(2, stateTour);
            pr.setInt(3, costTour);
            pr.setString(4, hotel);
            pr.setString(5, additionalInf);
            pr.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @SneakyThrows
    @Override
    public List<Tour> readTour() {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement("SELECT * FROM tour_table");
        ResultSet resultSet = pr.executeQuery();
        List<Tour> tours = new ArrayList<>();
        while (resultSet.next()) {
            Tour tour = new Tour();
            tour.setNameTour(resultSet.getString(1));
            tour.setStateTour(resultSet.getString(2));
            tour.setCostTour(resultSet.getInt(3));
            tour.setHotel(resultSet.getString(4));
            tour.setAdditionalInf(resultSet.getString(5));
            tours.add(tour);
        }
        return tours;
    }
    @SneakyThrows
    @Override
    public void updateTour(String nameTour, String stateTour, int costTour, String hotel, String additionalInf) {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement(
                "UPDATE tour_table SET nameTour =?, stateTour=?, costTour=?, hotel=?, additionalInf=? WHERE id=?");
        pr.setString(1, nameTour);
        pr.setString(2, stateTour);
        pr.setInt(3, costTour);
        pr.setString(4, hotel);
        pr.setString(5, additionalInf);
        pr.executeUpdate();
    }

    @SneakyThrows
    @Override
    public void deleteTour() {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pr = conn.prepareStatement("DELETE FROM tour_table WHERE id=?");
        ResultSet rs = pr.getResultSet();
        rs.deleteRow();
        pr.executeUpdate();
    }

}

