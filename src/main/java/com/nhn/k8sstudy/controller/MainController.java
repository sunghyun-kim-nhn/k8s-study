package com.nhn.k8sstudy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class MainController {
	private List<String> randomStringList = new ArrayList<>();

	@GetMapping("/api")
	public String main() {
		String podName = getPodName();

		log.debug("DEBUG.. MainController called from {}", podName);
		log.info("INFO.. MainController called from {}", podName);
		log.warn("WARN.. MainController called from {}", podName);
		log.error("ERROR.. MainController called from {}", podName);

		return "this is API. Pod name is " + podName;
	}

	@GetMapping("/cpu")
	public String cpuUsing() {
		for (int i = 0; i < 10000000; i++) {
			System.out.println("cpu using...");
		}

		return getPodName();
	}

	@GetMapping("/memory")
	public String memoryUsing() {
		for (int i = 0; i < 100000; i++) {
			randomStringList.add(RandomStringUtils.random(100));
		}

		return getPodName();
	}

	private String getPodName() {
		try {
			return Optional.ofNullable(InetAddress.getLocalHost())
				.map(InetAddress::getHostName)
				.orElse(StringUtils.EMPTY);
		} catch (UnknownHostException e) {
			return "Unknown";
		}
	}
}
