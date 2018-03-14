package org.lua.repository;

import org.lua.entity.TodoTask;
import org.lua.repository.base.BaseRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TodoTaskDao extends BaseRepository<TodoTask, String>, JpaSpecificationExecutor<TodoTask>{

	
}
