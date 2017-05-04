import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class start {
  public static void main(String[] args) {

    System.out.println("Hibernate save image into database");
    Session session = new Configuration().configure().buildSessionFactory().openSession();

    session.beginTransaction();

    // save image into database
    File file = new File("D:\\dd.jpg");
    byte[] bFile = new byte[(int) file.length()];

    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      // convert file into array of bytes
      fileInputStream.read(bFile);
      fileInputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    person avatar = new person();
    avatar.setImage(bFile);

    session.save(avatar);

    // Get image from database
    person avatar2 = (person) session.get(person.class, avatar.getAvatarId());
    byte[] bAvatar = avatar2.getImage();

    try {
      FileOutputStream fos = new FileOutputStream("E:\\gghibernate.jpg");
      fos.write(bAvatar);
      fos.close();
    } catch (Exception e) {
      e.printStackTrace();
    }

    session.getTransaction().commit();

  }
}
