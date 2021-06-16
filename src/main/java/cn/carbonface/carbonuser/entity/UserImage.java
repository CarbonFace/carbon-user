package cn.carbonface.carbonuser.entity;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;

/**
 * Classname: UserImage
 * Description: User image mongo module class
 *
 * @author carbonface <553127022@qq.com>
 * Date: 2021/6/3 17:45
 * @version v1.0
 */
@Document("UserImage")
public class UserImage implements Serializable {
    private static final long serialVersionUID = -2782034595563425427L;

    public static final String USER_NAME    ="username";
    public static final String FILE_ID      ="fileId";

    @MongoId
    private ObjectId id;

    private ObjectId fileId;

    private String username;

    public UserImage() {
    }

    public UserImage(String username, String userImageId) {
        this.username = username;
        this.fileId = new ObjectId(userImageId);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getFileId() {
        return fileId;
    }

    public void setFileId(ObjectId fileId) {
        this.fileId = fileId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
