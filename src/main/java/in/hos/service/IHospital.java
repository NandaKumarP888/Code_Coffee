package in.hos.service;

import java.util.List;


import in.hos.entity.Hospital;

public interface IHospital {
	
	Integer saveSpecialization(Hospital hospital);
	
	List<Hospital> getAllSpecialization();
	
	Hospital getOneSpecialization(Integer id);
	
	void deleteSpecialization(Integer id);
	
	void updateSpecialization(Hospital hospital);

}
