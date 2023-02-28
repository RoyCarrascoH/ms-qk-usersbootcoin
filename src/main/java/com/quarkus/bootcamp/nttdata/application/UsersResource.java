package com.quarkus.bootcamp.nttdata.application;

import com.quarkus.bootcamp.nttdata.domain.entity.Users;
import com.quarkus.bootcamp.nttdata.domain.services.UsersCoinService;
import com.quarkus.bootcamp.nttdata.response.ResponseDto;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/api/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsersResource {

    @Inject
    UsersCoinService service;

    @POST
    public Uni<Response> add(Users users) {
        return service.add(users)
                .onItem().transform(uri ->
                        Response.ok(new ResponseDto<>(200, "Se registro correctamente", uri)).status(200).build());
    }

    @GET
    public Uni<List<Users>> getAll() {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    public Uni<Users> getById(@PathParam("id") String id) {
        return service.getById(id);
    }

}
