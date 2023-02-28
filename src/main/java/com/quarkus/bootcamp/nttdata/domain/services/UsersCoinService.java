package com.quarkus.bootcamp.nttdata.domain.services;

import com.quarkus.bootcamp.nttdata.domain.entity.Users;
import com.quarkus.bootcamp.nttdata.domain.respository.UsersRepository;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class UsersCoinService {

    @Inject
    UsersRepository repository;

    public Uni<Users> add(Users users) {
        return repository.persist(users);
    }

    public Uni<List<Users>> getAll() {
        return repository.listAll();
    }

    public Uni<Users> getById(String id) {
        return repository.findById(new ObjectId(id));
    }

}