package fits.sample.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.*;

import fits.sample.model.Task;
import fits.sample.dao.TaskDao;

@Path("/")
public class ToDoResource {
	@Inject
	private TaskDao dao;

	@GET
	@Path("task")
	@Produces("application/json")
	public List<Task> getTaskList() {
		return dao.getTaskList();
	}

	@POST
	@Path("task")
	@Produces("application/json")
	public Task addTask(@FormParam("title") String title) {
		return dao.addTask(title);
	}
}

