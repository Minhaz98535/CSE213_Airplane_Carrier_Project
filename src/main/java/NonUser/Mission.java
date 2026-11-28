package NonUser;

import java.io.Serializable;
import java.time.LocalDate;

public class Mission implements Serializable {
    protected int missionId;
    protected String missionName, missionType, missionTarget, missionDescription, missionStatus, missionPriority;
    protected LocalDate missionDate;

    public Mission( int missionId, String missionName, String missionType, String missionTarget, String missionDescription, String missionStatus, String missionPriority, LocalDate missionDate) {
        this.missionId = missionId;
        this.missionName = missionName;
        this.missionType = missionType;
        this.missionTarget = missionTarget;
        this.missionDescription = missionDescription;
        this.missionStatus = missionStatus;
        this.missionPriority = missionPriority;
        this.missionDate = missionDate;
    }

    public int getMissionId() {
        return missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public String getMissionType() {
        return missionType;
    }

    public String getMissionTarget() {
        return missionTarget;
    }

    public String getMissionDescription() {
        return missionDescription;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getMissionPriority() {
        return missionPriority;
    }

    public void setMissionPriority(String missionPriority) {
        this.missionPriority = missionPriority;
    }

    public LocalDate getMissionDate() {
        return missionDate;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "missionId=" + missionId +
                ", missionName='" + missionName + '\'' +
                ", missionType='" + missionType + '\'' +
                ", missionTarget='" + missionTarget + '\'' +
                ", missionDescription='" + missionDescription + '\'' +
                ", missionStatus='" + missionStatus + '\'' +
                ", missionPriority='" + missionPriority + '\'' +
                ", missionDate=" + missionDate +
                '}';
    }

    public void updateMissionPriority(int missionId, String newPriority){

    }

    public void updateMissionStatus(int missionId, String newStatus){

    }


}
