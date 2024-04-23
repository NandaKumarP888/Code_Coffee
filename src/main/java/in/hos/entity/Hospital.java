package in.hos.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Hospital {
	
	@Id
	private Integer code;
	
	private String name;
	private String note;
	
	

}
