package cn.edu.swpu.cins.dataCastle.model.property;

/**
 * Created by miaomiao on 17-9-28.
 */
public class Group {

    private int id;
    private String groupName;
    private int frequency;

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

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
}
