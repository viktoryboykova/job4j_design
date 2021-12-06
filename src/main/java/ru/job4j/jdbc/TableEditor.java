package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        try {
            connection = DriverManager.getConnection(properties.getProperty("hibernate.connection.url"), properties.getProperty("hibernate.connection.username"), properties.getProperty("hibernate.connection.password"));
        } catch (SQLException exception) {
            throw new RuntimeException("Connection failed", exception);
        }
    }

    public void createTable(String tableName) throws Exception {
        execute(String.format(
                    "create table if not exists %s();",
                    tableName
            ));
    }

    public void dropTable(String tableName) throws Exception {
        execute(String.format(
                    "drop table if exists %s;",
                    tableName
            ));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        execute(String.format(
                    "alter table %s add column %s %s;",
                    tableName,
                    columnName,
                    type
            ));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        execute(String.format(
                    "alter table %s drop column %s;",
                    tableName,
                    columnName
            ));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
            execute(String.format(
                    "alter table %s rename column %s to %s;",
                    tableName,
                    columnName,
                    newColumnName
            ));
    }

    public void execute(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("app.properties"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.dropTable("cats");
    }
}
