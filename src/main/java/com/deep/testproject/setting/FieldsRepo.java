package com.deep.testproject.setting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FieldsRepo extends JpaRepository<Fields, Long> {

}
