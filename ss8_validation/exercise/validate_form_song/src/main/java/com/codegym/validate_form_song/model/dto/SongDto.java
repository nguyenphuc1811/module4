package com.codegym.validate_form_song.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


public class SongDto {

    private int id;
    @NotBlank(message = "Không đc để trống")
    @Size(max = 800,message = "< 800 ký tự")
    @Pattern(regexp = "[\\w ]+" , message = "Không có ký tự đb")
    private String name;
    @NotBlank(message = "Không đc để trống")
    @Size(max = 300,message = "< 300 ký tự")
    @Pattern(regexp = "[\\w ]+" , message = "Không có ký tự đb")
    private String artist;
    @NotBlank(message = "Không đc để trống")
    @Size(max = 1000,message = "< 1000 ký tự")
    @Pattern(regexp = "[\\w ,]+" , message = "Không có ký tự đb trừ ,")
    private String category;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
