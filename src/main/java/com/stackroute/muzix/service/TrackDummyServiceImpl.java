package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNotFoundException;
import com.stackroute.muzix.model.Track;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary // This will have highest priorities other than Qualifier
public class TrackDummyServiceImpl implements MusicTrackService {
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
        System.out.println("saving");
        return null;
    }

    @Override
    public List<Track> getAllTrack() throws TrackNotFoundException {
        return null;
    }

    @Override
    public Track removeTrack(int trackId) throws TrackNotFoundException {
        return null;
    }

    @Override
    public void updateTrackComment(Track track) throws TrackNotFoundException {

    }

    @Override
    public List<Track> trackByName(String name) throws TrackNotFoundException {
        return null;
    }
}
