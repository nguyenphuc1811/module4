package com.codegym.validate_form_song.controller;

import com.codegym.validate_form_song.model.Song;
import com.codegym.validate_form_song.model.dto.SongDto;
import com.codegym.validate_form_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class SongController {

    @Autowired
    ISongService iSongService;

    @RequestMapping("")
    public String display(Model model) {
        model.addAttribute("songDto", new SongDto());
        return "home";
    }

    @PostMapping("add")
    public String add(@Validated @ModelAttribute("songDto") SongDto songDto, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "home";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        iSongService.save(song);
        model.addAttribute("mess", "ADD thành công");
        return "result";
    }
}
