package cn.edu.swpu.cins.dataCastle.model.view;


import java.util.List;
import java.util.Set;

/**
 * Created by miaomiao on 17-9-28.
 */
public class GroupWithMemberName {

    private String groupName;
    private List<String> groupMembers;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getGroupMembers() {
        return groupMembers;
    }

    public void setGroupMembers(List<String> groupMembers) {
        this.groupMembers = groupMembers;
    }
}
