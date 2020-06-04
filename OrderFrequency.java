package com.trinu.core.infy;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderFrequency {

	public static void main(String[] args) {
		Map<String,String>  ordersMap=new HashMap<>();
		ordersMap.put("order1", "Item1");
		ordersMap.put("order2", "Item7");
		ordersMap.put("order3", "Item1,Item2,Item7");
		ordersMap.put("order4", "Item2,Item7,Item2,Item3");
		ordersMap.put("order5", "Item7");
		//step 1: COnstruct a string with the values of given map seperated by comma as delimiter
		//step 2: Now split the newly constructed string with the delimiter. Below line will suffice that
		String[] result = ordersMap.values().stream().map(Object::toString).collect(Collectors.joining(",")).split(",");
		Map<String, Long> freqMap =
				Stream.of(result)
				.collect(Collectors.groupingBy(Function.identity(),
										Collectors.counting()));
		
	//	Display the top 2 records
				
		freqMap.entrySet().stream()
		.sorted(Comparator.comparing(e -> e.getValue(), Comparator.reverseOrder())).limit(2).forEach(e ->
		System.out.println(e.getKey() + " ---> usageCount : " + e.getValue()));
		
	}

}
