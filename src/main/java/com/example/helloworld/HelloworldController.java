package com.example.helloworld;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ComponentScan(basePackages={"com.example"})
class HelloworldController {

    public static List<String> objects = new ArrayList<String>();
    HelloworldController() {

    }

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/objects")
  List<String> all() {
    return objects;
  }

  // end::get-aggregate-root[]

  @PostMapping("/objects")
  String newEmployee(@RequestBody String obj) {
    return objects.add(obj)?obj:null;
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  String one(@PathVariable String obj) {    
    return objects.contains(obj)? obj: null;
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable String obj){
    objects.remove(obj);
  }
}
