package com.irs.locator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseService {

    private static Connection connect = null;

    public static Connection prepareConnection() throws Exception {
        if(connect != null)
            return connect;
        
        Class.forName("com.mysql.jdbc.Driver");
        connect = DriverManager.getConnection("jdbc:mysql://localhost/markers?user=root&password=root");
        
        return connect;

    }
    
    public ResultSet executeQuery(PreparedStatement preparedStatement)
    {
        ResultSet resultSet = null;
        try {
            prepareConnection();
            resultSet = preparedStatement.executeQuery();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultSet;
        
    }
    
    public ResultSet getMarkers(String lat, String lng, Integer rad)
    {
        ResultSet resultSet = null;
        try {
            prepareConnection();
            PreparedStatement preparedStatement = connect.prepareStatement("SELECT id, name, address, lat, lng, ( 3959 * acos( cos( radians(?) ) * cos( radians( lat ) ) * cos( radians( lng ) - radians(?) ) + sin( radians(?) ) * sin( radians( lat ) ) ) ) AS distance FROM markers HAVING distance < ? ");
            preparedStatement.setString(1, lat);
            preparedStatement.setString(2, lng);
            preparedStatement.setString(3, lat);
            preparedStatement.setInt(4, rad);

            resultSet = executeQuery(preparedStatement);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return resultSet;
    }
    
    public String getMarkersXml(String lat, String lng, Integer rad)
    {
        StringBuilder response = new StringBuilder();
        ResultSet resultSet = getMarkers(lat, lng, rad);
        
        try {
            response.append("<markers>");
            while (resultSet != null && resultSet.next()) {
                
                response.append("<marker ");
                String id = resultSet.getString("id");
                response.append("id=\"" + id + "\" ");
                
                String name = resultSet.getString("name");
                response.append("name=\"" + name + "\" ");
                
                String address = resultSet.getString("address");
                response.append("address=\"" + address + "\" ");
                
                String latitude = resultSet.getString("lat");
                response.append("lat=\"" + latitude + "\" ");
                
                
                String longitude = resultSet.getString("lng");
                response.append("lng=\"" + longitude + "\" ");
                
                
                String distance = resultSet.getString("distance");
                response.append("distance=\"" + distance + "\"");
                
                
                response.append("/>");
                response.append("\n");
            }
            response.append("</markers>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        
        return response.toString();
    }
    
    

}
