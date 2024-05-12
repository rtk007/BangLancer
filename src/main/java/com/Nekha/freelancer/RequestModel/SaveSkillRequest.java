package com.Nekha.freelancer.RequestModel;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveSkillRequest {

    private List<String> skills;
    private int userId;

    // Getters and setters
}

