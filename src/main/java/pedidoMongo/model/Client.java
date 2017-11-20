package pedidoMongo.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by daniel on 15/08/17.
 */
public class Client {
    @NotNull
    private String firstName ;
    @NotNull
    private String lastName;
    @NotNull
    private String cpf;
    @NotNull
    private String state;
    @NotNull
    private String city;
    private Date date;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
