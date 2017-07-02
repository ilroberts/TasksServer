package com.ilroberts.tasks.dao;

import com.ilroberts.tasks.api.Task;
import com.ilroberts.tasks.core.mapper.TaskMapper;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TaskMapper.class)
public interface TaskDAO {

    @SqlQuery("select * from TASK")
    List<Task> getAll();

    @SqlQuery("select * from TASK where ID = :id")
    Task findById(@Bind("id") String id);

    @SqlUpdate("delete from TASK where ID = :id")
    int deleteById(@Bind("id") int id);

    @SqlUpdate("update TASK set TITLE = :title, DESCRIPTION = :description, DUE_DATE = :dueDate, CREATED_DATE = :createdDate where ID = :id")
    int update(@BindBean Task task);

    @SqlUpdate("insert into TASK (ID, TITLE, DESCRIPTION, CREATED_DATE, DUE_DATE) values (:id, :title, :description, :createdDate, :dueDate)")
    int insert(@BindBean Task task);

}
