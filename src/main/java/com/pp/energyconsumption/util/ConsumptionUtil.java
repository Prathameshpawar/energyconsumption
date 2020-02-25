package com.pp.energyconsumption.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * 
 * @author prathameshpawar
 *
 */
public class ConsumptionUtil {
	private static List<String> lsDuration = new ArrayList<String>();

	static {
		lsDuration.add("h");
		lsDuration.add("H");
		lsDuration.add("d");
		lsDuration.add("D");
	}

	public static boolean validateDuration(String duration) {
		String checkDuration = duration.replaceAll("[0123456789]", "");
		return (duration == null || StringUtils.isEmpty(checkDuration)
				|| !lsDuration.stream().anyMatch(value -> value.contains(checkDuration)));
	}

	public static String removeNum(String input) {
		return input.replaceAll("[0123456789]", "");
	}

	public static Integer extractNumber(String input) {
		String numberOnly = input.replaceAll("[^0-9]", "");
		return Integer.valueOf(numberOnly);
	}
}
