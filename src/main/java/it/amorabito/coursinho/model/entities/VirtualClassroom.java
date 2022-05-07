package it.amorabito.coursinho.model.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIRT")
public class VirtualClassroom extends Classroom{

    private String platform;
    private String link;
    private String password;

    @Override
    public boolean hasComputer() {
        return true;
    }

    @Override
    public boolean hasProjectors() {
        return true;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
