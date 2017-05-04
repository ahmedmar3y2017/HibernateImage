import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "person")
public class person {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer avatarId;
  private byte[] image;

  public person() {
  }

  public person(byte[] image) {
    this.image = image;
  }

  public Integer getAvatarId() {
    return this.avatarId;
  }

  public void setAvatarId(Integer avatarId) {
    this.avatarId = avatarId;
  }

  public byte[] getImage() {
    return this.image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }

}
