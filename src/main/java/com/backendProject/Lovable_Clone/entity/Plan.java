package com.backendProject.Lovable_Clone.entity;

public class Plan {

    private Long id;
    private String name;
    private String stripePriceId;
    private Integer maxProjects;
    private Integer maxTokenPerDay;
    private Integer maxPreviews; // max number of previews allowed per plan
    private Boolean unlimitedAi; //unlimited access to LLM, ignore maxTokenPerDay if true

    private Boolean active;
}
