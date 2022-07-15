package com.arsatapathy.resource;

import com.arsatapathy.config.DemoAppConfig;
import com.arsatapathy.model.Student;
import com.arsatapathy.service.StudentService;

import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Objects;
import java.util.Optional;

@Path("/demo-app")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DemoResource {

    private DemoAppConfig configuration;
    private StudentService studentService;

    public DemoResource(DemoAppConfig configuration, StudentService studentService) {
        this.configuration = configuration;
        this.studentService = studentService;
    }

    @GET
    @Path("/hello")
    public String hello(@QueryParam("user") String user) {
        return String.format(configuration.getTemplate(), Objects.isNull(user) ?configuration.getDefaultName() :user);
    }

    @GET
    @Path("/get/student")
    public Optional<Student> getStudent(@QueryParam("id") String id) {
        return studentService.getStudent(id);
    }

}
