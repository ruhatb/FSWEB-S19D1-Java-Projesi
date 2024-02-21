package com.workintech.s19d1.util;

import com.workintech.s19d1.dto.ActorResponse;
import com.workintech.s19d1.entity.Actor;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    public static List<ActorResponse> actorResponseConvert(List<Actor> allActors) {
        List<ActorResponse> actors = new ArrayList<>();
        for (Actor actor : allActors) {
            actors.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(), null));
        }
        return actors;
    }

    public static ActorResponse actorResponseConvert(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(), null);

    }

    public static ActorResponse actorCreateResponseConvert(Actor actor) {
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate(), actor.getMovies());

    }
}
