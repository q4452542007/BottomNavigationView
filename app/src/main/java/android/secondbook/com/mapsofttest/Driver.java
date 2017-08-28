package android.secondbook.com.mapsofttest;

import java.util.UUID;

/**
 * Created by Administrator on 2017/8/24.
 */

public class Driver {

    private UUID mId;
    private String mJobNumber;
    private String mPhoneNumber;
    private String mName;


    public Driver() {
        this(UUID.randomUUID());
    }

    public Driver(UUID id) {
        mId = id;
    }
    public UUID getId() {
        return mId;
    }

    public String getJobNumber() {
        return mJobNumber;
    }

    public void setJobNumber(String jobNumber) {
        mJobNumber = jobNumber;
    }

    public String getPhoneNumber() {
        return mPhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        mPhoneNumber = phoneNumber;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhotoFilename() {
        return "IMG_" + getId().toString() + ".jpg";
    }
}
