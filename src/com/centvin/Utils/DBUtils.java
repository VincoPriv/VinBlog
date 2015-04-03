package com.centvin.Utils;

import com.centvin.entity.Base;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vinco on 15-4-3.
 * DB operation utils.
 */
public class DBUtils {
    private static String driver = "com.mysql.jdbc.Driver";
    private static String jdbcURL = "jdbc:mysql://localhost:3306/";
    private static String username = "root";
    private static String password = "zhang";

    /**
     * Generate the connection to specified db in Mysql.
     * @param database name of the database.
     * @return Connection
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static Connection getConnection(String database) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        return DriverManager.getConnection(jdbcURL + database, username, password);
    }

    /**
     * Release DB resources
     *
     * @param conn      db connection
     * @param statement statement, preparedStatement
     * @param resultSet resultSet objects
     */
    public static void releaseDB(Connection conn, Statement statement, ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Function to update record.
     *
     * @param connection connection
     * @param query      query string
     * @param args       arguments to specify which record
     * @return true: update OK, false: failure to update.
     */
    public static boolean excuteUpdate(Connection connection, String query, Object... args) {
        int status = -1;
        if (connection == null)
            return false;
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(null, preparedStatement, null);
        }
        return status >= 1;
    }

    /**
     * Function to insert a record.
     *
     * @param connection connection
     * @param query      query string
     * @param args       arguments
     * @return the id of the new record.
     */
    public static int excuteInsert(Connection connection, String query, Object... args) {
        if (connection == null)
            return -1;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        int id = -1;
        try {
            preparedStatement = connection.prepareStatement(query);
            for (int i = 0; i < args.length; i++) {
                preparedStatement.setObject(i + 1, args[i]);
            }
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(null, preparedStatement, resultSet);
        }

        return id;
    }

    /**
     * Query from database.
     * @param connection connection
     * @param base the reference of an instance of sub-class of base.
     * @param query query string
     * @param args arguments
     * @return List of results.
     */
    public static List<Base> excuteQuery(Connection connection, Base base, String query, Object... args) {
        List<Base> results = new ArrayList<Base>();
        if (connection == null) return results;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = connection.prepareStatement(query);
            int i = 1;
            for (Object obj : args) {
                preparedStatement.setObject(i++, obj);
            }
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                base.setData(resultSet);
                try {
                    Base b = base.clone();
                    results.add(b);
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseDB(null, preparedStatement, resultSet);
        }
        return results;
    }
}
