package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.dto.ActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.util.Converter;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
public class ActorController {

    private final ActorService actorService;

    @GetMapping
    public List<ActorResponse> findAll() {
        List<Actor> allActors = actorService.findAll();
        return Converter.actorResponseConvert(allActors);
    }


    @GetMapping("/{id}")
    public ActorResponse findById(@PathVariable long id) {
        return Converter.actorResponseConvert(actorService.findById(id));
    }

    @PostMapping
    public ActorResponse save(@Validated @RequestBody ActorRequest actorRequest) {
        List<Movie> movies = actorRequest.getMovies();
        Actor actor = actorRequest.getActor();
        for (Movie movie : movies) {
            actor.addMovie(movie);
        }
        actorService.save(actor);
        return Converter.actorCreateResponseConvert(actor);
    }

    @PutMapping("/{id}")
    public ActorResponse update(@RequestBody Actor actor, @PathVariable Long id) {
        Actor foundActor = actorService.findById(id);
        actor.setMovies(foundActor.getMovies());
        actor.setId(id);
        actorService.save(actor);
        return Converter.actorResponseConvert(actor);
    }

    @DeleteMapping("/{id}")
    public ActorResponse delete(@PathVariable long id) {
        Actor foundActor = actorService.findById(id);
        actorService.delete(foundActor);
        return Converter.actorResponseConvert(foundActor);
    }
}
