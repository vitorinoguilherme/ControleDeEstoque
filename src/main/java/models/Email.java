package models;

public class Email {
    private String email;

    public Email(String email) {
        this.setEmail(email);
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
