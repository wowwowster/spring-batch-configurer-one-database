package com.swordgroup.entity.file;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * <p>XML文件使用.<br>
 *
 * @author menghao.
 * @version 2018/4/2.
 */
@Data
@XStreamAlias("xml-user")
public class XmlUser {

    private Integer id;

    private String name;

    private Integer age;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
