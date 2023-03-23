package com.trillon.camp.group.service;

import org.springframework.stereotype.Service;

import com.trillon.camp.group.repository.GroupRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroupServiceImpi implements GroupSerivce{
	
	private final GroupRepository groupRepository;

	@Override
	public Integer selectNewGampingGroupIdx() {
		return groupRepository.selectNewGampingGroup();
	}

}
