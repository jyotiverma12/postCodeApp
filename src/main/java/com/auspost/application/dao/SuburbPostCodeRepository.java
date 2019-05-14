package com.auspost.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.auspost.application.model.SuburbPostCode;

@Repository
public interface SuburbPostCodeRepository extends JpaRepository<SuburbPostCode, Long> {

	@Query(value = "SELECT s FROM SuburbPostCode s where s.suburb = :suburb")
	SuburbPostCode getBySuburb(String suburb);

	@Query(value = "SELECT s FROM SuburbPostCode s where s.postCode = :postCode")
	SuburbPostCode getByPostCode(int postCode);
}
