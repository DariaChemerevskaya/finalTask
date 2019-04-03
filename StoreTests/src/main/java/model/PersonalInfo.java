package model;

public class PersonalInfo {

    private String title;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;


    public PersonalInfo(String title, String firstName, String lastName, String email,  String password, String dateOfBirth) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getEmail() {
        return email;
    }
}
