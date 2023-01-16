package com.moviecorp.datastore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DatastoreApplication {

  public static void main(String[] args) {
    SpringApplication.run(DatastoreApplication.class, args);
    System.out.println("hello world");
  }
}
