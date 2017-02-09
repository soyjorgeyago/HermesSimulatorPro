package es.us.lsi.hermes.person;

import es.us.lsi.hermes.location.LocationLog;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Person implements Serializable {

    private static final Logger LOG = Logger.getLogger(Person.class.getName());

    private static final long serialVersionUID = 1L;

    private String email;
    private String fullName;
    private List<LocationLog> locationLogList;
    private Integer personId;
    private String username;
    private String password;
    private String sha;

    public Person() {
        super();
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;

        // Dos elementos serán iguales si tienen el mismo id.
        return new EqualsBuilder().
                append(this.personId, other.personId).
                isEquals();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSha() {
        if (sha == null || sha.length() == 0) {
            sha = new String(Hex.encodeHex(DigestUtils.sha256(email)));
        }

        return sha;
    }

    public void setSha(String sha) {
        this.sha = sha;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<LocationLog> getLocationLogList() {
        return locationLogList;
    }

    public void setLocationLogList(List<LocationLog> locationLogList) {
        this.locationLogList = locationLogList;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(19, 29).
                append(username).
                toHashCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[");
        sb.append(this.getFullName());
        sb.append("]");

        return sb.toString();
    }
}
