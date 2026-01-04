package com.backendProject.Lovable_Clone.service.impl;

import com.backendProject.Lovable_Clone.dto.member.InviteMemberRequest;
import com.backendProject.Lovable_Clone.dto.member.MemberResponse;
import com.backendProject.Lovable_Clone.dto.member.UpdateMemberRoleRequest;
import com.backendProject.Lovable_Clone.entity.Project;
import com.backendProject.Lovable_Clone.entity.ProjectMember;
import com.backendProject.Lovable_Clone.entity.ProjectMemberId;
import com.backendProject.Lovable_Clone.entity.User;
import com.backendProject.Lovable_Clone.mapper.ProjectMemberMapper;
import com.backendProject.Lovable_Clone.repository.ProjectMemberRepository;
import com.backendProject.Lovable_Clone.repository.ProjectRepository;
import com.backendProject.Lovable_Clone.repository.UserRepository;
import com.backendProject.Lovable_Clone.service.ProjectMemberService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final ProjectMemberMapper projectMemberMapper;
    private final UserRepository userRepository;

    @Override
    public List<MemberResponse> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

//        List<MemberResponse> memberResponseList = new ArrayList<>();
//        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner())); //owner is also member of the project,so will add owner to the list
//        List<MemberResponse> memberResponseList = new ArrayList<>();
//        memberResponseList.addAll(
//        projectMemberRepository.findByProjectId(projectId)
//                .stream()
//                .map(projectMemberMapper::toProjectMemberResponseFromMember)
//                .toList());

//        return List.of();
//        return memberResponseList;

        return projectMemberRepository.findByProjectId(projectId)
                        .stream()
                        .map(projectMemberMapper::toProjectMemberResponseFromMember)
                        .toList();
    }
//  To see the members of the project-invite member
    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
//        return null;
        Project project = getAccessibleProjectById(projectId,userId);

//  Project owner should invite other ---> Check project owner is actually this userId
//        if(!project.getOwner().getId().equals(userId)){
//            throw new RuntimeException("Not Allowed");
//        } //later will take care of this in authorization part
//  Get the user via email
        User invitee = userRepository.findByUsername(request.username()).orElseThrow();
//  check invitee is user or not; maybe owner is trying to invite himself
        if(invitee.getId().equals(userId)){
            throw new RuntimeException("You cannot invite yourself");
        }

//  Check user is already not being invited
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());
//  If this ProjectMember is already exists, they've already been invited to this project & they shouldn't be invited again
        if (projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Cannot invite once again");
        }

        ProjectMember member = ProjectMember.builder()
                .id(projectMemberId)
                .project(project)
                .user(invitee)
                .projectRole(request.role())
                .invitedAt(Instant.now())
                .build();
        projectMemberRepository.save(member);
        return projectMemberMapper.toProjectMemberResponseFromMember(member);
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequest request, Long userId) {
//        return null;
        Project project = getAccessibleProjectById(projectId,userId);

// Only project owner can invite
//        if (!project.getOwner().getId().equals(userId)) {
//            throw new RuntimeException("Not authorized to invite members");
//        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());
        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);

    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {

        Project project = getAccessibleProjectById(projectId,userId);

// Only project owner can invite
//        if (!project.getOwner().getId().equals(userId)) {
//            throw new RuntimeException("Not authorized to invite members");
//        }
        ProjectMemberId projectMemberId = new ProjectMemberId(projectId,memberId);
//  If this ProjectMember is already exists, they've already been invited to this project & they shouldn't be invited again
        if (!projectMemberRepository.existsById(projectMemberId)){
            throw new RuntimeException("Member not found in the project");
        }

        projectMemberRepository.deleteById(projectMemberId);

    }
    /// Internal functions
    public Project getAccessibleProjectById(Long projectId, Long userId){
        return projectRepository.findAccessibleProjectById(projectId,userId).orElseThrow();
    }
}
