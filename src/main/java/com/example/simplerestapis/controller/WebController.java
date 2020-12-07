package com.example.simplerestapis.controller;
import com.example.simplerestapis.models.*;
import com.example.simplerestapis.repository.JobRepository;

import com.example.simplerestapis.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class WebController {

	@Autowired
	private JobRepository jobRepository;

	@RequestMapping(value = "/api/generate", method = RequestMethod.POST)
	public PostResponse Test(@RequestBody PostRequest inputPayload) {
		PostResponse response = new PostResponse();
		String uuid=UUID.randomUUID().toString();
		response.setTask(uuid);
		Job job = new Job();
		job.setId(3L);
		job.setSTATUS("IN_PROGRESS");
		job.setUUID(uuid);
		job.setGOAL(Integer.parseInt(inputPayload.getGoal()));
		job.setSTEP(Integer.parseInt(inputPayload.getStep()));
		jobRepository.save(job);
		return response;
	}

//	@RequestMapping("/tasks")
//	public List<Job> jobs() {
//		return jobRepository.findAll();
//	}

	@GetMapping("/api/tasks/{uuid}/status")
	@ResponseBody
	public StatusResponse getTaskId(@PathVariable String uuid) {
		String applicationUser = jobRepository.findByUUID(uuid);
		StatusResponse response = new StatusResponse();
		response.setResult(applicationUser);
		return response;
	}

	@GetMapping("/api/tasks/{uuid}")
	@ResponseBody
	public StatusResponse getTaskIds(@PathVariable String uuid, @RequestParam String action) {
		StatusResponse response = new StatusResponse();
		if(action.equals("get_numlist") ){
			Job job = jobRepository.findAllByUUID(uuid);
			response.setResult(job.getRESULT());
		}
		return response;
	}

}