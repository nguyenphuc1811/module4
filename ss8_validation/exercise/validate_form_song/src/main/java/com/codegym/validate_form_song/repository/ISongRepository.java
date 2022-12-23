package com.codegym.validate_form_song.repository;


import com.codegym.validate_form_song.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongRepository extends JpaRepository<Song, Integer> {
}
