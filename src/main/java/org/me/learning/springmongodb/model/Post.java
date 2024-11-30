package org.me.learning.springmongodb.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.Collection;

//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Document(collection = "jobPost") // this is like entity for SQL DB

public class Post {
    private String profile;
    private String desc;
    private int exp;
    private String techs [];

    public Post(String profile, String desc, int exp, String[] techs) {
        this.profile = profile;
        this.desc = desc;
        this.exp = exp;
        this.techs = techs;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public void setTechs(String[] techs) {
        this.techs = techs;
    }

    public String getProfile() {
        return profile;
    }

    public int getExp() {
        return exp;
    }

    public String getDesc() {
        return desc;
    }

    public String[] getTechs() {
        return techs;
    }

    @Override
    public String toString() {
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
