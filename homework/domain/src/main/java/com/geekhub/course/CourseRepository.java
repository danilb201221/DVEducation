package com.geekhub.course;

import com.geekhub.database.DatabaseConfig;
import com.geekhub.exeptions.DatabaseConnectionFalseException;
import com.geekhub.exeptions.PropertiesFileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class CourseRepository {
    DatabaseConfig databaseConfig = new DatabaseConfig();

    public List<CourseImpl> getCoursesList() throws PropertiesFileNotFoundException, DatabaseConnectionFalseException {
        try (Connection connection = databaseConfig.getNewConnection();
             Statement statement = connection.createStatement()
        ) {
            statement.executeQuery(
                "SELECT * FROM "
            )
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
