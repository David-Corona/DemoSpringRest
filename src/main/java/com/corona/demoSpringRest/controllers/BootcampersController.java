package com.corona.demoSpringRest.controllers;

import com.corona.demoSpringRest.models.Bootcamper;
import com.corona.demoSpringRest.services.BootcamperService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;


@Component // indicamos que es un componente
@Path("/")
public class BootcampersController {
    private final BootcamperService bootcamperService;

    // se inyectan todos los servicios al constructor. No hará falta llamar al constructor.
    public BootcampersController(BootcamperService bootcamperService) {
        this.bootcamperService = bootcamperService;

        this.bootcamperService.add(new Bootcamper("David", Math.random()));
        this.bootcamperService.add(new Bootcamper("Eustaquio", Math.random()));
        this.bootcamperService.add(new Bootcamper("Pepe", Math.random()));
    }

    @GET
    @Path("/bootcampers")
    @Produces("application/json")// indicar el tipo de salida
    public List<Bootcamper> listarTodos() {
        return bootcamperService.getAll();
    }

    @GET
    @Path("/bootcampers/{nombre}")
    @Produces("application/json")
    public Bootcamper listarUno(@PathParam("nombre") String nombre) {
        return bootcamperService.get(nombre);
    }

    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json") // formato en que va a recibir la petición
    public Response addBootcamper(Bootcamper bootcamper) {
        bootcamperService.add(bootcamper);
        return Response.created(URI.create("/bootcampers/" + bootcamper.getNombre())).build();
    }
}
