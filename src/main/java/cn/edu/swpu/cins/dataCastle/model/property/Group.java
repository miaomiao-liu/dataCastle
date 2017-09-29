package cn.edu.swpu.cins.dataCastle.model.property;

/**
 * Created by miaomiao on 17-9-28.
 */
public class Group {

    private int id;
    private String groupName;

    public Group(String groupName) {
        this.groupName = groupName;
    }

    public Group() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
