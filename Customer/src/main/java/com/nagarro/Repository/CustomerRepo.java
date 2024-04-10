package com.nagarro.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.dao.CustomerEntity;
@Repository
public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {

}
