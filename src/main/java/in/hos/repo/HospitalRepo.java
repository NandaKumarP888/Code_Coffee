package in.hos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.hos.entity.Hospital;

public interface HospitalRepo  extends JpaRepository<Hospital, Integer>{

}
