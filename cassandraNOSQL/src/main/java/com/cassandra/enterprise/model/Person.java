package com.cassandra.enterprise.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("EnterpriseData")
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Person  {

        @PrimaryKey
        private int id;
        private String first_name;
        private String last_name;
        private String email;
        private String gender;
        private String city;
        private String country;
        private String job_title;
        private String company_name;
        private String car_make;
        private int model_year;

    }


