package com.TalentBridgeUser.wrapper;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SigninResponse {
    private String accessToken;
    private String tokenType; // usually "Bearer"
}