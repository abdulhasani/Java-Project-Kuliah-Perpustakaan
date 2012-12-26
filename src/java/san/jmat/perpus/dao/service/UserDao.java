/*
 * |----------------JMat (Java Master)-------------------------------------|
 * |Setiap Manusia Yang Menata Hidupnya adalah Programmer                  |
 * |Hak Cipta Hanya Milik Allah SWT, Hamba-Nya Hanya Memanfaatkan.         |
 * |Manusia Tidak Bisa Mewujudkan Apa-apa, Manusia Hanya Bisa Merencanakan.| 
 * |----------------JMat (Java Master)-------------------------------------| 
 */
package san.jmat.perpus.dao.service;

import java.util.List;
import san.jmat.perpus.entity.User;

/**
 *
 * @author joker
 */
public interface UserDao {

    public void Insert(User user) throws Exception;

    public void Update(Integer id,User user) throws Exception;

    public void Delete(Integer id) throws Exception;

    public User Login(String username, String password) throws Exception;

    public List<User> selectAll() throws Exception;
}
