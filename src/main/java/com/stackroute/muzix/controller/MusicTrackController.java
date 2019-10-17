package com.stackroute.muzix.controller;

import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.MusicTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("tracks")
public class MusicTrackController {
    MusicTrackService musicTrackService;

    @Autowired
    public MusicTrackController(MusicTrackService musicTrackService) {
        this.musicTrackService = musicTrackService;
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            musicTrackService.saveTrack(track);
            responseEntity = new ResponseEntity<String>("Successful Created", HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.ALREADY_REPORTED);
        }

        //response.sendRedirect("/index.html");
        return responseEntity;
    }

    @GetMapping("track")
    private ResponseEntity<?> displayAllTrack() {
        try {
            return new ResponseEntity<List<Track>>(musicTrackService.getAllTrack(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }

    }

    @DeleteMapping("track")
    private ResponseEntity<?> deleteTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<String >(musicTrackService.removeTrack(track.getTrackId()) +"Is deleted" , HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }

    @PutMapping("track")
    private ResponseEntity<?> updateTrack(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            musicTrackService.updateTrackComment(track);
            responseEntity = new ResponseEntity<List<Track>>(musicTrackService.getAllTrack(), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
        }
        return responseEntity;
    }

    @RequestMapping("byName")
    private ResponseEntity<?> trackByName(@RequestBody Track track) {
        ResponseEntity responseEntity;
        try {
            responseEntity = new ResponseEntity<List<Track>>(musicTrackService.trackByName(track.getTrackName()), HttpStatus.OK);
        } catch (Exception ex) {
            responseEntity = new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return responseEntity;
    }


}
