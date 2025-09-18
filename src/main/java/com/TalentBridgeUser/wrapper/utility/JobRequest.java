package com.TalentBridgeUser.wrapper.utility;

import com.TalentBridgeUser.wrapper.RequestInfo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JobRequest {
    private RequestInfo requestInfo;
    private JobDetails job;
}