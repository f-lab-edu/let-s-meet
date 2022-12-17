package org.letsmeet.api.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.letsmeet.api.dto.Promise;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/promises")
public class PromiseController {
	/**
	 * id 값 자동 생성을 위한 field
	 */
	static int sequence = 0;

	/**
	 * 더미 데이터 - 약속 목록
	 */
	private static Map<Integer, Promise> promiseList = new LinkedHashMap<>();

	/**
	 * 약속 목록 생성
	 */
	static {
		promiseList.put(sequence, new Promise(sequence++, "test1", "2022-10-04", "신림역", "test description", "1"));
		promiseList.put(sequence, new Promise(sequence++, "test2", "2022-10-12", "봉천역", "test description2", "2"));
		promiseList.put(sequence, new Promise(sequence++, "test3", "2022-10-16", "서울대입구역", "test description3", "1"));
		promiseList.put(sequence, new Promise(sequence++, "test4", "2022-10-17", "낙성대역", "test description4", "2"));
		promiseList.put(sequence, new Promise(sequence++, "test5", "2022-11-10", "사당역", "test description5", "1"));
		promiseList.put(sequence, new Promise(sequence++, "test6", "2022-11-12", "방배역", "test description6", "1"));
		promiseList.put(sequence, new Promise(sequence++, "test7", "2022-12-01", "서초역", "test description7", "2"));
		promiseList.put(sequence, new Promise(sequence++, "test8", "2022-12-02", "교대역", "test description8", "2"));
		promiseList.put(sequence, new Promise(sequence++, "test9", "2022-12-05", "강남역", "test description9", "2"));
		promiseList.put(sequence, new Promise(sequence++, "test10", "2022-12-09", "역삼역", "test description10", "1"));
	}

	@GetMapping("/single/{promiseId}")
	public Promise getPromise(@PathVariable("promiseId") int promiseId) {
		return promiseList.get(promiseId);
	}

	@GetMapping("/{groupId}")
	public List<Promise> getPromiseList(@PathVariable("groupId") String groupId) {
		return promiseList.values().stream()
			.filter(v -> v.getGroupId().equals(groupId))
			.collect(Collectors.toList());
	}
}
