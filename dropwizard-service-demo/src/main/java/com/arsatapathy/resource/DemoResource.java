package com.arsatapathy.resource;

import com.arsatapathy.model.Student;
import com.arsatapathy.service.StudentService;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;

@Path("/demo-app")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

    private StudentService studentService;

    public DemoResource(StudentService studentService) {
        this.studentService = studentService;
    }

    @GET
    @Path("/hello")
    public String hello() {
        return "Hello!";
    }

    @GET
    @Path("/get/student")
    public Optional<Student> getStudent(@QueryParam("id") String id) {
        return studentService.getStudent(id);
    }

}
