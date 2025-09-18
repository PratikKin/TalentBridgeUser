package com.TalentBridgeUser.wrapper.utility;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JobDetails {
    private String companyName;
    private String jobTitle;
    private List<SkillRef> skills;
    private List<String> qualification;
    private String location;
    private String salary;
    private String experience;
    private String description;
    private String postedDate;
}
