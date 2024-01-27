package com.nhnacademy.mini_dooray.accountapi.entitiy;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberIdsDto {
    List<String> memberIds;
}
