package com.codegym.validate_form_song.service;


import com.codegym.validate_form_song.model.Song;
import com.codegym.validate_form_song.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;

    public void save(Song song) {
        iSongRepository.save(song);
    }
}
