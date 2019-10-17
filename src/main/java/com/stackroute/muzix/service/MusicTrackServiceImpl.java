package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNoteFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.repository.TrackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ListIterator;

@Repository
public class MusicTrackServiceImpl implements MusicTrackService {

    TrackRepo trackRepo;
    @Autowired
    public MusicTrackServiceImpl(TrackRepo trackRepo) {
        this.trackRepo = trackRepo;
    }

    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException {
    Track track1;
        if(trackRepo.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track Already Exist");
        }
        else {
           track1= trackRepo.save(track);
        }


        return track1;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepo.findAll();
    }

    @Override
    public void removeTrack(int trackId) throws TrackNoteFoundException {
        if (trackRepo.existsById(trackId)){
            trackRepo.deleteById(trackId);
        }
        else {
            throw new TrackNoteFoundException("Track not found");
        }

    }

    @Override
    public void updateTrackComment(Track track) throws TrackNoteFoundException {
    //    trackRepo.findAll();
        Track track1;
        if (trackRepo.existsById(track.getTrackId())){
            track1= trackRepo.findById(track.getTrackId()).get();
            track1.setTrackComment(track.getTrackComment());

        }
        else {
            throw new TrackNoteFoundException("Track not found");
        }


        trackRepo.save(track1);

    }

    @Override
    public List<Track> trackByName(String name) {
        //trackRepo.findAll();

        return trackRepo.getTrackByName(name);
    }

}
