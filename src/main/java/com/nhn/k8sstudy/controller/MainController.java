package com.nhn.k8sstudy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	@GetMapping("/")
	public String main() {
		String podName;
		try {
			podName = Optional.ofNullable(InetAddress.getLocalHost())
				.map(InetAddress::getHostName)
				.orElse(StringUtils.EMPTY);
		} catch (UnknownHostException e) {
			podName = "Unknown";
		}

		return podName;
	}
}
