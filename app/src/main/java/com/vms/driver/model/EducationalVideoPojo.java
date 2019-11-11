package com.vms.driver.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;


public class EducationalVideoPojo {
        @SerializedName("EduVideo")
        @Expose
        public List<EduVideo> eduVideo = null;

        public class EduVideo {
            @SerializedName("videolonk")
            @Expose
            public String videolonk;
            @SerializedName("videoname")
            @Expose
            public String videoname;

            public EduVideo() {
            }
        }
}
