package com.stackroute.muzix.config;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SeedDataConfigTwo implements CommandLineRunner {
    @Autowired
    private TrackRepo trackRepo;

    @Override
    public void run(String... args) throws Exception {
      trackRepo.save(new Track(100,"lol","lol"));
    }
}
