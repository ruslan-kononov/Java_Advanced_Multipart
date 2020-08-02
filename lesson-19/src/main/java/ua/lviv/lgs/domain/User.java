package ua.lviv.lgs.domain;
import java.util.Objects;

public class User {
    private String name;
    private String email;
    private String password;
    private String photoId;

    public User(String name, String email, String password, String photoId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.photoId = photoId;
    }

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(email, user.email) &&
                Objects.equals(password, user.password) &&
                Objects.equals(photoId, user.photoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, password, photoId);
    }
}
