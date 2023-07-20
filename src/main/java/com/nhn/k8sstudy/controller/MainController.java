package com.nhn.k8sstudy.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
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

		log.debug("DEBUG.. MainController called from {}", podName);
		log.info("INFO.. MainController called from {}", podName);
		log.warn("WARN.. MainController called from {}", podName);
		log.error("ERROR.. MainController called from {}", podName);

		return podName;
	}
}
