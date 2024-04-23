package in.hos.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.hos.entity.Hospital;
import in.hos.repo.HospitalRepo;
import in.hos.service.IHospital;

@Service
public class IHospitalImp implements IHospital{
	@Autowired
	private HospitalRepo repo;

	@Override
	public Integer saveSpecialization(Hospital hospital) {
		
		return repo.save(hospital).getCode();
	}

	@Override
	public List<Hospital> getAllSpecialization() {
		
		 return repo.findAll();
	}

	@Override
	public Hospital getOneSpecialization(Integer code) {
		return  repo.findById(code).get();
	}

	@Override
	public void deleteSpecialization(Integer code) {
		repo.deleteById(code);
		
	}

	@Override
	public void updateSpecialization(Hospital hospital) {
		repo.save(hospital);
		
	}

}
