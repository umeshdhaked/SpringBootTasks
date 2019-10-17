package com.stackroute.muzix.service;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNoteFoundException;
import com.stackroute.muzix.model.Track;

import java.util.List;

public interface MusicTrackService {
    public Track saveTrack(Track track) throws TrackAlreadyExistsException;
    public List<Track> getAllTrack();
    public void removeTrack(int trackId) throws TrackNoteFoundException;
    public void updateTrackComment(Track track) throws TrackNoteFoundException;
    public List<Track> trackByName(String name);
}
