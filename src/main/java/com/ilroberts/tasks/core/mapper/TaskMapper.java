package com.ilroberts.tasks.core.mapper;

import com.ilroberts.tasks.core.Task;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class TaskMapper implements ResultSetMapper<Task> {

    public Task map(int index, ResultSet resultSet, StatementContext statementContext) throws SQLException {

        return new Task(resultSet.getString("id"),
                resultSet.getString("title"),
                resultSet.getDate("createDate"),
                resultSet.getString("description"),
                resultSet.getDate("dueDate"));
    }
}
