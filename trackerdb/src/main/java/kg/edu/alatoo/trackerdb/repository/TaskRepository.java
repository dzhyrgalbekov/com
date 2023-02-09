package kg.edu.alatoo.trackerdb.repository;

import kg.edu.alatoo.trackerdb.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
}
