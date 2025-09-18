package com.TalentBridgeUser.wrapper;

import com.TalentBridgeUser.dto.UserDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserRequest {
    private UserDTO user;
    private String password;

}
