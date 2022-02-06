package person;

import java.util.Objects;

public class Interest {
    private String movie;
    private String music;
    private String hobby;
    private String gender;

    public Interest() {
    }

    public String getMovie() {
        return movie;
    }

    public String getMusic() {
        return music;
    }

    public String getHobby() {
        return hobby;
    }

    public String getGender() {
        return gender;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Interest interest = (Interest) o;
        return Objects.equals(movie, interest.movie) || Objects.equals(music, interest.music) || Objects.equals(hobby, interest.hobby) || Objects.equals(gender, interest.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(movie, music, hobby, gender);
    }

    @Override
    public String toString() {
        return "Interest{" +
                "movie='" + movie + '\'' +
                ", music='" + music + '\'' +
                ", hobby='" + hobby + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
