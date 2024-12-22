package ait.com.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "audit_logs")
public class AuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Integer id;

	private String action;

	private String details;

	private Integer userId;

	private LocalDateTime createdAt = LocalDateTime.now();

}
