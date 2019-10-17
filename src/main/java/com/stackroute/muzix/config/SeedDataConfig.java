package com.stackroute.muzix.config;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Configuration
public class SeedDataConfig {
@Autowired
    private TrackRepo trackRepo;

   @EventListener
    public void seed(ContextRefreshedEvent event) {
        trackRepo.save(new Track(1,"one","commentOne"));
        trackRepo.save(new Track(2,"two","ksdksmdfdsf"));
        trackRepo.save(new Track(3,"three","m sdm fms"));
        trackRepo.save(new Track(4,"four","mds f msd"));
        trackRepo.save(new Track(5,"two"," xmcxmc "));

    }

}
