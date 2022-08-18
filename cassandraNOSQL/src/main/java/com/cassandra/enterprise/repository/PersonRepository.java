package com.cassandra.enterprise.repository;

import com.cassandra.enterprise.model.Person;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends CassandraRepository<Person,Integer> {
}
