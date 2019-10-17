package com.stackroute.muzix.controller;

import com.stackroute.muzix.exception.TrackAlreadyExistsException;
import com.stackroute.muzix.exception.TrackNoteFoundException;
import com.stackroute.muzix.model.Track;
import com.stackroute.muzix.service.MusicTrackService;
import org.h2.engine.Mode;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws IOException, TrackAlreadyExistsException {
        ResponseEntity responseEntity;
        try {
            musicTrackService.saveTrack(track);
          responseEntity= new ResponseEntity<String>("Successful Created",HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }

      //response.sendRedirect("/index.html");
        return responseEntity;
    }
    @GetMapping("track")
    private ResponseEntity<?> displayAllTrack(){
        return new ResponseEntity<List<Track> >(musicTrackService.getAllTrack(), HttpStatus.OK);
    }
    @DeleteMapping("track")
    private ResponseEntity<?> deleteTrack(@RequestBody Track track) throws TrackNoteFoundException {
        ResponseEntity responseEntity;
        try{
            musicTrackService.removeTrack(track.getTrackId());
            responseEntity=new ResponseEntity<List<Track> >(musicTrackService.getAllTrack(), HttpStatus.OK);
        }
        catch (Exception ex){
            responseEntity = new ResponseEntity<String >(ex.getMessage(), HttpStatus.OK);
        }
        return responseEntity;
    }
    @PutMapping("track")
    private ResponseEntity<?> updateTrack(@RequestBody Track track) throws TrackNoteFoundException {
        musicTrackService.updateTrackComment(track);
       return new ResponseEntity<List<Track> >(musicTrackService.getAllTrack(), HttpStatus.OK);
    }

    @RequestMapping("byName")
    private ResponseEntity<?> trackByName(@RequestBody Track track){

        return new ResponseEntity<List<Track> >(musicTrackService.trackByName(track.getTrackName()), HttpStatus.OK);
    }




}
