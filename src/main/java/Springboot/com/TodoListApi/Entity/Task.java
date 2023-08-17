
package Springboot.com.TodoListApi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import java.util.Date;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long taskId;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	private String title;
	private String description;
	private Date dueDate;
	private boolean completed;

	public Task() {
		// Default constructor required by JPA
	}

	// Getters and setters...
}
