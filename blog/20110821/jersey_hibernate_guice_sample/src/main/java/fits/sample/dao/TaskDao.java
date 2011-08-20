package fits.sample.dao;

import java.util.List;

import fits.sample.model.Task;

public interface TaskDao {

	Task addTask(String title);

	List<Task> getTaskList();
}

